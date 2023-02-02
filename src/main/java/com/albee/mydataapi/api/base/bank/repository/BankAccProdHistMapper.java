package com.albee.mydataapi.api.base.bank.repository;

import com.albee.mydataapi.api.base.bank.models.BankAccProdHistSearch;
import com.albee.mydataapi.api.base.bank.models.entity.BankAccProdHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAccProdHistMapper{
    int insertBankAccProdHist(BankAccProdHistEntity dom);

    int updateBankAccProdHist(BankAccProdHistEntity dom);

    int deleteBankAccProdHist(BankAccProdHistEntity dom);

    BankAccProdHistEntity selectBankAccProdHist(BankAccProdHistSearch dom);

    BankAccProdHistEntity selectBankAccProdHistLast(BankAccProdHistSearch dom);

    Long selectBankAccProdHistListTotalCnt(BankAccProdHistSearch dom);

    List<BankAccProdHistEntity> selectBankAccProdHistList(BankAccProdHistSearch dom);
}
