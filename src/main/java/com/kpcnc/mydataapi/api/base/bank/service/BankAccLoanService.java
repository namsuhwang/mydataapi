package com.kpcnc.mydataapi.api.base.bank.service;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccLoanSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccLoanEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccLoanForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccLoanService{
    public BankAccLoanEntity regBankAccLoan(BankAccLoanForm dom);

    public BankAccLoanEntity modBankAccLoan(BankAccLoanForm dom);

    public void  delBankAccLoan(BankAccLoanForm dom);

    public BankAccLoanEntity getBankAccLoan(BankAccLoanSearch dom);

    public ResultListDto<BankAccLoanEntity> getBankAccLoanList(BankAccLoanSearch dom);
}
