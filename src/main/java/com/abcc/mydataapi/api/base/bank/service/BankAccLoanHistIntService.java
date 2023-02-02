package com.abcc.mydataapi.api.base.bank.service;

import com.abcc.mydataapi.api.base.bank.models.BankAccLoanHistIntSearch;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccLoanHistIntEntity;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccLoanHistIntForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccLoanHistIntService{
    public BankAccLoanHistIntEntity regBankAccLoanHistInt(BankAccLoanHistIntForm dom);

    public BankAccLoanHistIntEntity modBankAccLoanHistInt(BankAccLoanHistIntForm dom);

    public void  delBankAccLoanHistInt(BankAccLoanHistIntForm dom);

    public BankAccLoanHistIntEntity getBankAccLoanHistInt(BankAccLoanHistIntSearch dom);

    public ResultListDto<BankAccLoanHistIntEntity> getBankAccLoanHistIntList(BankAccLoanHistIntSearch dom);
}
