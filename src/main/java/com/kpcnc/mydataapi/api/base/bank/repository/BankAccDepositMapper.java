package com.kpcnc.mydataapi.api.base.bank.repository;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccDepositSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccDepositEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAccDepositMapper{
    int insertBankAccDeposit(BankAccDepositEntity dom);

    int updateBankAccDeposit(BankAccDepositEntity dom);

    int deleteBankAccDeposit(BankAccDepositEntity dom);

    int deleteAllBankAccDeposit(BankAccDepositEntity dom);

    BankAccDepositEntity selectBankAccDeposit(BankAccDepositSearch dom);

    Long selectBankAccDepositListTotalCnt(BankAccDepositSearch dom);

    List<BankAccDepositEntity> selectBankAccDepositList(BankAccDepositSearch dom);
}
