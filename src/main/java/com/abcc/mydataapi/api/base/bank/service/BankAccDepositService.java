package com.abcc.mydataapi.api.base.bank.service;

import com.abcc.mydataapi.api.base.bank.models.BankAccDepositSearch;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccDepositEntity;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccDepositForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccDepositService{
    public void regBankAccDeposit(BankAccDepositForm dom);

    public void updBankAccDeposit(BankAccDepositForm dom);

    public void modBankAccDeposit(BankAccDepositForm dom);

    public void delBankAccDeposit(BankAccDepositForm dom);

    public void delAllBankAccDeposit(BankAccDepositForm dom);


    public BankAccDepositEntity getBankAccDeposit(BankAccDepositSearch dom);

    public BankAccDepositEntity getBankAccDepositLast(BankAccDepositSearch dom);

    public ResultListDto<BankAccDepositEntity> getBankAccDepositList(BankAccDepositSearch dom);
}
