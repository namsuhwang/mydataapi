package com.kpcnc.mydataapi.api.base.bank.service;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccDepositSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccDepositEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccDepositForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccDepositService{
    public BankAccDepositEntity regBankAccDeposit(BankAccDepositForm dom);

    public BankAccDepositEntity modBankAccDeposit(BankAccDepositForm dom);

    public void  delBankAccDeposit(BankAccDepositForm dom);

    public BankAccDepositEntity getBankAccDeposit(BankAccDepositSearch dom);

    public ResultListDto<BankAccDepositEntity> getBankAccDepositList(BankAccDepositSearch dom);
}