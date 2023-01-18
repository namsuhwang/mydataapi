package com.kpcnc.mydataapi.api.base.bank.repository;

import com.kpcnc.mydataapi.api.base.bank.models.BankCustSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankCustEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankCustMapper{
    int insertBankCust(BankCustEntity dom);

    int updateBankCust(BankCustEntity dom);

    int deleteBankCust(BankCustEntity dom);

    BankCustEntity selectBankCust(BankCustSearch dom);

    Long selectBankCustListTotalCnt(BankCustSearch dom);

    List<BankCustEntity> selectBankCustList(BankCustSearch dom);
}
