package com.kpcnc.mydataapi.api.load.bank.service;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccProdHistSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccProdHistEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccProdHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface BankAccProdHistService{
    public BankAccProdHistEntity regBankAccProdHist(BankAccProdHistForm dom);

    public BankAccProdHistEntity modBankAccProdHist(BankAccProdHistForm dom);

    public void  delBankAccProdHist(BankAccProdHistForm dom);

    public BankAccProdHistEntity getBankAccProdHist(BankAccProdHistSearch dom);

    public ResultListDto<BankAccProdHistEntity> getBankAccProdHistList(BankAccProdHistSearch dom);
}
