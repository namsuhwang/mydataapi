package com.abcc.mydataapi.api.base.bank.service;

import com.abcc.mydataapi.api.base.bank.models.BankAccLoanSearch;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccLoanEntity;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccLoanForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccLoanService{
    public BankAccLoanEntity regBankAccLoan(BankAccLoanForm dom);

    public BankAccLoanEntity modBankAccLoan(BankAccLoanForm dom);

    public void  delBankAccLoan(BankAccLoanForm dom);

    public BankAccLoanEntity getBankAccLoan(BankAccLoanSearch dom);

    public ResultListDto<BankAccLoanEntity> getBankAccLoanList(BankAccLoanSearch dom);
}
