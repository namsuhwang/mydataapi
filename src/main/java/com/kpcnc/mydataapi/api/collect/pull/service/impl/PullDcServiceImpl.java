package com.kpcnc.mydataapi.api.collect.pull.service.impl;

import com.kpcnc.mydataapi.api.base.bond.models.BondSearch;
import com.kpcnc.mydataapi.api.base.bond.models.entity.BondEntity;
import com.kpcnc.mydataapi.api.base.bond.models.form.BondForm;
import com.kpcnc.mydataapi.api.base.dc.models.DcAddSearch;
import com.kpcnc.mydataapi.api.base.dc.models.DcBaseSearch;
import com.kpcnc.mydataapi.api.base.dc.models.DcHistSearch;
import com.kpcnc.mydataapi.api.base.dc.models.DcSearch;
import com.kpcnc.mydataapi.api.base.dc.models.entity.DcAddEntity;
import com.kpcnc.mydataapi.api.base.dc.models.entity.DcBaseEntity;
import com.kpcnc.mydataapi.api.base.dc.models.entity.DcEntity;
import com.kpcnc.mydataapi.api.base.dc.models.entity.DcHistEntity;
import com.kpcnc.mydataapi.api.base.dc.models.form.DcForm;
import com.kpcnc.mydataapi.api.base.dc.service.DcAddService;
import com.kpcnc.mydataapi.api.base.dc.service.DcBaseService;
import com.kpcnc.mydataapi.api.base.dc.service.DcHistService;
import com.kpcnc.mydataapi.api.base.dc.service.DcService;
import com.kpcnc.mydataapi.api.base.ppay.models.PpayAprHistSearch;
import com.kpcnc.mydataapi.api.base.ppay.models.PpayBalSearch;
import com.kpcnc.mydataapi.api.base.ppay.models.PpayHistSearch;
import com.kpcnc.mydataapi.api.base.ppay.models.entity.PpayAprHistEntity;
import com.kpcnc.mydataapi.api.base.ppay.models.entity.PpayBalEntity;
import com.kpcnc.mydataapi.api.base.ppay.models.entity.PpayHistEntity;
import com.kpcnc.mydataapi.api.base.ppay.models.form.PpayForm;
import com.kpcnc.mydataapi.api.base.ppay.service.PpayAprHistService;
import com.kpcnc.mydataapi.api.base.ppay.service.PpayBalService;
import com.kpcnc.mydataapi.api.base.ppay.service.PpayHistService;
import com.kpcnc.mydataapi.api.base.ppay.service.PpayService;
import com.kpcnc.mydataapi.api.collect.pull.models.dto.BondParamsDto;
import com.kpcnc.mydataapi.api.collect.pull.models.dto.DcParamsDto;
import com.kpcnc.mydataapi.api.collect.pull.models.dto.PpayParamsDto;
import com.kpcnc.mydataapi.api.collect.pull.service.PullDcService;
import com.kpcnc.mydataapi.api.collect.pull.service.PullPpayService;
import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;
import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallResDto;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import com.kpcnc.mydataapi.api.common.gateway.models.res.bond.Bond001ResDetailDto;
import com.kpcnc.mydataapi.api.common.gateway.models.res.bond.Bond001ResDto;
import com.kpcnc.mydataapi.api.common.gateway.models.res.dc.*;
import com.kpcnc.mydataapi.api.common.gateway.models.res.irp.Irp002ResDto;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ppay.*;
import com.kpcnc.mydataapi.api.common.gateway.service.CallMyDataGatewayService;
import com.kpcnc.mydataapi.api.common.recv.models.RecvBaselineSearch;
import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import com.kpcnc.mydataapi.api.common.recv.service.RecvBaselineService;
import com.kpcnc.mydataapi.common.CommUtil;
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
public class PullDcServiceImpl implements PullDcService {

    @Autowired RecvBaselineService recvBaselineService;
    @Autowired CallMyDataGatewayService callMyDataGatewayService;

    @Autowired DcService dcService;
    @Autowired DcBaseService dcBaseService;
    @Autowired DcAddService dcAddService;
    @Autowired DcHistService dcHistService;

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> pullDcInfoRun(ApiCallReqDto req, FormBase formBase) {
        req.setRequestApiId("DC_001");
        List<String> targetList = new ArrayList<>();

        CompletableFuture<List<String>> dc001Result = callDc001(req, formBase);
        dc001Result.thenAccept(dcNumList -> {
            for (String dcNum : dcNumList) {
                callDc002(req, formBase, dcNum);
                callDc003(req, formBase, dcNum);
                callDc004(req, formBase, dcNum);
            }
        });

        return CompletableFuture.completedFuture(targetList);
    }

    /*
        DC_001 (BOND)  목록
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> callDc001(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("DC_001");

        List<String> dcNumList = new ArrayList<>();

        // 입력 파라메터용 Map, Json 기본 설정
        DcParamsDto dcParamsDto = (DcParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));

        req.setReqParamJson(dcParamsDto.getParamsDc001(baseline.getSearchTimeStamp(), baseline.getNextPage()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Dc001ResDto.class, Dc001ResDetailDto.class);
        Dc001ResDto resDto = (Dc001ResDto) resInfo.getData();

        // 해지건을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        dcService.allDelDc((DcForm) formBase);

        formBase.setApiTranId(resDto.getXApiTranId());
        List<Dc001ResDetailDto> dcInfoList = resDto.getList();

        // 테이블 반영
        for(Dc001ResDetailDto detail : dcInfoList){
            dcService.regDc(detail.getForm(formBase));
            if(detail.getIsConsent()){
                dcNumList.add(detail.getDcNum());
            }
        }

        return CompletableFuture.completedFuture(dcNumList);
    }

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callDc002(ApiCallReqDto req, FormBase formBase, String dcNum) {
        req.setRequestApiId("DC_002");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        DcBaseEntity entity = dcBaseService.getDcBase(new DcBaseSearch(req.getMemberId(), req.getOrgCd(), dcNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        DcParamsDto dcParamsDto = (DcParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(dcParamsDto.getParamsDc002(dcNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Dc002ResDto.class);
        Dc002ResDto resDto = (Dc002ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        dcBaseService.modDcBase(resDto.getForm(formBase, dcNum));

        return CompletableFuture.completedFuture(new String[]{dcNum});
    }

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callDc003(ApiCallReqDto req, FormBase formBase, String dcNum) {
        req.setRequestApiId("DC_003");
        DcHistEntity lastHist = dcHistService.getDcHistLast(new DcHistSearch(req.getMemberId(), req.getOrgCd(), dcNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        DcParamsDto dcParamsDto = (DcParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(dcParamsDto.getParamsDc003(dcNum, lastHist.getTransDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Dc003ResDto.class, Dc003ResDetailDto.class);
            Dc003ResDto resDto = (Dc003ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Dc003ResDetailDto detail : resDto.getList()) {
                    if(lastHist.getTransDtime().substring(0, 8).equals(detail.getTransDtime().substring(0, 8))) {
                        dcHistService.modDcHist(detail.getForm(formBase, dcNum));
                    }else{
                        dcHistService.regDcHist(detail.getForm(formBase, dcNum));
                    }
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{dcNum});
    }

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callDc004(ApiCallReqDto req, FormBase formBase, String dcNum) {
        req.setRequestApiId("DC_004");
        DcAddEntity lastHist = dcAddService.getDcAddLast(new DcAddSearch(req.getMemberId(), req.getOrgCd(), dcNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        DcParamsDto dcParamsDto = (DcParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(dcParamsDto.getParamsDc004(dcNum, baseline.getSearchTimeStamp(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Dc004ResDto.class, Dc004ResDetailDto.class);
            Dc004ResDto resDto = (Dc004ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Dc004ResDetailDto detail : resDto.getList()) {
                    dcAddService.modDcAdd(detail.getForm(formBase, dcNum));
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{dcNum});
    }
}
