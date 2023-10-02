package com.albee.mydataapi.api.base.bank.service;

import com.albee.mydataapi.api.base.bank.models.BankAccDepositAddSearch;
import com.albee.mydataapi.api.base.bank.models.entity.BankAccDepositAddEntity;
import com.albee.mydataapi.api.base.bank.models.form.BankAccDepositAddForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface BankAccDepositAddService{
    public void regBankAccDepositAdd(BankAccDepositAddForm dom);

    public void updBankAccDepositAdd(BankAccDepositAddForm dom);

    public void modBankAccDepositAdd(BankAccDepositAddForm dom);

    public void delBankAccDepositAdd(BankAccDepositAddForm dom);

    public void delAllBankAccDepositAdd(BankAccDepositAddForm dom);

    public BankAccDepositAddEntity getBankAccDepositAdd(BankAccDepositAddSearch dom);

    public BankAccDepositAddEntity getBankAccDepositAddLast(BankAccDepositAddSearch dom);

    public ResultListDto<BankAccDepositAddEntity> getBankAccDepositAddList(BankAccDepositAddSearch dom);
}
