package com.kpcnc.mydataapi.api.base.bank.service;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccLoanHistIntSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccLoanHistIntEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccLoanHistIntForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccLoanHistIntService{
    public BankAccLoanHistIntEntity regBankAccLoanHistInt(BankAccLoanHistIntForm dom);

    public BankAccLoanHistIntEntity modBankAccLoanHistInt(BankAccLoanHistIntForm dom);

    public void  delBankAccLoanHistInt(BankAccLoanHistIntForm dom);

    public BankAccLoanHistIntEntity getBankAccLoanHistInt(BankAccLoanHistIntSearch dom);

    public ResultListDto<BankAccLoanHistIntEntity> getBankAccLoanHistIntList(BankAccLoanHistIntSearch dom);
}
