package com.albee.mydataapi.api.base.bank.repository;

import com.albee.mydataapi.api.base.bank.models.BankAccEachProdSearch;
import com.albee.mydataapi.api.base.bank.models.entity.BankAccEachProdEntity;
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
