package com.abcc.mydataapi.api.base.bank.repository;

import com.abcc.mydataapi.api.base.bank.models.BankAutoTransSearch;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAutoTransEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAutoTransMapper{
    int insertBankAutoTrans(BankAutoTransEntity dom);

    int updateBankAutoTrans(BankAutoTransEntity dom);

    int deleteBankAutoTrans(BankAutoTransEntity dom);

    int deleteAllBankAutoTrans(BankAutoTransEntity dom);

    BankAutoTransEntity selectBankAutoTrans(BankAutoTransSearch dom);

    BankAutoTransEntity selectBankAutoTransLast(BankAutoTransSearch dom);

    Long selectBankAutoTransListTotalCnt(BankAutoTransSearch dom);

    List<BankAutoTransEntity> selectBankAutoTransList(BankAutoTransSearch dom);
}
