package com.kpcnc.mydataapi.api.load.bank.service;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccFundHistSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccFundHistEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccFundHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface BankAccFundHistService{
    public BankAccFundHistEntity regBankAccFundHist(BankAccFundHistForm dom);

    public BankAccFundHistEntity modBankAccFundHist(BankAccFundHistForm dom);

    public void  delBankAccFundHist(BankAccFundHistForm dom);

    public BankAccFundHistEntity getBankAccFundHist(BankAccFundHistSearch dom);

    public ResultListDto<BankAccFundHistEntity> getBankAccFundHistList(BankAccFundHistSearch dom);
}
