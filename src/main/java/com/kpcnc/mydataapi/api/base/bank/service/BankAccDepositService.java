package com.kpcnc.mydataapi.api.base.bank.service;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccDepositSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccDepositEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccDepositForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccDepositService{
    public void regBankAccDeposit(BankAccDepositForm dom);

    public void updBankAccDeposit(BankAccDepositForm dom);

    public void modBankAccDeposit(BankAccDepositForm dom);

    public void delBankAccDeposit(BankAccDepositForm dom);

    public void delAllBankAccDeposit(BankAccDepositForm dom);


    public BankAccDepositEntity getBankAccDeposit(BankAccDepositSearch dom);

    public ResultListDto<BankAccDepositEntity> getBankAccDepositList(BankAccDepositSearch dom);
}
