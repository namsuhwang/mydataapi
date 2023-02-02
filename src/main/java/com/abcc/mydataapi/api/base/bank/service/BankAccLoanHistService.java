package com.abcc.mydataapi.api.base.bank.service;

import com.abcc.mydataapi.api.base.bank.models.BankAccLoanHistSearch;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccLoanHistForm;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccLoanHistEntity;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccLoanHistService{
    public BankAccLoanHistEntity regBankAccLoanHist(BankAccLoanHistForm dom);

    public BankAccLoanHistEntity modBankAccLoanHist(BankAccLoanHistForm dom);

    public void  delBankAccLoanHist(BankAccLoanHistForm dom);

    public BankAccLoanHistEntity getBankAccLoanHist(BankAccLoanHistSearch dom);

    public BankAccLoanHistEntity getBankAccLoanHistLast(BankAccLoanHistSearch dom);

    public ResultListDto<BankAccLoanHistEntity> getBankAccLoanHistList(BankAccLoanHistSearch dom);
}
