package com.kpcnc.mydataapi.api.load.bank.repository;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccDepositSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccDepositEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAccDepositMapper{
    int insertBankAccDeposit(BankAccDepositEntity dom);

    int updateBankAccDeposit(BankAccDepositEntity dom);

    int deleteBankAccDeposit(BankAccDepositEntity dom);

    BankAccDepositEntity selectBankAccDeposit(BankAccDepositSearch dom);

    Long selectBankAccDepositListTotalCnt(BankAccDepositSearch dom);

    List<BankAccDepositEntity> selectBankAccDepositList(BankAccDepositSearch dom);
}
