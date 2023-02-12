package com.albee.mydataapi.api.collect.pull.service.impl;

import com.albee.mydataapi.api.base.p2p.models.*;
import com.albee.mydataapi.api.base.p2p.models.entity.*;
import com.albee.mydataapi.api.base.p2p.models.form.*;
import com.albee.mydataapi.api.base.p2p.service.*;
import com.albee.mydataapi.api.collect.pull.models.dto.P2pParamsDto;
import com.albee.mydataapi.api.collect.pull.service.PullP2pService;
import com.albee.mydataapi.api.common.api.models.entity.ApiMstEntity;
import com.albee.mydataapi.api.common.api.service.ApiMstService;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallResDto;
import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.models.res.p2p.*;
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
public class PullP2pServiceImpl implements PullP2pService {

    @Autowired
    ApiMstService apiMstService;
    @Autowired
    RecvStatusService recvStatusService;
    @Autowired
    RecvBaselineService recvBaselineService;
    @Autowired CallMyDataGatewayService callMyDataGatewayService;

    @Autowired
    P2pLoanService p2pLoanService;
    @Autowired
    P2pLoanBaseService p2pLoanBaseService;
    @Autowired
    P2pLoanAddService p2pLoanAddService;
    @Autowired
    P2pLoanHistService p2pLoanHistService;

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> pullP2pInfoRun(ApiCallReqDto req, RecvStatusForm recvStatusForm) {
        List<String> targetList = new ArrayList<>();

        FormBase formBase = new FormBase(req.getMemberId(), req.getOrgCd());
        formBase.setApiTranDay(req.getApiTranDay());

        // 보유자산목록(*.list)을 조회하기 위한 API 정보
        ApiMstEntity assetListQryApiEntity = apiMstService.getApiListByScope(req.getMemberToken().getScopeLists().get(0)).get(0);
        req.setRequestApiId(assetListQryApiEntity.getApiId());
        req.setRequestUrl(assetListQryApiEntity.getApiUrlResource());

        // 수신 상태 업데이트. 기관코드 + API 별로 수신시작/종료 상태 저장.
        recvStatusService.updRecvStatus(recvStatusForm, 1, req.getOrgCd());

        CompletableFuture<List<String[]>> p2p001Result = callP2p001(req, formBase);
        p2p001Result.thenAccept(p2pList -> {
            for (String[] p2p : p2pList) {
                callP2p002(req, formBase, p2p[0]);
                callP2p003(req, formBase, p2p[0]);
                callP2p004(req, formBase, p2p[0]);
            }
        });

        // 수신 상태 업데이트. 기관코드 + API 별로 종료 상태 저장.
        recvStatusForm.setRecvStatus("1");
        recvStatusForm.setRecvEndDt(CommUtil.getCurrentDateTime14());
        recvStatusService.updRecvStatus(recvStatusForm);
        return CompletableFuture.completedFuture(targetList);
    }


    // P2P_LOAN. P2P 대출 목록
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String[]>> callP2p001(ApiCallReqDto req, FormBase formBase) {
        req.setRequestApiId("P2P_001");

        List<String[]> p2pList = new ArrayList<>();

        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));
        String nextPage = baseline.getNextPage();

        // 입력 파라메터용 Map, Json 기본 설정
        P2pParamsDto p2pParamsDto = (P2pParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());


        while(true) {
            req.setReqParamJson(p2pParamsDto.getParamsP2p001(baseline.getSearchTimeStamp(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, P2p001ResDto.class, P2p001ResDetailDto.class);
            P2p001ResDto resDto = (P2p001ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            // 목록은 해지목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
            p2pLoanService.allDelP2pLoan((P2pLoanForm) formBase);

            if(CommUtil.isListNullEmpty(resDto.getList())){
                return CompletableFuture.completedFuture(p2pList);
            }

            for (P2p001ResDetailDto detail : resDto.getList()) {
                p2pLoanService.regP2pLoan(detail.getForm(formBase));
                if(detail.getIsConsent()){
                    p2pList.add(new String[]{detail.getLendingId()});
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(p2pList);
    }

    // P2P_LOAN_BASE P2P 대출 기본정보
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callP2p002(ApiCallReqDto req, FormBase formBase, String leadingId) {
        req.setRequestApiId("P2P_002");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        P2pLoanBaseEntity lastHist = p2pLoanBaseService.getP2pLoanBase(new P2pLoanBaseSearch(req.getMemberId(), req.getOrgCd(), leadingId));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        P2pParamsDto p2pParamsDto = (P2pParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(p2pParamsDto.getParamsP2p002(leadingId, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, P2p002ResDto.class);
        P2p002ResDto resDto = (P2p002ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        p2pLoanBaseService.modP2pLoanBase(resDto.getForm(formBase, leadingId));

        return CompletableFuture.completedFuture(new String[]{leadingId});
    }

    // P2P_LOAN_ADD P2P 대출 추가정보
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callP2p003(ApiCallReqDto req, FormBase formBase, String leadingId) {
        req.setRequestApiId("P2P_002");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        P2pLoanAddEntity lastHist = p2pLoanAddService.getP2pLoanAdd(new P2pLoanAddSearch(req.getMemberId(), req.getOrgCd(), leadingId));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        P2pParamsDto p2pParamsDto = (P2pParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(p2pParamsDto.getParamsP2p002(leadingId, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, P2p003ResDto.class);
        P2p003ResDto resDto = (P2p003ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        p2pLoanAddService.modP2pLoanAdd(resDto.getForm(formBase, leadingId));

        return CompletableFuture.completedFuture(new String[]{leadingId});
    }


    // P2P_LOAN_HIST P2P 대출 거래내역
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callP2p004(ApiCallReqDto req, FormBase formBase, String leadingId) {
        req.setRequestApiId("P2P_004");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        P2pLoanHistEntity lastHist = p2pLoanHistService.getP2pLoanHistLast(new P2pLoanHistSearch(req.getMemberId(), req.getOrgCd(), leadingId));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        P2pParamsDto p2pParamsDto = (P2pParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            req.setReqParamJson(p2pParamsDto.getParamsP2p004(leadingId, lastHist.getTransDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, P2p004ResDto.class, P2p004ResDetailDto.class);
            P2p004ResDto resDto = (P2p004ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if(CommUtil.isListNullEmpty(resDto.getList())){
                return CompletableFuture.completedFuture(new String[]{leadingId});
            }

            for (P2p004ResDetailDto detail : resDto.getList()) {
                if(detail.getTransDtime().substring(0, 8).equals(lastHist.getTransDtime().substring(0, 8))){
                    p2pLoanHistService.modP2pLoanHist(detail.getForm(formBase, leadingId));
                }else {
                    p2pLoanHistService.regP2pLoanHist(detail.getForm(formBase, leadingId));
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{leadingId});
    }


}
