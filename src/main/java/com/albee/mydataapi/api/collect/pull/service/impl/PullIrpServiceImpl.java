package com.albee.mydataapi.api.collect.pull.service.impl;

import com.albee.mydataapi.api.base.irp.models.IrpAccAddSearch;
import com.albee.mydataapi.api.base.irp.models.IrpAccBaseSearch;
import com.albee.mydataapi.api.base.irp.models.IrpAccHistSearch;
import com.albee.mydataapi.api.base.irp.models.form.IrpAccAddForm;
import com.albee.mydataapi.api.base.irp.models.form.IrpAccForm;
import com.albee.mydataapi.api.common.recv.models.RecvBaselineSearch;
import com.albee.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import com.albee.mydataapi.api.common.recv.service.RecvBaselineService;
import com.albee.mydataapi.common.CommUtil;
import com.albee.mydataapi.api.base.irp.models.entity.IrpAccAddEntity;
import com.albee.mydataapi.api.base.irp.models.entity.IrpAccBaseEntity;
import com.albee.mydataapi.api.base.irp.models.entity.IrpAccHistEntity;
import com.albee.mydataapi.api.base.irp.service.IrpAccAddService;
import com.albee.mydataapi.api.base.irp.service.IrpAccBaseService;
import com.albee.mydataapi.api.base.irp.service.IrpAccHistService;
import com.albee.mydataapi.api.base.irp.service.IrpAccService;
import com.albee.mydataapi.api.collect.pull.models.dto.IrpParamsDto;
import com.albee.mydataapi.api.collect.pull.service.PullIrpService;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallResDto;
import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.service.CallMyDataGatewayService;
import com.albee.mydataapi.api.common.gateway.models.res.irp.*;
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
public class PullIrpServiceImpl implements PullIrpService {

    @Autowired
    RecvBaselineService recvBaselineService;
    @Autowired CallMyDataGatewayService callMyDataGatewayService;

    @Autowired IrpAccService irpAccService;
    @Autowired IrpAccBaseService irpAccBaseService;
    @Autowired IrpAccAddService irpAccAddService;
    @Autowired IrpAccHistService irpAccHistService;

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> pullIrpInfoRun(ApiCallReqDto req, FormBase formBase) {
        List<String> targetList = new ArrayList<>();

        CompletableFuture<List<String>> irp001Result = callIrp001(req, formBase);
        irp001Result.thenAccept(accList -> {
            for (String accNo : accList) {
                callIrp002(req, formBase, accNo);
                callIrp003(req, formBase, accNo);
                callIrp004(req, formBase, accNo);
            }
        });

        return CompletableFuture.completedFuture(targetList);
    }


    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> callIrp001(ApiCallReqDto req, FormBase formBase) {
        req.setRequestApiId("IRP_001");

        List<String> accList = new ArrayList<>();

        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));

        // 입력 파라메터용 Map, Json 기본 설정
        IrpParamsDto irpParamsDto = (IrpParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(irpParamsDto.getParamsIrp001(baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Irp001ResDto.class, Irp001ResDetailDto.class);
        Irp001ResDto resDto = (Irp001ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        // 계좌목록은 해지계좌목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        irpAccService.allDelIrpAcc((IrpAccForm) formBase);

        if(CommUtil.isListNullEmpty(resDto.getList())){
            return CompletableFuture.completedFuture(accList);
        }

        for (Irp001ResDetailDto detail : resDto.getList()) {
            irpAccService.regIrpAcc(detail.getForm(formBase));
            if(detail.getIsConsent()){
                accList.add(detail.getAccountNum());
            }
        }
        return CompletableFuture.completedFuture(accList);
    }

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callIrp002(ApiCallReqDto req, FormBase formBase, String accNo) {
        req.setRequestApiId("IRP_002");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        IrpAccBaseEntity entity = irpAccBaseService.getIrpAccBase(new IrpAccBaseSearch(req.getMemberId(), req.getOrgCd(), accNo));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        IrpParamsDto irpParamsDto = (IrpParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(irpParamsDto.getParamsIrp002(accNo, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Irp002ResDto.class);
        Irp002ResDto resDto = (Irp002ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        irpAccBaseService.modIrpAccBase(resDto.getForm(formBase, accNo));

        return CompletableFuture.completedFuture(new String[]{accNo});
    }

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callIrp003(ApiCallReqDto req, FormBase formBase, String accNo) {
        req.setRequestApiId("IRP_003");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        IrpAccAddEntity entity = irpAccAddService.getIrpAccAddLast(new IrpAccAddSearch(req.getMemberId(), req.getOrgCd(), accNo));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        IrpParamsDto irpParamsDto = (IrpParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(irpParamsDto.getParamsIrp003(accNo, baseline.getSearchTimeStamp(), baseline.getNextPage()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Irp003ResDto.class, Irp003ResDetailDto.class);
        Irp003ResDto resDto = (Irp003ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        IrpAccAddForm form = (IrpAccAddForm) formBase;
        form.setAccountNum(accNo);
        irpAccAddService.allDelIrpAccAdd(form);

        if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
            for (Irp003ResDetailDto detail : resDto.getList()) {
                irpAccAddService.regIrpAccAdd(detail.getForm(formBase, accNo));
            }
        }
        return CompletableFuture.completedFuture(new String[]{accNo});
    }

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callIrp004(ApiCallReqDto req, FormBase formBase, String accNo) {
        req.setRequestApiId("IRP_004");
        IrpAccHistEntity lastHist = irpAccHistService.getIrpAccHistLast(new IrpAccHistSearch(req.getMemberId(), req.getOrgCd(), accNo));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        IrpParamsDto irpParamsDto = (IrpParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(irpParamsDto.getParamsIrp004(accNo, lastHist.getTransDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Irp004ResDto.class, Irp004ResDetailDto.class);
            Irp004ResDto resDto = (Irp004ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Irp004ResDetailDto detail : resDto.getList()) {
                    irpAccHistService.regIrpAccHist(detail.getForm(formBase, accNo));
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{accNo});
    }
}
