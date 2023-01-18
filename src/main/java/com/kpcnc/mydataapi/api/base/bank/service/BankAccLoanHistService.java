package com.kpcnc.mydataapi.api.base.bank.service;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccLoanHistSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccLoanHistEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccLoanHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccLoanHistService{
    public BankAccLoanHistEntity regBankAccLoanHist(BankAccLoanHistForm dom);

    public BankAccLoanHistEntity modBankAccLoanHist(BankAccLoanHistForm dom);

    public void  delBankAccLoanHist(BankAccLoanHistForm dom);

    public BankAccLoanHistEntity getBankAccLoanHist(BankAccLoanHistSearch dom);

    public BankAccLoanHistEntity getBankAccLoanHistLast(BankAccLoanHistSearch dom);

    public ResultListDto<BankAccLoanHistEntity> getBankAccLoanHistList(BankAccLoanHistSearch dom);
}
