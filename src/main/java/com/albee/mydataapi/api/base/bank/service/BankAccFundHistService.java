package com.albee.mydataapi.api.base.bank.service;

import com.albee.mydataapi.api.base.bank.models.BankAccFundHistSearch;
import com.albee.mydataapi.api.base.bank.models.form.BankAccFundHistForm;
import com.albee.mydataapi.api.base.bank.models.entity.BankAccFundHistEntity;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface BankAccFundHistService{
    public BankAccFundHistEntity regBankAccFundHist(BankAccFundHistForm dom);

    public BankAccFundHistEntity modBankAccFundHist(BankAccFundHistForm dom);

    public void  delBankAccFundHist(BankAccFundHistForm dom);

    public BankAccFundHistEntity getBankAccFundHist(BankAccFundHistSearch dom);

    public BankAccFundHistEntity getBankAccFundHistLast(BankAccFundHistSearch dom);

    public ResultListDto<BankAccFundHistEntity> getBankAccFundHistList(BankAccFundHistSearch dom);
}
