package com.abcc.mydataapi.api.base.bank.repository;

import com.abcc.mydataapi.api.base.bank.models.BankAccLoanHistIntSearch;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccLoanHistIntEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAccLoanHistIntMapper{
    int insertBankAccLoanHistInt(BankAccLoanHistIntEntity dom);

    int updateBankAccLoanHistInt(BankAccLoanHistIntEntity dom);

    int deleteBankAccLoanHistInt(BankAccLoanHistIntEntity dom);

    BankAccLoanHistIntEntity selectBankAccLoanHistInt(BankAccLoanHistIntSearch dom);

    Long selectBankAccLoanHistIntListTotalCnt(BankAccLoanHistIntSearch dom);

    List<BankAccLoanHistIntEntity> selectBankAccLoanHistIntList(BankAccLoanHistIntSearch dom);
}
