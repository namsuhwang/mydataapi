package com.abcc.mydataapi.api.base.bank.service;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.bank.models.BankCustSearch;
import com.abcc.mydataapi.api.base.bank.models.entity.BankCustEntity;
import com.abcc.mydataapi.api.base.bank.models.form.BankCustForm;

public interface BankCustService{
    public void regBankCust(BankCustForm dom);

    public void updBankCust(BankCustForm dom);

    public void modBankCust(BankCustForm dom);

    public void  delBankCust(BankCustForm dom);


    public BankCustEntity getBankCust(BankCustSearch dom);

    public ResultListDto<BankCustEntity> getBankCustList(BankCustSearch dom);
}
