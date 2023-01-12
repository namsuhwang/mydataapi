package com.kpcnc.mydataapi.api.load.bank.repository;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccLoanAddSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccLoanAddEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAccLoanAddMapper{
    int insertBankAccLoanAdd(BankAccLoanAddEntity dom);

    int updateBankAccLoanAdd(BankAccLoanAddEntity dom);

    int deleteBankAccLoanAdd(BankAccLoanAddEntity dom);

    BankAccLoanAddEntity selectBankAccLoanAdd(BankAccLoanAddSearch dom);

    Long selectBankAccLoanAddListTotalCnt(BankAccLoanAddSearch dom);

    List<BankAccLoanAddEntity> selectBankAccLoanAddList(BankAccLoanAddSearch dom);
}
