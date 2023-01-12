package com.kpcnc.mydataapi.api.load.bank.service;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccLoanSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccLoanEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccLoanForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface BankAccLoanService{
    public BankAccLoanEntity regBankAccLoan(BankAccLoanForm dom);

    public BankAccLoanEntity modBankAccLoan(BankAccLoanForm dom);

    public void  delBankAccLoan(BankAccLoanForm dom);

    public BankAccLoanEntity getBankAccLoan(BankAccLoanSearch dom);

    public ResultListDto<BankAccLoanEntity> getBankAccLoanList(BankAccLoanSearch dom);
}
