package com.kpcnc.mydataapi.api.load.bank.service;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccLoanAddSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccLoanAddEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccLoanAddForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface BankAccLoanAddService{
    public BankAccLoanAddEntity regBankAccLoanAdd(BankAccLoanAddForm dom);

    public BankAccLoanAddEntity modBankAccLoanAdd(BankAccLoanAddForm dom);

    public void  delBankAccLoanAdd(BankAccLoanAddForm dom);

    public BankAccLoanAddEntity getBankAccLoanAdd(BankAccLoanAddSearch dom);

    public ResultListDto<BankAccLoanAddEntity> getBankAccLoanAddList(BankAccLoanAddSearch dom);
}
