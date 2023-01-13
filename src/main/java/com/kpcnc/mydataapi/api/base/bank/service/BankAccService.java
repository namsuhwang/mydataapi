package com.kpcnc.mydataapi.api.base.bank.service;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccService{
    public BankAccEntity regBankAcc(BankAccForm dom);

    public BankAccEntity modBankAcc(BankAccForm dom);

    public void  delBankAcc(BankAccForm dom);

    public BankAccEntity getBankAcc(BankAccSearch dom);

    public ResultListDto<BankAccEntity> getBankAccList(BankAccSearch dom);
}
