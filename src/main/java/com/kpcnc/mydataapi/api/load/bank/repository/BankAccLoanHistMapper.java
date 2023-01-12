package com.kpcnc.mydataapi.api.load.bank.repository;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccLoanHistSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccLoanHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAccLoanHistMapper{
    int insertBankAccLoanHist(BankAccLoanHistEntity dom);

    int updateBankAccLoanHist(BankAccLoanHistEntity dom);

    int deleteBankAccLoanHist(BankAccLoanHistEntity dom);

    BankAccLoanHistEntity selectBankAccLoanHist(BankAccLoanHistSearch dom);

    Long selectBankAccLoanHistListTotalCnt(BankAccLoanHistSearch dom);

    List<BankAccLoanHistEntity> selectBankAccLoanHistList(BankAccLoanHistSearch dom);
}
