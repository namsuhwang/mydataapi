package com.kpcnc.mydataapi.api.load.bank.service;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccLoanHistSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccLoanHistEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccLoanHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface BankAccLoanHistService{
    public BankAccLoanHistEntity regBankAccLoanHist(BankAccLoanHistForm dom);

    public BankAccLoanHistEntity modBankAccLoanHist(BankAccLoanHistForm dom);

    public void  delBankAccLoanHist(BankAccLoanHistForm dom);

    public BankAccLoanHistEntity getBankAccLoanHist(BankAccLoanHistSearch dom);

    public ResultListDto<BankAccLoanHistEntity> getBankAccLoanHistList(BankAccLoanHistSearch dom);
}
