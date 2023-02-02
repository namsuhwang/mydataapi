package com.albee.mydataapi.api.base.bank.service;

import com.albee.mydataapi.api.base.bank.models.BankAccEachProdSearch;
import com.albee.mydataapi.api.base.bank.models.entity.BankAccEachProdEntity;
import com.albee.mydataapi.api.base.bank.models.form.BankAccEachProdForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface BankAccEachProdService{
    public BankAccEachProdEntity regBankAccEachProd(BankAccEachProdForm dom);

    public BankAccEachProdEntity modBankAccEachProd(BankAccEachProdForm dom);

    public void  delBankAccEachProd(BankAccEachProdForm dom);

    public BankAccEachProdEntity getBankAccEachProd(BankAccEachProdSearch dom);

    public BankAccEachProdEntity getBankAccEachProdLast(BankAccEachProdSearch dom);

    public ResultListDto<BankAccEachProdEntity> getBankAccEachProdList(BankAccEachProdSearch dom);
}
