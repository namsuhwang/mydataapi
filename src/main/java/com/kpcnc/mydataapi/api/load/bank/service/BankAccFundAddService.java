package com.kpcnc.mydataapi.api.load.bank.service;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccFundAddSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccFundAddEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccFundAddForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface BankAccFundAddService{
    public BankAccFundAddEntity regBankAccFundAdd(BankAccFundAddForm dom);

    public BankAccFundAddEntity modBankAccFundAdd(BankAccFundAddForm dom);

    public void  delBankAccFundAdd(BankAccFundAddForm dom);

    public BankAccFundAddEntity getBankAccFundAdd(BankAccFundAddSearch dom);

    public ResultListDto<BankAccFundAddEntity> getBankAccFundAddList(BankAccFundAddSearch dom);
}
