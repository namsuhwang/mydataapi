package com.albee.mydataapi.api.collect.pull.service.impl;

import com.albee.mydataapi.api.base.bank.models.form.*;
import com.albee.mydataapi.api.common.api.models.entity.ApiMstEntity;
import com.albee.mydataapi.api.common.api.service.ApiMstService;
import com.albee.mydataapi.api.common.member.service.MemberService;
import com.albee.mydataapi.api.common.member.service.MemberTokenService;
import com.albee.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import com.albee.mydataapi.api.common.recv.service.RecvBaselineService;
import com.albee.mydataapi.api.common.recv.service.RecvHistBaseService;
import com.albee.mydataapi.api.common.recv.service.RecvHistDetailService;
import com.albee.mydataapi.api.common.recv.service.RecvStatusService;
import com.albee.mydataapi.common.CommUtil;
import com.albee.mydataapi.api.collect.pull.models.dto.BankParamsDto;
import com.albee.mydataapi.api.collect.pull.service.PullBankService;
import com.albee.mydataapi.api.collect.pull.service.PullDbService;
import com.albee.mydataapi.api.collect.pull.service.PullDcService;
import com.albee.mydataapi.api.collect.pull.service.PullIrpService;
import com.albee.mydataapi.api.collect.pull.service.PullPpayService;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallResDto;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.service.CallMyDataGatewayService;
import com.albee.mydataapi.api.common.recv.models.form.RecvStatusForm;
import com.albee.mydataapi.api.base.bank.models.*;
import com.albee.mydataapi.api.base.bank.models.entity.*;
import com.albee.mydataapi.api.base.bank.service.*;
import com.albee.mydataapi.api.common.gateway.models.res.bank.*;
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
public class PullBankServiceImpl implements PullBankService {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberTokenService memberTokenService;
    @Autowired
    ApiMstService apiMstService;
    @Autowired
    RecvBaselineService recvBaselineService;
    @Autowired CallMyDataGatewayService callMyDataGatewayService;

    @Autowired
    BankAccService bankAccService;
    @Autowired BankCustService bankCustService;
    @Autowired
    BankAccDepositService bankAccDepositService;
    @Autowired
    BankAccDepositAddService bankAccDepositAddService;
    @Autowired
    BankAccDepositHistService bankAccDepositHistService;
    @Autowired
    BankAutoTransService bankAutoTransService;
    @Autowired BankAccFundService bankAccFundService;
    @Autowired BankAccFundAddService bankAccFundAddService;
    @Autowired BankAccFundHistService bankAccFundHistService;
    @Autowired BankAccLoanService bankAccLoanService;
    @Autowired BankAccLoanAddService bankAccLoanAddService;
    @Autowired BankAccLoanHistService bankAccLoanHistService;
    @Autowired BankAccLoanHistIntService bankAccLoanHistIntService;
    @Autowired BankAccProdService bankAccProdService;
    @Autowired BankAccProdHistService bankAccProdHistService;
    @Autowired BankAccEachProdService bankAccEachProdService;

    @Autowired
    PullIrpService pullIrpService;
    @Autowired
    PullPpayService pullPpayService;
    @Autowired
    PullDbService pullDbService;
    @Autowired
    PullDcService pullDcService;
    @Autowired
    RecvStatusService recvStatusService;
    @Autowired
    RecvHistBaseService recvHistBaseService;
    @Autowired
    RecvHistDetailService recvHistDetailService;

    /*
        은행 기관별 전송요구등록건별 조회 처리
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> pullBankInfoRun(ApiCallReqDto req, RecvStatusForm recvStatusForm) {
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

        // 계좌별로 계좌유형에 따라 API 들을 순차적으로 호출함
        CompletableFuture<List<String[]>> bank001Result = callBank001(req, formBase);
        bank001Result.thenAccept(accList -> {
            for(String[] acc : accList){
                if(acc[2].substring(0, 0).equals("1")){  // 수신상품
                    if(req.getMemberToken().getScopeLists().contains("bank.deposit")){
                        callBank002(req, formBase, acc[0], acc[1]);
                        callBank003(req, formBase, acc[0], acc[1]);
                        callBank004(req, formBase, acc[0], acc[1]);
                        callBank014(req, formBase, acc[0]);
                    }
                }else if(acc[2].equals("2001") || acc[2].equals("2999")){   // 펀드상품
                    if(req.getMemberToken().getScopeLists().contains("bank.invest")){
                        callBank005(req, formBase, acc[0], acc[1]);
                        callBank006(req, formBase, acc[0], acc[1]);
                        callBank007(req, formBase, acc[0], acc[1]);
                    }
                }else if(acc[2].substring(0, 0).equals("3")){   // 대출상품
                    if(req.getMemberToken().getScopeLists().contains("bank.loan")){
                        callBank008(req, formBase, acc[0], acc[1]);
                        callBank009(req, formBase, acc[0], acc[1]);
                        callBank010(req, formBase, acc[0], acc[1]);
                    }
                }else if(acc[2].equals("2001") || acc[2].equals("2002") || acc[2].equals("2003") || acc[2].equals("2004")){   // 신탁/ISA
                    // 2001 은 isa 로 봐야 할지, irp 로 봐야할지 애매함. 일단 isa 로 처리함.
                    if(req.getMemberToken().getScopeLists().contains("bank.isa")){
                        callBank011(req, formBase, acc[0]);
                        callBank012(req, formBase, acc[0]);
                        callBank013(req, formBase, acc[0]);
                    }
                }

            }
        });

        if(req.getMemberToken().getScopeLists().contains("bank.irp")){
            pullIrpService.pullIrpInfoRun(req, formBase);
        }

        if(req.getMemberToken().getScopeLists().contains("bank.prepaid")){
            pullPpayService.pullPpayInfoRun(req, formBase);
        }

        if(req.getMemberToken().getScopeLists().contains("bank.db")){
            pullDbService.pullDbInfoRun(req, formBase);
        }

        if(req.getMemberToken().getScopeLists().contains("bank.dc")){
            pullDcService.pullDcInfoRun(req, formBase);
        }

        // 수신 상태 업데이트. 기관코드 + API 별로 종료 상태 저장.
        recvStatusForm.setRecvStatus("1");
        recvStatusForm.setRecvEndDt(CommUtil.getCurrentDateTime14());
        recvStatusService.updRecvStatus(recvStatusForm);
        return CompletableFuture.completedFuture(targetList);
    }


    /*
        BANK_001 (BANK_ACC) 계좌 목록
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String[]>> callBank001(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("BANK_001");

        List<String[]> accountList = new ArrayList<>();

        // 고객등록일 설정 위한 기본 정보 설정
        BankCustForm bankCustForm = (BankCustForm) formBase;

        // 입력 파라메터용 Map, Json 기본 설정
        BankParamsDto bankParamsDto = (BankParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        BankCustEntity entity = bankCustService.getBankCust(new BankCustSearch(req.getMemberId(), req.getOrgCd()));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        req.setReqParamJson(bankParamsDto.getParamsBank001(baseline.getSearchTimeStamp(), baseline.getNextPage()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Bank001ResDto.class, Bank001ResDetailDto.class);
        Bank001ResDto bank001ResDto = (Bank001ResDto) resInfo.getData();

        // BankCust 테이블 반영(고객등록일 설정)
        if(CommUtil.isNullEmpty(bankCustForm.getRegDate())){
            bankCustForm.setRegDate(bank001ResDto.getRegDate());
            bankCustService.regBankCust(bankCustForm);
        }else{
            bankCustForm.setRegDate(bank001ResDto.getRegDate());
            bankCustService.updBankCust(bankCustForm);
        }

        // 계좌목록은 해지계좌목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        bankAccService.allDelBankAcc((BankAccForm) formBase);

        formBase.setApiTranId(bank001ResDto.getXApiTranId());
        List<Bank001ResDetailDto> accountInfoList = bank001ResDto.getList();

        // BankAcc 테이블 반영
        for(Bank001ResDetailDto detail : accountInfoList){
            bankAccService.regBankAcc(detail.getForm(formBase));
            if(detail.getIsConsent()){
                accountList.add(new String[]{detail.getAccountNum(), detail.getSeqno(), detail.getAccountType()});
            }
        }
        return CompletableFuture.completedFuture(accountList);
    }

    /*
        BANK_002 (BANK_ACC_DEPOSIT) 수신계좌 기본 정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callBank002(ApiCallReqDto req, FormBase formBase, String accNo, String seqno){
        req.setRequestApiId("BANK_002");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        BankAccDepositEntity entity = bankAccDepositService.getBankAccDepositLast(new BankAccDepositSearch(req.getMemberId(), req.getOrgCd(), accNo, seqno));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        BankParamsDto bankParamsDto = (BankParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(bankParamsDto.getParamsBank002(accNo, seqno, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Bank002ResDto.class, Bank002ResDetailDto.class);
        Bank002ResDto resDto = (Bank002ResDto) resInfo.getData();
        // formBase.setApiTranDay(req.getApiTranDay()); // recvBank002 호출되기 전에 설정되어서 넘어오므로 설정하면 안됨
        formBase.setApiTranId(resDto.getXApiTranId());

        BankAccDepositForm form = (BankAccDepositForm) formBase;
        form.setAccountNum(accNo);
        form.setSeqno(seqno);
        bankAccDepositService.delAllBankAccDeposit(form);

        if (CommUtil.isListNullEmpty(resDto.getList())) {
            for (Bank002ResDetailDto detail : resDto.getList()) {
                bankAccDepositService.regBankAccDeposit(detail.getForm(formBase, accNo, seqno));
            }
        }
        return CompletableFuture.completedFuture(new String[]{accNo, seqno});
    }


    /*
        BANK_003 (BANK_ACC_DEPOSIT_ADD) 수신계좌 추가 정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callBank003(ApiCallReqDto req, FormBase formBase, String accNo, String seqno){
        req.setRequestApiId("BANK_003");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        BankAccDepositAddEntity entity = bankAccDepositAddService.getBankAccDepositAddLast(new BankAccDepositAddSearch(req.getMemberId(), req.getOrgCd(), accNo, seqno));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        BankParamsDto bankParamsDto = (BankParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(bankParamsDto.getParamsBank003(accNo, seqno, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Bank003ResDto.class, Bank003ResDetailDto.class);
        Bank003ResDto resDto = (Bank003ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
            int accountSeq = 0;
            for (Bank003ResDetailDto detail : resDto.getList()) {
                detail.setAccountSeq(++accountSeq);
                bankAccDepositAddService.regBankAccDepositAdd(detail.getForm(formBase, accNo, seqno));
            }
        }
        return CompletableFuture.completedFuture(new String[]{accNo, seqno});
    }



    /*
        BANK_004 (BANK_ACC_HIST) 수신계좌 거래내역
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callBank004(ApiCallReqDto req, FormBase formBase, String accNo, String seqno){
        req.setRequestApiId("BANK_004");
        BankAccDepositHistEntity lastHist = bankAccDepositHistService.getBankAccDepositHistLast(new BankAccDepositHistSearch(req.getMemberId(), req.getOrgCd(), accNo, seqno));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        BankParamsDto bankParamsDto = (BankParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            /*
            LocalDate fromLd = LocalDate.of(Integer.valueOf(lastHist.getTransDtime().substring(0, 3))
                    , Integer.valueOf(lastHist.getTransDtime().substring(3, 4)), Integer.valueOf(lastHist.getTransDtime().substring(4, 5))) ;
            LocalDate toLd = fromLd.plusDays(500);
            */
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(bankParamsDto.getParamsBank004(accNo, seqno, lastHist.getTransDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Bank004ResDto.class, Bank004ResDetailDto.class);
            Bank004ResDto resDto = (Bank004ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Bank004ResDetailDto detail : resDto.getList()) {
                    if(detail.getTransDtime().substring(0, 8).equals(lastHist.getTransDtime().substring(0, 8))){
                        bankAccDepositHistService.modBankAccDepositHist(detail.getForm(formBase, accNo, seqno));
                    }else {
                        bankAccDepositHistService.regBankAccDepositHist(detail.getForm(formBase, accNo, seqno));
                    }
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{accNo, seqno});
    }



    /*
        BANK_005 (BANK_ACC_FUND) 펀드상품계좌 기본 정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callBank005(ApiCallReqDto req, FormBase formBase, String accNo, String seqno){
        req.setRequestApiId("BANK_005");

        BankAccFundEntity entity = bankAccFundService.getBankAccFund(new BankAccFundSearch(req.getMemberId(), req.getOrgCd(), accNo, seqno));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        BankParamsDto bankParamsDto = (BankParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(bankParamsDto.getParamsBank005(accNo, seqno, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Bank005ResDto.class);
        Bank005ResDto resDto = (Bank005ResDto) resInfo.getData();
        // formBase.setApiTranDay(req.getApiTranDay()); // recvBank002 호출되기 전에 설정되어서 넘어오므로 설정하면 안됨
        formBase.setApiTranId(resDto.getXApiTranId());

        if (resDto != null) {
            bankAccFundService.modBankAccFund(resDto.getForm(formBase, accNo, seqno));
        }else{
            bankAccFundService.delBankAccFund(new BankAccFundForm(req.getMemberId(), req.getOrgCd(), accNo, seqno));
        }
        return CompletableFuture.completedFuture(new String[]{accNo, seqno});
    }


    /*
        BANK_006 (BANK_ACC_DEPOSIT_FUND) 펀드상품계좌 추가 정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callBank006(ApiCallReqDto req, FormBase formBase, String accNo, String seqno){
        req.setRequestApiId("BANK_006");

        BankAccFundAddEntity entity = bankAccFundAddService.getBankAccFundAdd(new BankAccFundAddSearch(req.getMemberId(), req.getOrgCd(), accNo, seqno));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        BankParamsDto bankParamsDto = (BankParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(bankParamsDto.getParamsBank006(accNo, seqno, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Bank003ResDto.class);
        Bank006ResDto resDto = (Bank006ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        if (resDto != null) {
            bankAccFundAddService.modBankAccFundAdd(resDto.getForm(formBase, accNo, seqno));
        }else{
            bankAccFundAddService.delBankAccFundAdd(new BankAccFundAddForm(req.getMemberId(), req.getOrgCd(), accNo, seqno));
        }
        return CompletableFuture.completedFuture(new String[]{accNo, seqno});
    }



    /*
        BANK_007 (BANK_ACC_FUND) 펀드상품계좌 거래내역
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callBank007(ApiCallReqDto req, FormBase formBase, String accNo, String seqno){
        req.setRequestApiId("BANK_007");
        BankAccFundHistEntity lastHist = bankAccFundHistService.getBankAccFundHistLast(new BankAccFundHistSearch(req.getMemberId(), req.getOrgCd(), accNo, seqno));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        BankParamsDto bankParamsDto = (BankParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            /*
            LocalDate fromLd = LocalDate.of(Integer.valueOf(lastHist.getTransDtime().substring(0, 3))
                    , Integer.valueOf(lastHist.getTransDtime().substring(3, 4)), Integer.valueOf(lastHist.getTransDtime().substring(4, 5))) ;
            LocalDate toLd = fromLd.plusDays(500);
            */
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(bankParamsDto.getParamsBank007(accNo, seqno, lastHist.getTransDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Bank007ResDto.class, Bank007ResDetailDto.class);
            Bank007ResDto resDto = (Bank007ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Bank007ResDetailDto detail : resDto.getList()) {
                    bankAccFundHistService.regBankAccFundHist(detail.getForm(formBase, accNo, seqno));
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{accNo, seqno});
    }


    /*
        BANK_008 (BANK_ACC_LOAN) 대출상품계좌 기본 정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callBank008(ApiCallReqDto req, FormBase formBase, String accNo, String seqno){
        req.setRequestApiId("BANK_008");

        BankAccLoanEntity entity = bankAccLoanService.getBankAccLoan(new BankAccLoanSearch(req.getMemberId(), req.getOrgCd(), accNo, seqno));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        BankParamsDto bankParamsDto = (BankParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(bankParamsDto.getParamsBank008(accNo, seqno, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Bank008ResDto.class);
        Bank008ResDto resDto = (Bank008ResDto) resInfo.getData();
        // formBase.setApiTranDay(req.getApiTranDay()); // recvBank002 호출되기 전에 설정되어서 넘어오므로 설정하면 안됨
        formBase.setApiTranId(resDto.getXApiTranId());

        if (resDto != null) {
            bankAccLoanService.modBankAccLoan(resDto.getForm(formBase, accNo, seqno));
        }else{
            bankAccLoanService.delBankAccLoan(new BankAccLoanForm(req.getMemberId(), req.getOrgCd(), accNo, seqno));
        }
        return CompletableFuture.completedFuture(new String[]{accNo, seqno});
    }


    /*
        BANK_009 (BANK_ACC_LOAN_ADD) 대출상품계좌 추가 정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callBank009(ApiCallReqDto req, FormBase formBase, String accNo, String seqno){
        req.setRequestApiId("BANK_009");

        BankAccLoanAddEntity entity = bankAccLoanAddService.getBankAccLoanAdd(new BankAccLoanAddSearch(req.getMemberId(), req.getOrgCd(), accNo, seqno));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        BankParamsDto bankParamsDto = (BankParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(bankParamsDto.getParamsBank009(accNo, seqno, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Bank003ResDto.class);
        Bank009ResDto resDto = (Bank009ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        if (resDto != null) {
            bankAccLoanAddService.modBankAccLoanAdd(resDto.getForm(formBase, accNo, seqno));
        }else{
            bankAccLoanAddService.delBankAccLoanAdd(new BankAccLoanAddForm(req.getMemberId(), req.getOrgCd(), accNo, seqno));
        }
        return CompletableFuture.completedFuture(new String[]{accNo, seqno});
    }



    /*
        BANK_010 (BANK_ACC_LOAN_HIST) 대출상품계좌 거래내역
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callBank010(ApiCallReqDto req, FormBase formBase, String accNo, String seqno){
        req.setRequestApiId("BANK_010");
        BankAccLoanHistEntity lastHist = bankAccLoanHistService.getBankAccLoanHistLast(new BankAccLoanHistSearch(req.getMemberId(), req.getOrgCd(), accNo, seqno));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        BankParamsDto bankParamsDto = (BankParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            /*
            LocalDate fromLd = LocalDate.of(Integer.valueOf(lastHist.getTransDtime().substring(0, 3))
                    , Integer.valueOf(lastHist.getTransDtime().substring(3, 4)), Integer.valueOf(lastHist.getTransDtime().substring(4, 5))) ;
            LocalDate toLd = fromLd.plusDays(500);
            */
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(bankParamsDto.getParamsBank010(accNo, seqno, lastHist.getTransDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Bank010ResDto.class, Bank010ResDetailDto.class);
            Bank010ResDto resDto = (Bank010ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (CommUtil.isListNullEmpty(resDto.getList())) continue;
            for (Bank010ResDetailDto detail : resDto.getList()) {
                bankAccLoanHistService.modBankAccLoanHist(detail.getForm(formBase, accNo, seqno));
                if (CommUtil.isListNullEmpty(detail.getList())) continue;
                for (Bank010ResDetailIntDto intInfo : detail.getList()) {
                    bankAccLoanHistIntService.modBankAccLoanHistInt(intInfo.getForm(formBase, accNo, seqno));
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{accNo, seqno});
    }




    /*
        BANK_011 (BANK_ACC_PROD) 신탁/ISA 상품 기본 정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callBank011(ApiCallReqDto req, FormBase formBase, String accNo){
        req.setRequestApiId("BANK_011");

        BankAccProdEntity entity = bankAccProdService.getBankAccProd(new BankAccProdSearch(req.getMemberId(), req.getOrgCd(), accNo));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        BankParamsDto bankParamsDto = (BankParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(bankParamsDto.getParamsBank011(accNo, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Bank011ResDto.class);
        Bank011ResDto resDto = (Bank011ResDto) resInfo.getData();
        // formBase.setApiTranDay(req.getApiTranDay()); // recvBank002 호출되기 전에 설정되어서 넘어오므로 설정하면 안됨
        formBase.setApiTranId(resDto.getXApiTranId());

        if (resDto != null) {
            bankAccProdService.modBankAccProd(resDto.getForm(formBase, accNo));
        }else{
            bankAccProdService.delBankAccProd(new BankAccProdForm(req.getMemberId(), req.getOrgCd(), accNo));
        }
        return CompletableFuture.completedFuture(new String[]{accNo});
    }



    /*
        BANK_012 (BANK_ACC_PROD_HIST) 신탁/ISA 상품 거래내역
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callBank012(ApiCallReqDto req, FormBase formBase, String accNo){
        req.setRequestApiId("BANK_012");
        BankAccProdHistEntity lastHist = bankAccProdHistService.getBankAccProdHistLast(new BankAccProdHistSearch(req.getMemberId(), req.getOrgCd(), accNo));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        BankParamsDto bankParamsDto = (BankParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            /*
            LocalDate fromLd = LocalDate.of(Integer.valueOf(lastHist.getTransDtime().substring(0, 3))
                    , Integer.valueOf(lastHist.getTransDtime().substring(3, 4)), Integer.valueOf(lastHist.getTransDtime().substring(4, 5))) ;
            LocalDate toLd = fromLd.plusDays(500);
            */
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(bankParamsDto.getParamsBank012(accNo, lastHist.getTransDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Bank012ResDto.class, Bank012ResDetailDto.class);
            Bank012ResDto resDto = (Bank012ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Bank012ResDetailDto detail : resDto.getList()) {
                    bankAccProdHistService.regBankAccProdHist(detail.getForm(formBase, accNo));
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


    /*
        BANK_013 (BANK_ACC_EACH_PROD) 신탁/ISA 개별운용상품
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callBank013(ApiCallReqDto req, FormBase formBase, String accNo){
        req.setRequestApiId("BANK_013");
        BankAccEachProdEntity lastHist = bankAccEachProdService.getBankAccEachProdLast(new BankAccEachProdSearch(req.getMemberId(), req.getOrgCd(), accNo));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        BankParamsDto bankParamsDto = (BankParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            /*
            LocalDate fromLd = LocalDate.of(Integer.valueOf(lastHist.getTransDtime().substring(0, 3))
                    , Integer.valueOf(lastHist.getTransDtime().substring(3, 4)), Integer.valueOf(lastHist.getTransDtime().substring(4, 5))) ;
            LocalDate toLd = fromLd.plusDays(500);
            */
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(bankParamsDto.getParamsBank013(accNo, baseline.getSearchTimeStamp(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Bank013ResDto.class, Bank013ResDetailDto.class);
            Bank013ResDto resDto = (Bank013ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Bank013ResDetailDto detail : resDto.getList()) {
                    bankAccEachProdService.regBankAccEachProd(detail.getForm(formBase, accNo));
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



    /*
        BANK_014 (BANK_AUTO_TRANS) 수신계좌 자동이체 정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callBank014(ApiCallReqDto req, FormBase formBase, String accNo){
        req.setRequestApiId("BANK_014");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        BankAutoTransEntity entity = bankAutoTransService.getBankAutoTransLast(new BankAutoTransSearch(req.getMemberId(), req.getOrgCd(), accNo));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        BankParamsDto bankParamsDto = (BankParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(bankParamsDto.getParamsBank014(accNo, baseline.getSearchTimeStamp(), baseline.getNextPage()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Bank014ResDto.class, Bank002ResDetailDto.class);
        Bank014ResDto resDto = (Bank014ResDto) resInfo.getData();
        // formBase.setApiTranDay(req.getApiTranDay()); // recvBank002 호출되기 전에 설정되어서 넘어오므로 설정하면 안됨
        formBase.setApiTranId(resDto.getXApiTranId());

        if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
            for (Bank014ResDetailDto detail : resDto.getList()) {
                bankAutoTransService.modBankAutoTrans(detail.getForm(formBase, accNo));
            }
        }else if(resDto.getListCnt() == 0){
            bankAutoTransService.delBankAutoTrans(new BankAutoTransForm(req.getMemberId(), req.getOrgCd(), accNo));
        }
        return CompletableFuture.completedFuture(new String[]{accNo});
    }

}
