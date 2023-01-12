package com.kpcnc.mydataapi.api.load.bank.service;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccFundSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccFundEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccFundForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface BankAccFundService{
    public BankAccFundEntity regBankAccFund(BankAccFundForm dom);

    public BankAccFundEntity modBankAccFund(BankAccFundForm dom);

    public void  delBankAccFund(BankAccFundForm dom);

    public BankAccFundEntity getBankAccFund(BankAccFundSearch dom);

    public ResultListDto<BankAccFundEntity> getBankAccFundList(BankAccFundSearch dom);
}
