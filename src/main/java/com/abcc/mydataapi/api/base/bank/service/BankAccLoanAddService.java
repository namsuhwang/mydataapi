package com.abcc.mydataapi.api.base.bank.service;

import com.abcc.mydataapi.api.base.bank.models.BankAccLoanAddSearch;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccLoanAddForm;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccLoanAddEntity;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccLoanAddService{
    public BankAccLoanAddEntity regBankAccLoanAdd(BankAccLoanAddForm dom);

    public BankAccLoanAddEntity modBankAccLoanAdd(BankAccLoanAddForm dom);

    public void  delBankAccLoanAdd(BankAccLoanAddForm dom);

    public BankAccLoanAddEntity getBankAccLoanAdd(BankAccLoanAddSearch dom);

    public ResultListDto<BankAccLoanAddEntity> getBankAccLoanAddList(BankAccLoanAddSearch dom);
}
