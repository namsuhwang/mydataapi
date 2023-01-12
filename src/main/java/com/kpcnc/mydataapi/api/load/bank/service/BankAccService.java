package com.kpcnc.mydataapi.api.load.bank.service;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface BankAccService{
    public BankAccEntity regBankAcc(BankAccForm dom);

    public BankAccEntity modBankAcc(BankAccForm dom);

    public void  delBankAcc(BankAccForm dom);

    public BankAccEntity getBankAcc(BankAccSearch dom);

    public ResultListDto<BankAccEntity> getBankAccList(BankAccSearch dom);
}
