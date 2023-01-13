package com.kpcnc.mydataapi.api.base.bank.service;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccDepositAddSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccDepositAddEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccDepositAddForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccDepositAddService{
    public BankAccDepositAddEntity regBankAccDepositAdd(BankAccDepositAddForm dom);

    public BankAccDepositAddEntity modBankAccDepositAdd(BankAccDepositAddForm dom);

    public void  delBankAccDepositAdd(BankAccDepositAddForm dom);

    public BankAccDepositAddEntity getBankAccDepositAdd(BankAccDepositAddSearch dom);

    public ResultListDto<BankAccDepositAddEntity> getBankAccDepositAddList(BankAccDepositAddSearch dom);
}
