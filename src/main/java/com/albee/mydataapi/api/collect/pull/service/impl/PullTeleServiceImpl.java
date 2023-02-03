package com.albee.mydataapi.api.collect.pull.service.impl;

import com.albee.mydataapi.api.base.tele.models.*;
import com.albee.mydataapi.api.base.tele.models.entity.*;
import com.albee.mydataapi.api.base.tele.models.form.TeleContForm;
import com.albee.mydataapi.api.base.tele.service.*;
import com.albee.mydataapi.api.collect.pull.models.dto.TeleParamsDto;
import com.albee.mydataapi.api.collect.pull.service.PullTeleService;
import com.albee.mydataapi.api.common.api.models.entity.ApiMstEntity;
import com.albee.mydataapi.api.common.api.service.ApiMstService;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallResDto;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.models.res.tele.*;
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
public class PullTeleServiceImpl implements PullTeleService {

    @Autowired
    ApiMstService apiMstService;
    @Autowired
    RecvStatusService recvStatusService;
    @Autowired
    RecvBaselineService recvBaselineService;
    @Autowired CallMyDataGatewayService callMyDataGatewayService;

    @Autowired
    TeleContService teleContService;
    @Autowired
    TeleChargeService teleChargeService;
    @Autowired
    TeleHistService teleHistService;
    @Autowired
    TelePayService telePayService;

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> pullTeleInfoRun(ApiCallReqDto req, RecvStatusForm recvStatusForm) {
        List<String> targetList = new ArrayList<>();

        FormBase formBase = new FormBase(req.getMemberId(), req.getOrgCd());
        formBase.setApiTranDay(req.getApiTranDay());

        // 보유자산목록(*.list)을 조회하기 위한 API 정보
        ApiMstEntity assetListQryApiEntity = apiMstService.getApiListByScope(req.getMemberToken().getScopeLists().get(0)).get(0);
        req.setRequestApiId(assetListQryApiEntity.getApiId());
        req.setRequestUrl(assetListQryApiEntity.getApiUrlResource());

        // 수신 상태 업데이트. 기관코드 + API 별로 수신시작/종료 상태 저장.
        recvStatusService.updRecvStatus(recvStatusForm, 1, req.getOrgCd());

        CompletableFuture<List<String[]>> tele001Result = callTele001(req, formBase);
        tele001Result.thenAccept(teleList -> {
            for (String[] tele : teleList) {
                callTele002(req, formBase, tele[0]);
                callTele003(req, formBase, tele[0]);
                callTele004(req, formBase, tele[0]);
            }
        });

        // 수신 상태 업데이트. 기관코드 + API 별로 종료 상태 저장.
        recvStatusForm.setRecvStatus("1");
        recvStatusForm.setRecvEndDt(CommUtil.getCurrentDateTime14());
        recvStatusService.updRecvStatus(recvStatusForm);
        return CompletableFuture.completedFuture(targetList);
    }


    // TELE_CONT. 통신 계약 목록
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String[]>> callTele001(ApiCallReqDto req, FormBase formBase) {
        req.setRequestApiId("TELE_001");

        List<String[]> teleList = new ArrayList<>();

        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));
        String nextPage = baseline.getNextPage();

        // 입력 파라메터용 Map, Json 기본 설정
        TeleParamsDto teleParamsDto = (TeleParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());


        while(true) {
            req.setReqParamJson(teleParamsDto.getParamsTele001(baseline.getSearchTimeStamp(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Tele001ResDto.class, Tele001ResDetailDto.class);
            Tele001ResDto resDto = (Tele001ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            // 목록은 해지목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
            teleContService.allDelTeleCont((TeleContForm) formBase);

            if(CommUtil.isListNullEmpty(resDto.getList())){
                return CompletableFuture.completedFuture(teleList);
            }

            for (Tele001ResDetailDto detail : resDto.getList()) {
                teleContService.regTeleCont(detail.getForm(formBase));
                if(detail.getIsConsent()){
                    teleList.add(new String[]{detail.getMgmtId()});
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(teleList);
    }

    // TELE_CHARGE 통신 청구 정보
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callTele002(ApiCallReqDto req, FormBase formBase, String mgmtId) {
        req.setRequestApiId("TELE_002");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        TeleChargeEntity lastHist = teleChargeService.getTeleChargeLast(new TeleChargeSearch(req.getMemberId(), req.getOrgCd(), mgmtId));

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        TeleParamsDto teleParamsDto = (TeleParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(teleParamsDto.getParamsTele002(mgmtId, lastHist.getChargeMonth(), CommUtil.getCurrentDate6()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Tele002ResDto.class, Tele002ResDetailDto.class);
        Tele002ResDto resDto = (Tele002ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        if(CommUtil.isListNullEmpty(resDto.getList())){
            return CompletableFuture.completedFuture(new String[]{mgmtId});
        }

        for (Tele002ResDetailDto detail : resDto.getList()) {
            if(detail.getChargeMonth().equals(lastHist.getChargeMonth())){
                teleChargeService.modTeleCharge(detail.getForm(formBase, mgmtId));
            }else {
                teleChargeService.regTeleCharge(detail.getForm(formBase, mgmtId));
            }
        }

        return CompletableFuture.completedFuture(new String[]{mgmtId});
    }

    // TELE_HIST. 통신 거래내역
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callTele003(ApiCallReqDto req, FormBase formBase, String mgmtId) {
        req.setRequestApiId("TELE_003");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        TeleHistEntity lastHist = teleHistService.getTeleHistLast(new TeleHistSearch(req.getMemberId(), req.getOrgCd(), mgmtId));

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        TeleParamsDto teleParamsDto = (TeleParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(teleParamsDto.getParamsTele003(mgmtId, lastHist.getTransMonth(), CommUtil.getCurrentDate6()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Tele003ResDto.class, Tele003ResDetailDto.class);
        Tele003ResDto resDto = (Tele003ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        if(CommUtil.isListNullEmpty(resDto.getList())){
            return CompletableFuture.completedFuture(new String[]{mgmtId});
        }

        for (Tele003ResDetailDto detail : resDto.getList()) {
            if(detail.getTransMonth().equals(lastHist.getTransMonth())){
                teleHistService.modTeleHist(detail.getForm(formBase, mgmtId));
            }else {
                teleHistService.regTeleHist(detail.getForm(formBase, mgmtId));
            }
        }

        return CompletableFuture.completedFuture(new String[]{mgmtId});
    }

    // TELE_PAY 통신 결제내역
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callTele004(ApiCallReqDto req, FormBase formBase, String mgmtId) {
        req.setRequestApiId("TELE_004");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        TelePayEntity lastHist = telePayService.getTelePayLast(new TelePaySearch(req.getMemberId(), req.getOrgCd(), mgmtId));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        TeleParamsDto teleParamsDto = (TeleParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            req.setReqParamJson(teleParamsDto.getParamsTele004(mgmtId, lastHist.getTransDate(), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Tele004ResDto.class, Tele004ResDetailDto.class);
            Tele004ResDto resDto = (Tele004ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if(CommUtil.isListNullEmpty(resDto.getList())){
                return CompletableFuture.completedFuture(new String[]{mgmtId});
            }

            for (Tele004ResDetailDto detail : resDto.getList()) {
                if(detail.getTransDate().equals(lastHist.getTransDate())){
                    telePayService.modTelePay(detail.getForm(formBase, mgmtId));
                }else {
                    telePayService.regTelePay(detail.getForm(formBase, mgmtId));
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{mgmtId});
    }


}
