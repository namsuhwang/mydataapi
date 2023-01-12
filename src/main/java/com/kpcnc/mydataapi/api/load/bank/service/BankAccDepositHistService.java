package com.kpcnc.mydataapi.api.load.bank.service;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccDepositHistSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccDepositHistEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccDepositHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface BankAccDepositHistService{
    public BankAccDepositHistEntity regBankAccDepositHist(BankAccDepositHistForm dom);

    public BankAccDepositHistEntity modBankAccDepositHist(BankAccDepositHistForm dom);

    public void  delBankAccDepositHist(BankAccDepositHistForm dom);

    public BankAccDepositHistEntity getBankAccDepositHist(BankAccDepositHistSearch dom);

    public ResultListDto<BankAccDepositHistEntity> getBankAccDepositHistList(BankAccDepositHistSearch dom);
}
