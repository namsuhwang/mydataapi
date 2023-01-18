package com.kpcnc.mydataapi.api.base.bank.service;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccDepositHistSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccDepositHistEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccDepositHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface BankAccDepositHistService{
    public BankAccDepositHistEntity regBankAccDepositHist(BankAccDepositHistForm dom);

    public BankAccDepositHistEntity modBankAccDepositHist(BankAccDepositHistForm dom);

    public void  delBankAccDepositHist(BankAccDepositHistForm dom);

    public BankAccDepositHistEntity getBankAccDepositHist(BankAccDepositHistSearch dom);

    public BankAccDepositHistEntity getBankAccDepositHistLast(BankAccDepositHistSearch dom);

    public ResultListDto<BankAccDepositHistEntity> getBankAccDepositHistList(BankAccDepositHistSearch dom);
}
