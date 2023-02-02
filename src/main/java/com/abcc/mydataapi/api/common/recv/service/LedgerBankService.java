package com.abcc.mydataapi.api.common.recv.service;

import com.abcc.mydataapi.api.base.bank.models.entity.*;
import com.abcc.mydataapi.api.base.bank.models.entity.*;

import java.math.BigDecimal;

public interface LedgerBankService {

    // BANK_001
    public BankCustEntity getBankCust(String memberId, String orgCd);

    // BANK_001
    public BankAccEntity getBankAcc(String memberId, String orgCd, String accountNum, String seqno);

    // BANK_002
    public BankAccDepositEntity getBankAccDeposit(String memberId, String orgCd, String accountNum, String seqno);

    // BANK_003
    public BankAccDepositAddEntity getBankAccDepositAdd(String memberId, String orgCd, String accountNum, String seqno);

    // BANK_004
    public BankAccDepositHistEntity getBankAccDepositHistLast(String memberId, String orgCd, String accountNum, String seqno);

    // BANK_005
    public BankAccFundEntity getBankAccFund(String memberId, String orgCd, String accountNum, String seqno);

    // BANK_006
    public BankAccFundAddEntity getBankAccFundAdd(String memberId, String orgCd, String accountNum, String seqno);

    // BANK_007
    public BankAccFundHistEntity getBankAccFundHistLast(String memberId, String orgCd, String accountNum, String seqno);


    // BANK_008
    public BankAccLoanEntity getBankAccLoan(String memberId, String orgCd, String accountNum, String seqno);

    // BANK_009
    public BankAccLoanAddEntity getBankAccLoanAdd(String memberId, String orgCd, String accountNum, String seqno);

    // BANK_010
    public BankAccLoanHistEntity getBankAccLoanHistLast(String memberId, String orgCd, String accountNum, String seqno);

    // BANK_011
    public BankAccProdEntity getBankAccProd(String memberId, String orgCd, String accountNum);


    // BANK_012
    public BankAccProdHistEntity getBankAccProdHistLast(String memberId, String orgCd, String accountNum);


    // BANK_013
    public BankAccEachProdEntity getBankAccEachProd(String memberId, String orgCd, String accountNum, String prodName);


    // BANK_014
    public BankAutoTransEntity getBankAutoTrans(String memberId, String orgCd, String accountNum, String scheduledOrgCode
            , String scheduledAccountNum, BigDecimal scheduledAmt, String scheduledCycle, String scheduledDate);

}
