package com.albee.mydataapi.api.base.bank.service;

import com.albee.mydataapi.api.base.bank.models.BankAccFundSearch;
import com.albee.mydataapi.api.base.bank.models.entity.BankAccFundEntity;
import com.albee.mydataapi.api.base.bank.models.form.BankAccFundForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface BankAccFundService{
    public BankAccFundEntity regBankAccFund(BankAccFundForm dom);

    public BankAccFundEntity modBankAccFund(BankAccFundForm dom);

    public void  delBankAccFund(BankAccFundForm dom);

    public BankAccFundEntity getBankAccFund(BankAccFundSearch dom);

    public ResultListDto<BankAccFundEntity> getBankAccFundList(BankAccFundSearch dom);
}
