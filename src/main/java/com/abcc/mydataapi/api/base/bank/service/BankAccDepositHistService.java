package com.abcc.mydataapi.api.base.bank.service;

import com.abcc.mydataapi.api.base.bank.models.BankAccDepositHistSearch;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccDepositHistForm;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccDepositHistEntity;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccDepositHistService{
    public BankAccDepositHistEntity regBankAccDepositHist(BankAccDepositHistForm dom);

    public BankAccDepositHistEntity modBankAccDepositHist(BankAccDepositHistForm dom);

    public void  delBankAccDepositHist(BankAccDepositHistForm dom);

    public BankAccDepositHistEntity getBankAccDepositHist(BankAccDepositHistSearch dom);

    public BankAccDepositHistEntity getBankAccDepositHistLast(BankAccDepositHistSearch dom);

    public ResultListDto<BankAccDepositHistEntity> getBankAccDepositHistList(BankAccDepositHistSearch dom);
}
