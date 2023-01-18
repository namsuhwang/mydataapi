package com.kpcnc.mydataapi.api.common.recv.service.impl;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccDepositSearch;
import com.kpcnc.mydataapi.api.base.bank.models.BankAccSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccDepositEntity;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccDepositHistEntity;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccEntity;
import com.kpcnc.mydataapi.api.base.bank.service.BankAccDepositService;
import com.kpcnc.mydataapi.api.base.bank.service.BankAccService;
import com.kpcnc.mydataapi.api.common.recv.models.RecvBaselineSearch;
import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvBaselineForm;
import com.kpcnc.mydataapi.api.common.recv.repository.RecvBaselineMapper;
import com.kpcnc.mydataapi.api.common.recv.service.LedgerBankService;
import com.kpcnc.mydataapi.api.common.recv.service.RecvBaselineService;
import com.kpcnc.mydataapi.api.common.recv.service.RequestParamsSetService;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class RequestParamsSetServiceImpl implements RequestParamsSetService {
    @Autowired
    RecvBaselineService recvBaselineService;

    @Autowired
    LedgerBankService ledgerBankService;

    // BankAcc
    public HashMap<String, Object> getParamsBank001(String memberId, String orgCd){
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(
                new RecvBaselineSearch(memberId, orgCd, "BANK_001"));
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("member_id", memberId);  // 추후에 케이트웨이와 협의하에 파라메터 수정
        paramsMap.put("org_code", orgCd);
        paramsMap.put("search_timestamp", baseline.getSearchTimeStamp());
        paramsMap.put("next_page", baseline.getNextPage());
        paramsMap.put("limit", 500);
        return paramsMap;
    }

    // BankAccDeposit
    public HashMap<String, Object> getParamsBank002(String memberId, String orgCd, String accountNum, String seqno){
        BankAccDepositEntity bankAccDeposit = ledgerBankService.getBankAccDeposit(memberId, orgCd, accountNum, seqno);
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(
                new RecvBaselineSearch(memberId, orgCd, "BANK_002", bankAccDeposit.getApiTranDay(), bankAccDeposit.getApiTranId()));
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("org_code", orgCd);
        paramsMap.put("account_num", accountNum);
        paramsMap.put("seqno", seqno);
        paramsMap.put("search_timestamp", baseline.getSearchTimeStamp());
        return paramsMap;
    }

    // BankAccDepositAdd
    public HashMap<String, Object> getParamsBank003(String memberId, String orgCd, String accountNum, String seqno){
        BankAccDepositEntity bankAccDeposit = ledgerBankService.getBankAccDeposit(memberId, orgCd, accountNum, seqno);
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(
                new RecvBaselineSearch(memberId, orgCd, "BANK_003", bankAccDeposit.getApiTranDay(), bankAccDeposit.getApiTranId()));
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("org_code", orgCd);
        paramsMap.put("account_num", accountNum);
        paramsMap.put("seqno", seqno);
        paramsMap.put("search_timestamp", baseline.getSearchTimeStamp());
        return paramsMap;
    }


    // BankAccDepositHist
    public HashMap<String, Object> getParamsBank004(String memberId, String orgCd, String accountNum, String seqno, String fromDate, String toDate){
        BankAccDepositHistEntity bankAccDeposit = ledgerBankService.getBankAccDepositHistLast(memberId, orgCd, accountNum, seqno);
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(
                new RecvBaselineSearch(memberId, orgCd, "BANK_004", bankAccDeposit.getApiTranDay(), bankAccDeposit.getApiTranId()));
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("org_code", orgCd);
        paramsMap.put("account_num", accountNum);
        paramsMap.put("seqno", seqno);
        paramsMap.put("from_date", fromDate);
        paramsMap.put("to_date", toDate);
        paramsMap.put("next_page", baseline.getNextPage());
        paramsMap.put("limit", 500);
        return paramsMap;
    }

}
