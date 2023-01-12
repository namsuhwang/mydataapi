package com.kpcnc.mydataapi.api.load.bank.service;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccProdSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccProdEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccProdForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface BankAccProdService{
    public BankAccProdEntity regBankAccProd(BankAccProdForm dom);

    public BankAccProdEntity modBankAccProd(BankAccProdForm dom);

    public void  delBankAccProd(BankAccProdForm dom);

    public BankAccProdEntity getBankAccProd(BankAccProdSearch dom);

    public ResultListDto<BankAccProdEntity> getBankAccProdList(BankAccProdSearch dom);
}
