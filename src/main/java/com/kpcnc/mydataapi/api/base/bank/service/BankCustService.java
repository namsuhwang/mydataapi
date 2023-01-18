package com.kpcnc.mydataapi.api.base.bank.service;

import com.kpcnc.mydataapi.api.base.bank.models.BankCustSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankCustEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankCustForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface BankCustService{
    public void regBankCust(BankCustForm dom);

    public void updBankCust(BankCustForm dom);

    public void modBankCust(BankCustForm dom);

    public void  delBankCust(BankCustForm dom);


    public BankCustEntity getBankCust(BankCustSearch dom);

    public ResultListDto<BankCustEntity> getBankCustList(BankCustSearch dom);
}
