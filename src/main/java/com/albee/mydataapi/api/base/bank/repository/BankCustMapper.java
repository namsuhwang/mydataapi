package com.albee.mydataapi.api.base.bank.repository;

import com.albee.mydataapi.api.base.bank.models.BankCustSearch;
import com.albee.mydataapi.api.base.bank.models.entity.BankCustEntity;
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
