package com.abcc.mydataapi.api.base.bank.service;

import com.abcc.mydataapi.api.base.bank.models.BankAccSearch;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccForm;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccEntity;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccService{
    public void regBankAcc(BankAccForm dom);
    public void updBankAcc(BankAccForm dom);

    public void modBankAcc(BankAccForm dom);

    public void  delBankAcc(BankAccForm dom);

    public void  allDelBankAcc(BankAccForm dom);

    public BankAccEntity getBankAcc(BankAccSearch dom);

    public ResultListDto<BankAccEntity> getBankAccList(BankAccSearch dom);
}
