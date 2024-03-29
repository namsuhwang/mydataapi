package com.albee.mydataapi.api.base.bank.repository;

import com.albee.mydataapi.api.base.bank.models.BankAccDepositHistSearch;
import com.albee.mydataapi.api.base.bank.models.entity.BankAccDepositHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAccDepositHistMapper{
    int insertBankAccDepositHist(BankAccDepositHistEntity dom);

    int updateBankAccDepositHist(BankAccDepositHistEntity dom);

    int deleteBankAccDepositHist(BankAccDepositHistEntity dom);

    BankAccDepositHistEntity selectBankAccDepositHist(BankAccDepositHistSearch dom);

    BankAccDepositHistEntity selectBankAccDepositHistMax(BankAccDepositHistSearch dom);

    Long selectBankAccDepositHistListTotalCnt(BankAccDepositHistSearch dom);

    List<BankAccDepositHistEntity> selectBankAccDepositHistList(BankAccDepositHistSearch dom);
}
