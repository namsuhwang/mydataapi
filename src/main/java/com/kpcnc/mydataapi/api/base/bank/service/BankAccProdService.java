package com.kpcnc.mydataapi.api.base.bank.service;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccProdSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccProdEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccProdForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccProdService{
    public BankAccProdEntity regBankAccProd(BankAccProdForm dom);

    public BankAccProdEntity modBankAccProd(BankAccProdForm dom);

    public void  delBankAccProd(BankAccProdForm dom);

    public BankAccProdEntity getBankAccProd(BankAccProdSearch dom);

    public ResultListDto<BankAccProdEntity> getBankAccProdList(BankAccProdSearch dom);
}
