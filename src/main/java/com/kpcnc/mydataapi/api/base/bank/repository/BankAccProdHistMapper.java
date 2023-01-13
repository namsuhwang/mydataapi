package com.kpcnc.mydataapi.api.base.bank.repository;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccProdHistSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccProdHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAccProdHistMapper{
    int insertBankAccProdHist(BankAccProdHistEntity dom);

    int updateBankAccProdHist(BankAccProdHistEntity dom);

    int deleteBankAccProdHist(BankAccProdHistEntity dom);

    BankAccProdHistEntity selectBankAccProdHist(BankAccProdHistSearch dom);

    Long selectBankAccProdHistListTotalCnt(BankAccProdHistSearch dom);

    List<BankAccProdHistEntity> selectBankAccProdHistList(BankAccProdHistSearch dom);
}
