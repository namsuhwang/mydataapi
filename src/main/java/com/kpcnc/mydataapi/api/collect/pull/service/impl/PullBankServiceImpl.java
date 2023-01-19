package com.kpcnc.mydataapi.api.collect.pull.service.impl;

import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccDepositAddForm;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccDepositForm;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccForm;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankCustForm;
import com.kpcnc.mydataapi.api.base.bank.service.*;
import com.kpcnc.mydataapi.api.collect.pull.service.PullBankService;
import com.kpcnc.mydataapi.api.common.api.models.entity.ApiMstEntity;
import com.kpcnc.mydataapi.api.common.api.service.ApiMstService;
import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallRequestInfoDto;
import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallResponseInfoDto;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import com.kpcnc.mydataapi.api.common.gateway.models.in.*;
import com.kpcnc.mydataapi.api.common.gateway.service.CallMyDataGatewayService;
import com.kpcnc.mydataapi.api.common.member.service.MemberService;
import com.kpcnc.mydataapi.api.common.member.service.MemberTokenService;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvStatusForm;
import com.kpcnc.mydataapi.api.common.recv.service.*;
import com.kpcnc.mydataapi.common.CommUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class PullBankServiceImpl implements PullBankService {

    @Autowired MemberService memberService;
    @Autowired MemberTokenService memberTokenService;
    @Autowired ApiMstService apiMstService;
    @Autowired RecvBaselineService recvBaselineService;
    @Autowired LedgerBankService ledgerBankService;
    @Autowired CallMyDataGatewayService callMyDataGatewayService;
    @Autowired BankAccService bankAccService;
    @Autowired BankCustService bankCustService;
    @Autowired BankAccDepositService bankAccDepositService;
    @Autowired BankAccDepositAddService bankAccDepositAddService;
    @Autowired BankAccDepositHistService bankAccDepositHistService;
    @Autowired RequestBankParamsSetService reqBankParamsSetService;
    @Autowired RecvStatusService recvStatusService;
    @Autowired RecvHistBaseService recvHistBaseService;
    @Autowired RecvHistDetailService recvHistDetailService;

    /*
        은행 기관별 전송요구등록건별 조회 처리
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> pullBankInfoRun(ApiCallRequestInfoDto reqInfo, RecvStatusForm recvStatusForm) {
        List<String> targetList = new ArrayList<>();
        List<String[]> accountList = null;  // 자산목록(예:계좌목록. [0번째 : 계좌번호, 1번째 : 회차번호])
        HashMap<String, Object> reqParamMap = null;

        FormBase formBase = new FormBase(reqInfo.getMemberId(), reqInfo.getOrgCd());
        formBase.setApiTranDay(reqInfo.getApiTranDay());

        // 전송여부가 자산목록인 건 조회.
        // MEMBER_TOKEM.SCOPE_LIST 의 첫번째는 무조건 자산목록(*.list) scope 라고 가정.
        /* 자산목록 요청인 건만 먼저 조회하여 조회해야할 자산목록 설정(예:계좌목록)  */

        // 보유자산목록(*.list)을 조회하기 위한 API 정보
        ApiMstEntity assetListQryApiEntity = apiMstService.getApiListByScope(reqInfo.getMemberToken().getScopeLists().get(0)).get(0);
        reqInfo.setRequestApiId(assetListQryApiEntity.getApiId());
        reqInfo.setRequestUrl(assetListQryApiEntity.getApiUrlResource());

        // 수신 상태 업데이트. 기관코드 + API 별로 수신시작/종료 상태 저장.
        recvStatusService.updRecvStatus(recvStatusForm, 1, reqInfo.getOrgCd());

        // 계좌목록은 해지계좌목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        bankAccService.allDelBankAcc((BankAccForm) formBase);

        // 고객등록일 설정 위한 기본 정보 설정
        BankCustForm bankCustForm = (BankCustForm) formBase;

        // 입력 파라메터용 Map, Json 기본 설정
        reqParamMap = reqBankParamsSetService.getParamsBank001(reqInfo.getMemberId(), reqInfo.getOrgCd());
        reqInfo.setRequestParameterMap(reqParamMap);
        reqInfo.setRequestParameterJson(reqParamMap);

        // 게이트웨이 call
        ApiCallResponseInfoDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(reqInfo, Bank001InDto.class, Bank001DetailInDto.class);
        Bank001InDto bank001InDto = (Bank001InDto) resInfo.getData();

        // BankCust 테이블 반영(고객등록일 설정)
        if(CommUtil.isNullEmpty(bankCustForm.getRegDate())){
            bankCustForm.setRegDate(bank001InDto.getRegDate());
            bankCustService.regBankCust(bankCustForm);
        }else{
            bankCustForm.setRegDate(bank001InDto.getRegDate());
            bankCustService.updBankCust(bankCustForm);
        }

        // BankAcc 테이블 반영
        formBase.setApiTranDay(reqInfo.getApiTranDay());
        formBase.setApiTranId(bank001InDto.getXApiTranId());
        List<Bank001DetailInDto> accountInfoList = bank001InDto.getList();
        for(Bank001DetailInDto accountInfo : accountInfoList){
            if(accountInfo.getIsConsent()){
                accountList.add(new String[]{accountInfo.getAccountNum(), accountInfo.getSeqno()});
            }
            bankAccService.regBankAcc(accountInfo.getForm(formBase));
        }

        // scope 별로 수신 처리 실시
        for(int i = 1; i < reqInfo.getMemberToken().getScopeLists().size(); i++){
            recvBank002(reqInfo, formBase, accountList);
            recvBank003(reqInfo, formBase, accountList);
        }

        // 수신 상태 업데이트. 기관코드 + API 별로 종료 상태 저장.
        recvStatusForm.setRecvStatus("1");
        recvStatusForm.setRecvEndDt(CommUtil.getCurrentDateTime14());
        recvStatusService.updRecvStatus(recvStatusForm);
        return CompletableFuture.completedFuture(targetList);
    }


    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String[]>> recvBank002(ApiCallRequestInfoDto reqInfo, FormBase formBase, List<String[]> accountList){
        reqInfo.setRequestApiId("BANK_002");

        // 일단 삭제하고 시작. 해지계좌를 판별할 수 없기 때문에 먼저 전체 삭제함
        bankAccDepositService.delAllBankAccDeposit((BankAccDepositForm)formBase);

        for(String[] accountInfo : accountList) {
            reqInfo.setRequestParameterJson(reqBankParamsSetService.getParamsBank002(reqInfo.getMemberId(), reqInfo.getOrgCd(), accountInfo[0], accountInfo[1]));

            // 게이트웨이 call
            ApiCallResponseInfoDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(reqInfo, Bank002InDto.class, Bank002DetailInDto.class);
            Bank002InDto bank002InDto = (Bank002InDto) resInfo.getData();
            formBase.setApiTranId(bank002InDto.getXApiTranId());

            if (bank002InDto.getListCnt() != null && bank002InDto.getListCnt() > 0) {
                int accountSeq = 0;
                for (Bank002DetailInDto detail : bank002InDto.getList()) {
                    detail.setAccountSeq(++accountSeq);
                    bankAccDepositService.regBankAccDeposit(detail.getForm(formBase, accountInfo[0], accountInfo[1]));
                }
            }
        }
        return CompletableFuture.completedFuture(accountList);
    }


    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String[]>> recvBank003(ApiCallRequestInfoDto reqInfo, FormBase formBase, List<String[]> accountList){
        reqInfo.setRequestApiId("BANK_003");

        // 일단 삭제하고 시작. 해지계좌를 판별할 수 없기 때문에 먼저 전체 삭제함
        bankAccDepositAddService.delAllBankAccDepositAdd((BankAccDepositAddForm)formBase);

        for(String[] accountInfo : accountList) {
            reqInfo.setRequestParameterJson(reqBankParamsSetService.getParamsBank003(reqInfo.getMemberId(), reqInfo.getOrgCd(), accountInfo[0], accountInfo[1]));

            // 게이트웨이 call
            ApiCallResponseInfoDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(reqInfo, Bank003InDto.class, Bank003DetailInDto.class);
            Bank003InDto bank003InDto = (Bank003InDto) resInfo.getData();
            formBase.setApiTranId(bank003InDto.getXApiTranId());

            if (bank003InDto.getListCnt() != null && bank003InDto.getListCnt() > 0) {
                int accountSeq = 0;
                for (Bank003DetailInDto detail : bank003InDto.getList()) {
                    detail.setAccountSeq(++accountSeq);
                    bankAccDepositAddService.regBankAccDepositAdd(detail.getForm(formBase, accountInfo[0], accountInfo[1]));
                }
            }
        }
        return CompletableFuture.completedFuture(accountList);
    }
}
