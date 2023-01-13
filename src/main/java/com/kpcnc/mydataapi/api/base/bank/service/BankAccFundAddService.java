package com.kpcnc.mydataapi.api.base.bank.service;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccFundAddSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccFundAddEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccFundAddForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccFundAddService{
    public BankAccFundAddEntity regBankAccFundAdd(BankAccFundAddForm dom);

    public BankAccFundAddEntity modBankAccFundAdd(BankAccFundAddForm dom);

    public void  delBankAccFundAdd(BankAccFundAddForm dom);

    public BankAccFundAddEntity getBankAccFundAdd(BankAccFundAddSearch dom);

    public ResultListDto<BankAccFundAddEntity> getBankAccFundAddList(BankAccFundAddSearch dom);
}
