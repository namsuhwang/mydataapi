package com.kpcnc.mydataapi.api.base.bank.service;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccEachProdSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccEachProdEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccEachProdForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccEachProdService{
    public BankAccEachProdEntity regBankAccEachProd(BankAccEachProdForm dom);

    public BankAccEachProdEntity modBankAccEachProd(BankAccEachProdForm dom);

    public void  delBankAccEachProd(BankAccEachProdForm dom);

    public BankAccEachProdEntity getBankAccEachProd(BankAccEachProdSearch dom);

    public ResultListDto<BankAccEachProdEntity> getBankAccEachProdList(BankAccEachProdSearch dom);
}
