package com.kpcnc.mydataapi.api.load.bank.service;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccEachProdSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccEachProdEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccEachProdForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface BankAccEachProdService{
    public BankAccEachProdEntity regBankAccEachProd(BankAccEachProdForm dom);

    public BankAccEachProdEntity modBankAccEachProd(BankAccEachProdForm dom);

    public void  delBankAccEachProd(BankAccEachProdForm dom);

    public BankAccEachProdEntity getBankAccEachProd(BankAccEachProdSearch dom);

    public ResultListDto<BankAccEachProdEntity> getBankAccEachProdList(BankAccEachProdSearch dom);
}
