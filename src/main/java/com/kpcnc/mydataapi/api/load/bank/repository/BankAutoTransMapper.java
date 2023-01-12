package com.kpcnc.mydataapi.api.load.bank.repository;

import com.kpcnc.mydataapi.api.load.bank.models.BankAutoTransSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAutoTransEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAutoTransMapper{
    int insertBankAutoTrans(BankAutoTransEntity dom);

    int updateBankAutoTrans(BankAutoTransEntity dom);

    int deleteBankAutoTrans(BankAutoTransEntity dom);

    BankAutoTransEntity selectBankAutoTrans(BankAutoTransSearch dom);

    Long selectBankAutoTransListTotalCnt(BankAutoTransSearch dom);

    List<BankAutoTransEntity> selectBankAutoTransList(BankAutoTransSearch dom);
}
