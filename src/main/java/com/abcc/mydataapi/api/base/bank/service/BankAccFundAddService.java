package com.abcc.mydataapi.api.base.bank.service;

import com.abcc.mydataapi.api.base.bank.models.BankAccFundAddSearch;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccFundAddEntity;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccFundAddForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccFundAddService{
    public BankAccFundAddEntity regBankAccFundAdd(BankAccFundAddForm dom);

    public BankAccFundAddEntity modBankAccFundAdd(BankAccFundAddForm dom);

    public void  delBankAccFundAdd(BankAccFundAddForm dom);

    public BankAccFundAddEntity getBankAccFundAdd(BankAccFundAddSearch dom);

    public ResultListDto<BankAccFundAddEntity> getBankAccFundAddList(BankAccFundAddSearch dom);
}
