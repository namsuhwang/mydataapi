package com.albee.mydataapi.api.base.bank.service;

import com.albee.mydataapi.api.base.bank.models.BankAccFundAddSearch;
import com.albee.mydataapi.api.base.bank.models.entity.BankAccFundAddEntity;
import com.albee.mydataapi.api.base.bank.models.form.BankAccFundAddForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface BankAccFundAddService{
    public BankAccFundAddEntity regBankAccFundAdd(BankAccFundAddForm dom);

    public BankAccFundAddEntity modBankAccFundAdd(BankAccFundAddForm dom);

    public void  delBankAccFundAdd(BankAccFundAddForm dom);

    public BankAccFundAddEntity getBankAccFundAdd(BankAccFundAddSearch dom);

    public ResultListDto<BankAccFundAddEntity> getBankAccFundAddList(BankAccFundAddSearch dom);
}
