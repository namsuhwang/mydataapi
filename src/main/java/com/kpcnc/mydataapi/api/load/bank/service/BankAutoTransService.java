package com.kpcnc.mydataapi.api.load.bank.service;

import com.kpcnc.mydataapi.api.load.bank.models.BankAutoTransSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAutoTransEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAutoTransForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface BankAutoTransService{
    public BankAutoTransEntity regBankAutoTrans(BankAutoTransForm dom);

    public BankAutoTransEntity modBankAutoTrans(BankAutoTransForm dom);

    public void  delBankAutoTrans(BankAutoTransForm dom);

    public BankAutoTransEntity getBankAutoTrans(BankAutoTransSearch dom);

    public ResultListDto<BankAutoTransEntity> getBankAutoTransList(BankAutoTransSearch dom);
}
