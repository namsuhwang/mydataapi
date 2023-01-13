package com.kpcnc.mydataapi.api.base.bank.service;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccLoanAddSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccLoanAddEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccLoanAddForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccLoanAddService{
    public BankAccLoanAddEntity regBankAccLoanAdd(BankAccLoanAddForm dom);

    public BankAccLoanAddEntity modBankAccLoanAdd(BankAccLoanAddForm dom);

    public void  delBankAccLoanAdd(BankAccLoanAddForm dom);

    public BankAccLoanAddEntity getBankAccLoanAdd(BankAccLoanAddSearch dom);

    public ResultListDto<BankAccLoanAddEntity> getBankAccLoanAddList(BankAccLoanAddSearch dom);
}
