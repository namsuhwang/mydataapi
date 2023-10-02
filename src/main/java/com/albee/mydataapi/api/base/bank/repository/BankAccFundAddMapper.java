package com.albee.mydataapi.api.base.bank.repository;

import com.albee.mydataapi.api.base.bank.models.BankAccFundAddSearch;
import com.albee.mydataapi.api.base.bank.models.entity.BankAccFundAddEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAccFundAddMapper{
    int insertBankAccFundAdd(BankAccFundAddEntity dom);

    int updateBankAccFundAdd(BankAccFundAddEntity dom);

    int deleteBankAccFundAdd(BankAccFundAddEntity dom);

    BankAccFundAddEntity selectBankAccFundAdd(BankAccFundAddSearch dom);

    Long selectBankAccFundAddListTotalCnt(BankAccFundAddSearch dom);

    List<BankAccFundAddEntity> selectBankAccFundAddList(BankAccFundAddSearch dom);
}
