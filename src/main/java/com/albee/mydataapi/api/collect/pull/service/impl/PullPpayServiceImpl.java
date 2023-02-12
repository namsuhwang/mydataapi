package com.albee.mydataapi.api.collect.pull.service.impl;

import com.albee.mydataapi.api.collect.pull.models.dto.PpayParamsDto;
import com.albee.mydataapi.api.collect.pull.service.PullPpayService;
import com.albee.mydataapi.api.common.gateway.models.res.irp.Irp002ResDto;
import com.albee.mydataapi.api.common.gateway.models.res.ppay.*;
import com.albee.mydataapi.api.common.recv.models.RecvBaselineSearch;
import com.albee.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import com.albee.mydataapi.api.common.recv.service.RecvBaselineService;
import com.albee.mydataapi.common.CommUtil;
import com.albee.mydataapi.api.base.ppay.models.PpayAprHistSearch;
import com.albee.mydataapi.api.base.ppay.models.PpayBalSearch;
import com.albee.mydataapi.api.base.ppay.models.PpayHistSearch;
import com.albee.mydataapi.api.base.ppay.models.entity.PpayAprHistEntity;
import com.albee.mydataapi.api.base.ppay.models.entity.PpayBalEntity;
import com.albee.mydataapi.api.base.ppay.models.entity.PpayHistEntity;
import com.albee.mydataapi.api.base.ppay.models.form.PpayForm;
import com.albee.mydataapi.api.base.ppay.service.PpayAprHistService;
import com.albee.mydataapi.api.base.ppay.service.PpayBalService;
import com.albee.mydataapi.api.base.ppay.service.PpayHistService;
import com.albee.mydataapi.api.base.ppay.service.PpayService;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallResDto;
import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.service.CallMyDataGatewayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class PullPpayServiceImpl implements PullPpayService {

    @Autowired
    RecvBaselineService recvBaselineService;
    @Autowired CallMyDataGatewayService callMyDataGatewayService;

    @Autowired PpayService ppayService;
    @Autowired PpayBalService ppayBalService;
    @Autowired PpayHistService ppayHistService;
    @Autowired PpayAprHistService ppayAprHistService;

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> pullPpayInfoRun(ApiCallReqDto req, FormBase formBase) {
        List<String> targetList = new ArrayList<>();

        CompletableFuture<List<String>> ppay001Result = callPpay001(req, formBase);
        ppay001Result.thenAccept(ppIdList -> {
            for (String ppId : ppIdList) {
                callPpay002(req, formBase, ppId);
                callPpay003(req, formBase, ppId);
                callPpay004(req, formBase, ppId);
            }
        });

        return CompletableFuture.completedFuture(targetList);
    }


    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> callPpay001(ApiCallReqDto req, FormBase formBase) {
        req.setRequestApiId("PPAY_001");

        List<String> ppIdList = new ArrayList<>();

        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));

        // 입력 파라메터용 Map, Json 기본 설정
        PpayParamsDto ppayParamsDto = (PpayParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(ppayParamsDto.getParamsPpay001(baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Ppay001ResDto.class, Ppay001ResDetailDto.class);
        Ppay001ResDto resDto = (Ppay001ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        // 목록은 해지목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        ppayService.allDelPpay((PpayForm) formBase);

        if(CommUtil.isListNullEmpty(resDto.getList())){
            return CompletableFuture.completedFuture(ppIdList);
        }

        for (Ppay001ResDetailDto detail : resDto.getList()) {
            ppayService.regPpay(detail.getForm(formBase));
            if(detail.getIsConsent()){
                ppIdList.add(detail.getPpId());
            }
        }

        return CompletableFuture.completedFuture(ppIdList);
    }

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callPpay002(ApiCallReqDto req, FormBase formBase, String ppId) {
        req.setRequestApiId("PPAY_002");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        PpayBalEntity entity = ppayBalService.getPpayBal(new PpayBalSearch(req.getMemberId(), req.getOrgCd(), ppId));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        PpayParamsDto ppayParamsDto = (PpayParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(ppayParamsDto.getParamsPpay002(ppId, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Irp002ResDto.class);
        Ppay002ResDto resDto = (Ppay002ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        ppayBalService.modPpayBal(resDto.getForm(formBase, ppId));

        return CompletableFuture.completedFuture(new String[]{ppId});
    }

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callPpay003(ApiCallReqDto req, FormBase formBase, String ppId) {
        req.setRequestApiId("PPAY_003");
        PpayHistEntity lastHist = ppayHistService.getPpayHistLast(new PpayHistSearch(req.getMemberId(), req.getOrgCd(), ppId));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        PpayParamsDto ppayParamsDto = (PpayParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(ppayParamsDto.getParamsPpay003(ppId, lastHist.getTransDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Ppay003ResDto.class, Ppay003ResDetailDto.class);
            Ppay003ResDto resDto = (Ppay003ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (!CommUtil.isListNullEmpty(resDto.getList())) {
                for (Ppay003ResDetailDto detail : resDto.getList()) {
                    if(detail.getTransDtime().substring(0, 8).equals(lastHist.getTransDtime().substring(0, 8))){
                        ppayHistService.modPpayHist(detail.getForm(formBase, ppId));
                    }else{
                        ppayHistService.regPpayHist(detail.getForm(formBase, ppId));
                    }
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{ppId});
    }

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callPpay004(ApiCallReqDto req, FormBase formBase, String ppId) {
        req.setRequestApiId("PPAY_004");
        PpayAprHistEntity lastHist = ppayAprHistService.getPpayAprHistLast(new PpayAprHistSearch(req.getMemberId(), req.getOrgCd(), ppId));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        PpayParamsDto ppayParamsDto = (PpayParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(ppayParamsDto.getParamsPpay004(ppId, lastHist.getTransDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Ppay004ResDto.class, Ppay004ResDetailDto.class);
            Ppay004ResDto resDto = (Ppay004ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Ppay004ResDetailDto detail : resDto.getList()) {
                    ppayAprHistService.regPpayAprHist(detail.getForm(formBase, ppId));
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{ppId});
    }
}
