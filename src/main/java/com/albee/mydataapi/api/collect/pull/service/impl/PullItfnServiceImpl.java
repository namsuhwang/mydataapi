package com.albee.mydataapi.api.collect.pull.service.impl;

import com.albee.mydataapi.api.base.itfn.models.*;
import com.albee.mydataapi.api.base.itfn.models.entity.*;
import com.albee.mydataapi.api.base.itfn.models.form.ItfnAccForm;
import com.albee.mydataapi.api.base.itfn.service.*;
import com.albee.mydataapi.api.collect.pull.models.dto.ItfnParamsDto;
import com.albee.mydataapi.api.collect.pull.service.PullItfnService;
import com.albee.mydataapi.api.common.api.models.entity.ApiMstEntity;
import com.albee.mydataapi.api.common.api.service.ApiMstService;
import com.albee.mydataapi.api.common.recv.models.RecvBaselineSearch;
import com.albee.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import com.albee.mydataapi.api.common.recv.models.form.RecvStatusForm;
import com.albee.mydataapi.api.common.recv.service.RecvBaselineService;
import com.albee.mydataapi.api.common.recv.service.RecvHistBaseService;
import com.albee.mydataapi.api.common.recv.service.RecvHistDetailService;
import com.albee.mydataapi.api.common.recv.service.RecvStatusService;
import com.albee.mydataapi.common.CommUtil;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallResDto;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.service.CallMyDataGatewayService;
import com.albee.mydataapi.api.common.gateway.models.res.itfn.*;
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
public class PullItfnServiceImpl implements PullItfnService {

    @Autowired
    ApiMstService apiMstService;
    @Autowired
    RecvBaselineService recvBaselineService;
    @Autowired CallMyDataGatewayService callMyDataGatewayService;

    @Autowired
    RecvStatusService recvStatusService;
    @Autowired
    RecvHistBaseService recvHistBaseService;
    @Autowired
    RecvHistDetailService recvHistDetailService;

    @Autowired
    ItfnAccService itfnAccService;
    @Autowired
    ItfnLeaseHistService itfnLeaseHistService;
    @Autowired
    ItfnLeaseService itfnLeaseService;
    @Autowired ItfnLoanService itfnLoanService;
    @Autowired
    ItfnLoanAddService itfnLoanAddService;
    @Autowired ItfnLoanHistService itfnLoanHistService;
    @Autowired
    ItfnLoanHistIntService itfnLoanHistIntService;

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> pullItfnInfoRun(ApiCallReqDto req, RecvStatusForm recvStatusForm) {
        List<String> targetList = new ArrayList<>();

        FormBase formBase = new FormBase(req.getMemberId(), req.getOrgCd());
        formBase.setApiTranDay(req.getApiTranDay());

        // 보유자산목록(*.list)을 조회하기 위한 API 정보
        ApiMstEntity assetListQryApiEntity = apiMstService.getApiListByScope(req.getMemberToken().getScopeLists().get(0)).get(0);
        req.setRequestApiId(assetListQryApiEntity.getApiId());
        req.setRequestUrl(assetListQryApiEntity.getApiUrlResource());

        // 수신 상태 업데이트. 기관코드 + API 별로 수신시작/종료 상태 저장.
        recvStatusService.updRecvStatus(recvStatusForm, 1, req.getOrgCd());

        CompletableFuture<List<String[]>> itfn001Result = callItfn001(req, formBase);
        itfn001Result.thenAccept(accList -> {
            for (String[] acc : accList) {
                if(acc[1].substring(0, 1).equals("35")){
                    callItfn002(req, formBase, acc[0], acc[1]);
                    callItfn003(req, formBase, acc[0], acc[1]);
                    callItfn004(req, formBase, acc[0], acc[1]);
                }else if(acc[1].substring(0, 1).equals("35")){
                    callItfn005(req, formBase, acc[0], acc[1]);
                    callItfn006(req, formBase, acc[0], acc[1]);
                }
            }
        });

        // 수신 상태 업데이트. 기관코드 + API 별로 종료 상태 저장.
        recvStatusForm.setRecvStatus("1");
        recvStatusForm.setRecvEndDt(CommUtil.getCurrentDateTime14());
        recvStatusService.updRecvStatus(recvStatusForm);
        return CompletableFuture.completedFuture(targetList);
    }


    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String[]>> callItfn001(ApiCallReqDto req, FormBase formBase) {
        req.setRequestApiId("ITFN_001");

        List<String[]> accList = new ArrayList<>();

        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));

        // 입력 파라메터용 Map, Json 기본 설정
        ItfnParamsDto itfnParamsDto = (ItfnParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(itfnParamsDto.getParamsItfn001(baseline.getSearchTimeStamp(), baseline.getNextPage()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Itfn001ResDto.class, Itfn001ResDetailDto.class);
        Itfn001ResDto resDto = (Itfn001ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        // 목록은 해지목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        itfnAccService.allDelItfnAcc((ItfnAccForm) formBase);

        if(CommUtil.isListNullEmpty(resDto.getList())){
            return CompletableFuture.completedFuture(accList);
        }

        for (Itfn001ResDetailDto detail : resDto.getList()) {
            itfnAccService.regItfnAcc(detail.getForm(formBase));
            if(detail.getIsConsent()){
                accList.add(new String[]{detail.getAccountNum(), detail.getSeqno()});
            }
        }

        return CompletableFuture.completedFuture(accList);
    }

    // ITFN_LOAN
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callItfn002(ApiCallReqDto req, FormBase formBase, String accountNum, String seqno) {
        req.setRequestApiId("ITFN_002");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        ItfnLoanEntity entity = itfnLoanService.getItfnLoan(new ItfnLoanSearch(req.getMemberId(), req.getOrgCd(), accountNum, seqno));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        ItfnParamsDto itfnParamsDto = (ItfnParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(itfnParamsDto.getParamsItfn002(accountNum, seqno, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Itfn002ResDto.class);
        Itfn002ResDto resDto = (Itfn002ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        itfnLoanService.modItfnLoan(resDto.getForm(formBase, accountNum, seqno));

        return CompletableFuture.completedFuture(new String[]{accountNum, seqno});
    }

    // ITFN_LOAN_ADD. 할부금융 대출상품계좌 추가정보
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callItfn003(ApiCallReqDto req, FormBase formBase, String accountNum, String seqno) {
        req.setRequestApiId("ITFN_003");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        ItfnLoanAddEntity entity = itfnLoanAddService.getItfnLoanAdd(new ItfnLoanAddSearch(req.getMemberId(), req.getOrgCd(), accountNum, seqno));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        ItfnParamsDto itfnParamsDto = (ItfnParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(itfnParamsDto.getParamsItfn003(accountNum, seqno, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Itfn003ResDto.class);
        Itfn003ResDto resDto = (Itfn003ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        itfnLoanAddService.modItfnLoanAdd(resDto.getForm(formBase, accountNum, seqno));

        return CompletableFuture.completedFuture(new String[]{accountNum, seqno});
    }

    // ITFN_LOAN_HIST (할부금융 대출상품계좌 거래내역), ITFN_LOAN_HIST_INT (할부금융 대출상품계좌 거래내역 이자적용)
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callItfn004(ApiCallReqDto req, FormBase formBase, String accountNum, String seqno) {
        req.setRequestApiId("ITFN_004");

        ItfnLoanHistEntity lastHist = itfnLoanHistService.getItfnLoanHistLast(new ItfnLoanHistSearch(req.getMemberId(), req.getOrgCd(), accountNum, seqno));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        ItfnParamsDto itfnParamsDto = (ItfnParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(itfnParamsDto.getParamsItfn004(accountNum, seqno, lastHist.getTransDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Itfn004ResDto.class, Itfn004ResDetailDto.class);
            Itfn004ResDto resDto = (Itfn004ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (!CommUtil.isListNullEmpty(resDto.getList())) {
                for (Itfn004ResDetailDto detail : resDto.getList()) {
                    if(detail.getTransDtime().substring(0, 8).equals(lastHist.getTransDtime().substring(0, 8))){
                        itfnLoanHistService.modItfnLoanHist(detail.getForm(formBase, accountNum, seqno));
                    }else{
                        itfnLoanHistService.regItfnLoanHist(detail.getForm(formBase, accountNum, seqno));
                    }

                    // 이자 내역
                    if (!CommUtil.isListNullEmpty(detail.getList())) {
                        for (Itfn004ResDetailIntDto detailInt : detail.getList()) {
                            itfnLoanHistIntService.modItfnLoanHistInt(detailInt.getForm(formBase, accountNum, seqno, detail.getTransDtime(), detail.getTransNo()));
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

        return CompletableFuture.completedFuture(new String[]{accountNum, seqno});
    }


    // ITFN_LEASE. 할부금융 운용리스 기본정보
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callItfn005(ApiCallReqDto req, FormBase formBase, String accountNum, String seqno) {
        req.setRequestApiId("ITFN_005");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        ItfnLeaseEntity entity = itfnLeaseService.getItfnLease(new ItfnLeaseSearch(req.getMemberId(), req.getOrgCd(), accountNum, seqno));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        ItfnParamsDto itfnParamsDto = (ItfnParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(itfnParamsDto.getParamsItfn005(accountNum, seqno, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Itfn005ResDto.class);
        Itfn005ResDto resDto = (Itfn005ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        itfnLeaseService.modItfnLease(resDto.getForm(formBase, accountNum, seqno));

        return CompletableFuture.completedFuture(new String[]{accountNum, seqno});
    }

    // ITFN_LEASE_HIST. 할부금융 운용리스 거래내역
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callItfn006(ApiCallReqDto req, FormBase formBase, String accountNum, String seqno) {
        req.setRequestApiId("ITFN_006");

        ItfnLeaseHistEntity lastHist = itfnLeaseHistService.getItfnLeaseHistLast(new ItfnLeaseHistSearch(req.getMemberId(), req.getOrgCd(), accountNum, seqno));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        ItfnParamsDto itfnParamsDto = (ItfnParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            /*
            LocalDate fromLd = LocalDate.of(Integer.valueOf(lastHist.getTransDtime().substring(0, 3))
                    , Integer.valueOf(lastHist.getTransDtime().substring(3, 4)), Integer.valueOf(lastHist.getTransDtime().substring(4, 5))) ;
            LocalDate toLd = fromLd.plusDays(500);
            */
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(itfnParamsDto.getParamsItfn006(accountNum, seqno, lastHist.getTransDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Itfn006ResDto.class, Itfn006ResDetailDto.class);
            Itfn006ResDto resDto = (Itfn006ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Itfn006ResDetailDto detail : resDto.getList()) {
                    if(detail.getTransDtime().substring(0, 8).equals(lastHist.getTransDtime().substring(0, 8))){
                        itfnLeaseHistService.modItfnLeaseHist(detail.getForm(formBase, accountNum, seqno));
                    }else {
                        itfnLeaseHistService.regItfnLeaseHist(detail.getForm(formBase, accountNum, seqno));
                    }
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{accountNum, seqno});
    }


}
