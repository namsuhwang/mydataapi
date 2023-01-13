package com.kpcnc.mydataapi.api.base.bank.repository;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccProdSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccProdEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAccProdMapper{
    int insertBankAccProd(BankAccProdEntity dom);

    int updateBankAccProd(BankAccProdEntity dom);

    int deleteBankAccProd(BankAccProdEntity dom);

    BankAccProdEntity selectBankAccProd(BankAccProdSearch dom);

    Long selectBankAccProdListTotalCnt(BankAccProdSearch dom);

    List<BankAccProdEntity> selectBankAccProdList(BankAccProdSearch dom);
}