package com.albee.mydataapi.api.base.bank.service;

import com.albee.mydataapi.api.base.bank.models.BankAutoTransSearch;
import com.albee.mydataapi.api.base.bank.models.entity.BankAutoTransEntity;
import com.albee.mydataapi.api.base.bank.models.form.BankAutoTransForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface BankAutoTransService{
    public void regBankAutoTrans(BankAutoTransForm dom);

    public void updBankAutoTrans(BankAutoTransForm dom);

    public void modBankAutoTrans(BankAutoTransForm dom);

    public void  delBankAutoTrans(BankAutoTransForm dom);

    public void  allDelBankAutoTrans(BankAutoTransForm dom);

    public BankAutoTransEntity getBankAutoTrans(BankAutoTransSearch dom);

    public BankAutoTransEntity getBankAutoTransLast(BankAutoTransSearch dom);

    public ResultListDto<BankAutoTransEntity> getBankAutoTransList(BankAutoTransSearch dom);
}
