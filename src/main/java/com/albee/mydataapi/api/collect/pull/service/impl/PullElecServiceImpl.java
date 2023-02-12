package com.albee.mydataapi.api.collect.pull.service.impl;

import com.albee.mydataapi.api.base.elec.models.*;
import com.albee.mydataapi.api.base.elec.models.entity.*;
import com.albee.mydataapi.api.base.elec.models.form.ElecPpayAutoChargeForm;
import com.albee.mydataapi.api.base.elec.models.form.ElecPpayForm;
import com.albee.mydataapi.api.base.elec.service.*;
import com.albee.mydataapi.api.collect.pull.models.dto.ElecParamsDto;
import com.albee.mydataapi.api.collect.pull.service.PullElecService;
import com.albee.mydataapi.api.common.api.models.entity.ApiMstEntity;
import com.albee.mydataapi.api.common.api.service.ApiMstService;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallResDto;
import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.models.res.elec.*;
import com.albee.mydataapi.api.common.gateway.service.CallMyDataGatewayService;
import com.albee.mydataapi.api.common.recv.models.RecvBaselineSearch;
import com.albee.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import com.albee.mydataapi.api.common.recv.models.form.RecvStatusForm;
import com.albee.mydataapi.api.common.recv.service.RecvBaselineService;
import com.albee.mydataapi.api.common.recv.service.RecvStatusService;
import com.albee.mydataapi.common.CommUtil;
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
public class PullElecServiceImpl implements PullElecService {

    @Autowired
    ApiMstService apiMstService;
    @Autowired
    RecvBaselineService recvBaselineService;
    @Autowired
    RecvStatusService recvStatusService;
    @Autowired CallMyDataGatewayService callMyDataGatewayService;

    @Autowired ElecAccService elecAccService;
    @Autowired ElecPayHistService elecPayHistService;
    @Autowired ElecPayMethodService elecPayMethodService;
    @Autowired ElecPpayAccService elecPpayAccService;
    @Autowired ElecPpayAutoChargeService elecPpayAutoChargeService;
    @Autowired ElecPpayBalService elecPpayBalService;
    @Autowired ElecPpayHistService elecPpayHistService;
    @Autowired ElecPpayService elecPpayService;

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> pullElecInfoRun(ApiCallReqDto req, RecvStatusForm recvStatusForm) {
        List<String> targetList = new ArrayList<>();

        FormBase formBase = new FormBase(req.getMemberId(), req.getOrgCd());
        formBase.setApiTranDay(req.getApiTranDay());

        // 전송여부가 자산목록인 건 조회.
        // MEMBER_TOKEM.SCOPE_LIST 의 첫번째는 무조건 자산목록(*.list) scope 라고 가정.
        /* 자산목록 요청인 건만 먼저 조회하여 조회해야할 자산목록 설정(예:계좌목록)  */

        // 보유자산목록(*.list)을 조회하기 위한 API 정보
        ApiMstEntity assetListQryApiEntity = apiMstService.getApiListByScope(req.getMemberToken().getScopeLists().get(0)).get(0);
        req.setRequestApiId(assetListQryApiEntity.getApiId());
        req.setRequestUrl(assetListQryApiEntity.getApiUrlResource());

        // 수신 상태 업데이트. 기관코드 + API 별로 수신시작/종료 상태 저장.
        recvStatusService.updRecvStatus(recvStatusForm, 1, req.getOrgCd());

        CompletableFuture<List<String[]>> elec001Result = callElec001(req, formBase);
        elec001Result.thenAccept(elecList -> {
            for (String[] elec : elecList) {
                callElec002(req, formBase, elec[0], elec[1]);
                callElec003(req, formBase, elec[0], elec[1]);
                callElec004(req, formBase, elec[0], elec[1]);
            }
        });

        CompletableFuture<List<String>> elec101Result = callElec101(req, formBase);
        elec101Result.thenAccept(subKeyList -> {
            for (String subKey : subKeyList) {
                callElec102(req, formBase, subKey);
                callElec103(req, formBase, subKey);
            }
        });


        // 수신 상태 업데이트. 기관코드 + API 별로 종료 상태 저장.
        recvStatusForm.setRecvStatus("1");
        recvStatusForm.setRecvEndDt(CommUtil.getCurrentDateTime14());
        recvStatusService.updRecvStatus(recvStatusForm);
        return CompletableFuture.completedFuture(targetList);
    }


    // ELEC_PPAY 선불전자지급수단 목록, ELEC_PPAY_ACC 전자금융 선불전자지급수단 목록 계정
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String[]>> callElec001(ApiCallReqDto req, FormBase formBase) {
        req.setRequestApiId("ELEC_001");

        List<String[]> elecList = new ArrayList<>();

        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));
        String nextPage = baseline.getNextPage();

        // 입력 파라메터용 Map, Json 기본 설정
        ElecParamsDto elecParamsDto = (ElecParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            req.setReqParamJson(elecParamsDto.getParamsElec001(baseline.getSearchTimeStamp(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Elec001ResDto.class, Elec001ResDetailDto.class);
            Elec001ResDto resDto = (Elec001ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            // 목록은 해지목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
            elecPpayService.allDelElecPpay((ElecPpayForm) formBase);

            if(CommUtil.isListNullEmpty(resDto.getList())){
                return CompletableFuture.completedFuture(elecList);
            }

            for (Elec001ResDetailDto detail : resDto.getList()) {
                elecPpayService.regElecPpay(detail.getForm(formBase));

                // 계정
                if (!CommUtil.isListNullEmpty(detail.getList())) {
                    for (Elec001ResDetailAccountDto account : detail.getList()) {
                        elecPpayAccService.modElecPpayAcc(account.getForm(formBase, detail.getFobId()));
                        if(detail.getIsConsent()){
                            elecList.add(new String[]{detail.getFobId(), account.getAccountId()});
                        }
                    }
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(elecList);
    }

    // ELEC_PPAY_BAL 선불전자지급수단 잔액정보
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callElec002(ApiCallReqDto req, FormBase formBase, String fobId, String accountId) {
        req.setRequestApiId("ELEC_002");

        ElecPpayBalEntity entity = elecPpayBalService.getElecPpayBal(new ElecPpayBalSearch(req.getMemberId(), req.getOrgCd(), fobId, accountId));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        ElecParamsDto elecParamsDto = (ElecParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(elecParamsDto.getParamsElec002(fobId, accountId, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Elec002ResDto.class);
        Elec002ResDto resDto = (Elec002ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        elecPpayBalService.modElecPpayBal(resDto.getForm(formBase, fobId, accountId));

        return CompletableFuture.completedFuture(new String[]{fobId, accountId});
    }

    // ELEC_PPAY_AUTO_CHARGE. 전자금융 선불전자지급수단 자동충전정보
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callElec003(ApiCallReqDto req, FormBase formBase, String fobId, String accountId) {
        req.setRequestApiId("ELEC_003");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        ElecPpayAutoChargeEntity lastHist = elecPpayAutoChargeService.getElecPpayAutoChargeLast(new ElecPpayAutoChargeSearch(req.getMemberId(), req.getOrgCd(), fobId, accountId));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        ElecParamsDto elecParamsDto = (ElecParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(elecParamsDto.getParamsElec003(fobId, accountId, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Elec003ResDto.class, Elec003ResDetailDto.class);
        Elec003ResDto resDto = (Elec003ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        ElecPpayAutoChargeForm form = (ElecPpayAutoChargeForm) formBase;
        form.setFobId(fobId);
        form.setAccountId(accountId);
        elecPpayAutoChargeService.allDelElecPpayAutoCharge(form);

        if(CommUtil.isListNullEmpty(resDto.getList())){
            return CompletableFuture.completedFuture(new String[]{fobId, accountId});
        }

        for (Elec003ResDetailDto detail : resDto.getList()) {
            elecPpayAutoChargeService.regElecPpayAutoCharge(detail.getForm(formBase, fobId, accountId));
        }

        return CompletableFuture.completedFuture(new String[]{fobId, accountId});
    }

    // ELEC_PPAY_HIST 선불 거래내역
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callElec004(ApiCallReqDto req, FormBase formBase, String fobId, String accountId) {
        req.setRequestApiId("ELEC_004");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        ElecPpayHistEntity lastHist = elecPpayHistService.getElecPpayHistLast(new ElecPpayHistSearch(req.getMemberId(), req.getOrgCd(), fobId, accountId));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        ElecParamsDto elecParamsDto = (ElecParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            req.setReqParamJson(elecParamsDto.getParamsElec004(fobId, accountId, lastHist.getTransDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Elec004ResDto.class, Elec004ResDetailDto.class);
            Elec004ResDto resDto = (Elec004ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if(CommUtil.isListNullEmpty(resDto.getList())){
                return CompletableFuture.completedFuture(new String[]{fobId, accountId});
            }

            for (Elec004ResDetailDto detail : resDto.getList()) {
                if(detail.getTransDtime().substring(0, 8).equals(lastHist.getTransDtime().substring(0, 8))){
                    elecPpayHistService.modElecPpayHist(detail.getForm(formBase, fobId, accountId));
                }else {
                    elecPpayHistService.regElecPpayHist(detail.getForm(formBase, fobId, accountId));
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{fobId, accountId});
    }

    // ELEC_ACC 전자금융 계정 목록
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> callElec101(ApiCallReqDto req, FormBase formBase) {
        req.setRequestApiId("ELEC_101");

        List<String> subKeyList = new ArrayList<>();

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        ElecParamsDto elecParamsDto = (ElecParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            req.setReqParamJson(elecParamsDto.getParamsElec101(baseline.getSearchTimeStamp(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Elec101ResDto.class, Elec101ResDetailDto.class);
            Elec101ResDto resDto = (Elec101ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if(CommUtil.isListNullEmpty(resDto.getList())){
                return CompletableFuture.completedFuture(subKeyList);
            }

            for (Elec101ResDetailDto detail : resDto.getList()) {
                elecAccService.regElecAcc(detail.getForm(formBase));
                if(detail.getIsConsent()) {
                    subKeyList.add(detail.getSubKey());
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(subKeyList);
    }


    // ELEC_PAY_METHOD 전자금융 결제수단 등록 정보
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callElec102(ApiCallReqDto req, FormBase formBase, String subKey) {
        req.setRequestApiId("ELEC_102");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        ElecPayMethodEntity lastHist = elecPayMethodService.getElecPayMethodLast(new ElecPayMethodSearch(req.getMemberId(), req.getOrgCd(), subKey));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        ElecParamsDto elecParamsDto = (ElecParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        req.setReqParamJson(elecParamsDto.getParamsElec102(subKey, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Elec102ResDto.class, Elec102ResDetailDto.class);
        Elec102ResDto resDto = (Elec102ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        if(CommUtil.isListNullEmpty(resDto.getList())){
            return CompletableFuture.completedFuture(new String[]{subKey});
        }

        for (Elec102ResDetailDto detail : resDto.getList()) {
            elecPayMethodService.regElecPayMethod(detail.getForm(formBase, subKey));
        }

        return CompletableFuture.completedFuture(new String[]{subKey});
    }

    // ELEC_PAY_HIST 전자금융 결제내역
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callElec103(ApiCallReqDto req, FormBase formBase, String subKey) {
        req.setRequestApiId("ELEC_103");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        ElecPayHistEntity lastHist = elecPayHistService.getElecPayHistLast(new ElecPayHistSearch(req.getMemberId(), req.getOrgCd(), subKey));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        ElecParamsDto elecParamsDto = (ElecParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            req.setReqParamJson(elecParamsDto.getParamsElec103(subKey, lastHist.getTransDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Elec103ResDto.class, Elec103ResDetailDto.class);
            Elec103ResDto resDto = (Elec103ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if(CommUtil.isListNullEmpty(resDto.getList())){
                return CompletableFuture.completedFuture(new String[]{subKey});
            }

            for (Elec103ResDetailDto detail : resDto.getList()) {
                if(lastHist.getTransDtime().substring(0, 8).equals(detail.getTransDtime().substring(0, 8))) {
                    elecPayHistService.modElecPayHist(detail.getForm(formBase, subKey));
                }else{
                    elecPayHistService.regElecPayHist(detail.getForm(formBase, subKey));
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{subKey});
    }

}
