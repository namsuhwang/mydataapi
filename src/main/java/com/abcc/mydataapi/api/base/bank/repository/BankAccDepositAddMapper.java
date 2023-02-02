package com.abcc.mydataapi.api.base.bank.repository;

import com.abcc.mydataapi.api.base.bank.models.BankAccDepositAddSearch;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccDepositAddEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAccDepositAddMapper{
    int insertBankAccDepositAdd(BankAccDepositAddEntity dom);

    int updateBankAccDepositAdd(BankAccDepositAddEntity dom);

    int deleteBankAccDepositAdd(BankAccDepositAddEntity dom);

    int deleteAllBankAccDepositAdd(BankAccDepositAddEntity dom);

    BankAccDepositAddEntity selectBankAccDepositAdd(BankAccDepositAddSearch dom);

    BankAccDepositAddEntity selectBankAccDepositAddLast(BankAccDepositAddSearch dom);

    Long selectBankAccDepositAddListTotalCnt(BankAccDepositAddSearch dom);

    List<BankAccDepositAddEntity> selectBankAccDepositAddList(BankAccDepositAddSearch dom);
}
