package com.kpcnc.mydataapi.api.base.bank.repository;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccLoanSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccLoanEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAccLoanMapper{
    int insertBankAccLoan(BankAccLoanEntity dom);

    int updateBankAccLoan(BankAccLoanEntity dom);

    int deleteBankAccLoan(BankAccLoanEntity dom);

    BankAccLoanEntity selectBankAccLoan(BankAccLoanSearch dom);

    Long selectBankAccLoanListTotalCnt(BankAccLoanSearch dom);

    List<BankAccLoanEntity> selectBankAccLoanList(BankAccLoanSearch dom);
}
