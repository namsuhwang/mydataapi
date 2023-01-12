package com.kpcnc.mydataapi.api.load.bank.repository;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAccMapper{
    int insertBankAcc(BankAccEntity dom);

    int updateBankAcc(BankAccEntity dom);

    int deleteBankAcc(BankAccEntity dom);

    BankAccEntity selectBankAcc(BankAccSearch dom);

    Long selectBankAccListTotalCnt(BankAccSearch dom);

    List<BankAccEntity> selectBankAccList(BankAccSearch dom);
}
