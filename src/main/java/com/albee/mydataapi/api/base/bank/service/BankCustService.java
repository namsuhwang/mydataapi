package com.albee.mydataapi.api.base.bank.service;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.bank.models.BankCustSearch;
import com.albee.mydataapi.api.base.bank.models.entity.BankCustEntity;
import com.albee.mydataapi.api.base.bank.models.form.BankCustForm;

public interface BankCustService{
    public void regBankCust(BankCustForm dom);

    public void updBankCust(BankCustForm dom);

    public void modBankCust(BankCustForm dom);

    public void  delBankCust(BankCustForm dom);


    public BankCustEntity getBankCust(BankCustSearch dom);

    public ResultListDto<BankCustEntity> getBankCustList(BankCustSearch dom);
}
