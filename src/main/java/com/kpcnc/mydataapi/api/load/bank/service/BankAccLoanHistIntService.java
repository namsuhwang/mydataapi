package com.kpcnc.mydataapi.api.load.bank.service;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccLoanHistIntSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccLoanHistIntEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccLoanHistIntForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface BankAccLoanHistIntService{
    public BankAccLoanHistIntEntity regBankAccLoanHistInt(BankAccLoanHistIntForm dom);

    public BankAccLoanHistIntEntity modBankAccLoanHistInt(BankAccLoanHistIntForm dom);

    public void  delBankAccLoanHistInt(BankAccLoanHistIntForm dom);

    public BankAccLoanHistIntEntity getBankAccLoanHistInt(BankAccLoanHistIntSearch dom);

    public ResultListDto<BankAccLoanHistIntEntity> getBankAccLoanHistIntList(BankAccLoanHistIntSearch dom);
}
