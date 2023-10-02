package com.albee.mydataapi.api.base.bank.service;

import com.albee.mydataapi.api.base.bank.models.BankAccLoanSearch;
import com.albee.mydataapi.api.base.bank.models.entity.BankAccLoanEntity;
import com.albee.mydataapi.api.base.bank.models.form.BankAccLoanForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface BankAccLoanService{
    public BankAccLoanEntity regBankAccLoan(BankAccLoanForm dom);

    public BankAccLoanEntity modBankAccLoan(BankAccLoanForm dom);

    public void  delBankAccLoan(BankAccLoanForm dom);

    public BankAccLoanEntity getBankAccLoan(BankAccLoanSearch dom);

    public ResultListDto<BankAccLoanEntity> getBankAccLoanList(BankAccLoanSearch dom);
}
