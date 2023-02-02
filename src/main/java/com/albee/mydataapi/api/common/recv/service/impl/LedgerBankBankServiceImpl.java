package com.albee.mydataapi.api.common.recv.service.impl;

import com.albee.mydataapi.api.common.recv.service.LedgerBankService;
import com.albee.mydataapi.api.base.bank.models.*;
import com.albee.mydataapi.api.base.bank.models.entity.*;
import com.albee.mydataapi.api.base.bank.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class LedgerBankBankServiceImpl implements LedgerBankService {

    @Autowired
    BankAccDepositAddService bankAccDepositAddService;
    @Autowired
    BankAccDepositService bankAccDepositService;
    @Autowired
    BankAccDepositHistService bankAccDepositHistService;
    @Autowired
    BankAccEachProdService bankAccEachProdService;
    @Autowired
    BankAccFundAddService bankAccFundAddService;
    @Autowired BankAccFundService bankAccFundService;
    @Autowired BankAccLoanAddService bankAccLoanAddService;
    @Autowired BankAccLoanHistService bankAccLoanHistService;
    @Autowired BankAccFundHistService bankAccFundHistService;
    @Autowired BankAccLoanService bankAccLoanService;
    @Autowired BankAccProdService bankAccProdService;
    @Autowired BankAccProdHistService bankAccProdHistService;
    @Autowired BankAccService bankAccService;
    @Autowired BankAutoTransService bankAutoTransService;
    @Autowired BankCustService bankCustService;


    // BANK_001
    @Override
    public BankCustEntity getBankCust(String memberId, String orgCd) {
        return bankCustService.getBankCust(new BankCustSearch(memberId, orgCd));
    }

    // BANK_001
    @Override
    public BankAccEntity getBankAcc(String memberId, String orgCd, String accountNum, String seqno) {
        return bankAccService.getBankAcc(new BankAccSearch(memberId, orgCd, accountNum, seqno));
    }

    // BANK_002
    @Override
    public BankAccDepositEntity getBankAccDeposit(String memberId, String orgCd, String accountNum, String seqno) {
        return bankAccDepositService.getBankAccDeposit(new BankAccDepositSearch(memberId, orgCd, accountNum, seqno));
    }

    // BANK_003
    @Override
    public BankAccDepositAddEntity getBankAccDepositAdd(String memberId, String orgCd, String accountNum, String seqno) {
        return bankAccDepositAddService.getBankAccDepositAdd(new BankAccDepositAddSearch(memberId, orgCd, accountNum, seqno));
    }

    // BANK_004
    @Override
    public BankAccDepositHistEntity getBankAccDepositHistLast(String memberId, String orgCd, String accountNum, String seqno) {
        return bankAccDepositHistService.getBankAccDepositHistLast(new BankAccDepositHistSearch(memberId, orgCd, accountNum, seqno));
    }


    // BANK_005
    @Override
    public BankAccFundEntity getBankAccFund(String memberId, String orgCd, String accountNum, String seqno) {
        return bankAccFundService.getBankAccFund(new BankAccFundSearch(memberId, orgCd, accountNum, seqno));
    }

    // BANK_006
    @Override
    public BankAccFundAddEntity getBankAccFundAdd(String memberId, String orgCd, String accountNum, String seqno) {
        return bankAccFundAddService.getBankAccFundAdd(new BankAccFundAddSearch(memberId, orgCd, accountNum, seqno));
    }

    // BANK_007
    @Override
    public BankAccFundHistEntity getBankAccFundHistLast(String memberId, String orgCd, String accountNum, String seqno) {
        return bankAccFundHistService.getBankAccFundHistLast(new BankAccFundHistSearch(memberId, orgCd, accountNum, seqno));
    }

    // BANK_008
    @Override
    public BankAccLoanEntity getBankAccLoan(String memberId, String orgCd, String accountNum, String seqno) {
        return bankAccLoanService.getBankAccLoan(new BankAccLoanSearch(memberId, orgCd, accountNum, seqno));
    }

    // BANK_009
    @Override
    public BankAccLoanAddEntity getBankAccLoanAdd(String memberId, String orgCd, String accountNum, String seqno) {
        return bankAccLoanAddService.getBankAccLoanAdd(new BankAccLoanAddSearch(memberId, orgCd, accountNum, seqno));
    }

    // BANK_010
    @Override
    public BankAccLoanHistEntity getBankAccLoanHistLast(String memberId, String orgCd, String accountNum, String seqno) {
        return bankAccLoanHistService.getBankAccLoanHistLast(new BankAccLoanHistSearch(memberId, orgCd, accountNum, seqno));
    }

    // BANK_011
    @Override
    public BankAccProdEntity getBankAccProd(String memberId, String orgCd, String accountNum) {
        return bankAccProdService.getBankAccProd(new BankAccProdSearch(memberId, orgCd, accountNum));
    }

    // BANK_012
    @Override
    public BankAccProdHistEntity getBankAccProdHistLast(String memberId, String orgCd, String accountNum) {
        return bankAccProdHistService.getBankAccProdHistLast(new BankAccProdHistSearch(memberId, orgCd, accountNum));
    }

    // BANK_011
    @Override
    public BankAccEachProdEntity getBankAccEachProd(String memberId, String orgCd, String accountNum, String prodName) {
        return bankAccEachProdService.getBankAccEachProd(new BankAccEachProdSearch(memberId, orgCd, accountNum, prodName));
    }

    // BANK_012
    @Override
    public BankAutoTransEntity getBankAutoTrans(String memberId, String orgCd, String accountNum, String scheduledOrgCode
            , String scheduledAccountNum, BigDecimal scheduledAmt, String scheduledCycle, String scheduledDate) {
        return bankAutoTransService.getBankAutoTrans(
                new BankAutoTransSearch(memberId, orgCd, accountNum, scheduledOrgCode, scheduledAccountNum, scheduledAmt, scheduledCycle, scheduledDate));
    }
}
