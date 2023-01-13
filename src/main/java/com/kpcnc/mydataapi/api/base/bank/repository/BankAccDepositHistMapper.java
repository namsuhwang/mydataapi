package com.kpcnc.mydataapi.api.base.bank.repository;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccDepositHistSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccDepositHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAccDepositHistMapper{
    int insertBankAccDepositHist(BankAccDepositHistEntity dom);

    int updateBankAccDepositHist(BankAccDepositHistEntity dom);

    int deleteBankAccDepositHist(BankAccDepositHistEntity dom);

    BankAccDepositHistEntity selectBankAccDepositHist(BankAccDepositHistSearch dom);

    Long selectBankAccDepositHistListTotalCnt(BankAccDepositHistSearch dom);

    List<BankAccDepositHistEntity> selectBankAccDepositHistList(BankAccDepositHistSearch dom);
}
