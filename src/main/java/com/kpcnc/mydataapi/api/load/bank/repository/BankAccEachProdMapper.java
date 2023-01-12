package com.kpcnc.mydataapi.api.load.bank.repository;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccEachProdSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccEachProdEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAccEachProdMapper{
    int insertBankAccEachProd(BankAccEachProdEntity dom);

    int updateBankAccEachProd(BankAccEachProdEntity dom);

    int deleteBankAccEachProd(BankAccEachProdEntity dom);

    BankAccEachProdEntity selectBankAccEachProd(BankAccEachProdSearch dom);

    Long selectBankAccEachProdListTotalCnt(BankAccEachProdSearch dom);

    List<BankAccEachProdEntity> selectBankAccEachProdList(BankAccEachProdSearch dom);
}
