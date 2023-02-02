package com.abcc.mydataapi.api.base.bank.service;

import com.abcc.mydataapi.api.base.bank.models.BankAccFundSearch;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccFundEntity;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccFundForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccFundService{
    public BankAccFundEntity regBankAccFund(BankAccFundForm dom);

    public BankAccFundEntity modBankAccFund(BankAccFundForm dom);

    public void  delBankAccFund(BankAccFundForm dom);

    public BankAccFundEntity getBankAccFund(BankAccFundSearch dom);

    public ResultListDto<BankAccFundEntity> getBankAccFundList(BankAccFundSearch dom);
}
