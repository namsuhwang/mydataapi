package com.kpcnc.mydataapi.api.base.bank.service;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccProdHistSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccProdHistEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccProdHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccProdHistService{
    public BankAccProdHistEntity regBankAccProdHist(BankAccProdHistForm dom);

    public BankAccProdHistEntity modBankAccProdHist(BankAccProdHistForm dom);

    public void  delBankAccProdHist(BankAccProdHistForm dom);

    public BankAccProdHistEntity getBankAccProdHist(BankAccProdHistSearch dom);

    public BankAccProdHistEntity getBankAccProdHistLast(BankAccProdHistSearch dom);

    public ResultListDto<BankAccProdHistEntity> getBankAccProdHistList(BankAccProdHistSearch dom);
}
