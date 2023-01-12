package com.kpcnc.mydataapi.api.load.bank.service;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccDepositAddSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccDepositAddEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccDepositAddForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface BankAccDepositAddService{
    public BankAccDepositAddEntity regBankAccDepositAdd(BankAccDepositAddForm dom);

    public BankAccDepositAddEntity modBankAccDepositAdd(BankAccDepositAddForm dom);

    public void  delBankAccDepositAdd(BankAccDepositAddForm dom);

    public BankAccDepositAddEntity getBankAccDepositAdd(BankAccDepositAddSearch dom);

    public ResultListDto<BankAccDepositAddEntity> getBankAccDepositAddList(BankAccDepositAddSearch dom);
}
