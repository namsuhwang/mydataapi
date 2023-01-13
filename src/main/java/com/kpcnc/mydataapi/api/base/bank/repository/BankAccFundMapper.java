package com.kpcnc.mydataapi.api.base.bank.repository;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccFundSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccFundEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAccFundMapper{
    int insertBankAccFund(BankAccFundEntity dom);

    int updateBankAccFund(BankAccFundEntity dom);

    int deleteBankAccFund(BankAccFundEntity dom);

    BankAccFundEntity selectBankAccFund(BankAccFundSearch dom);

    Long selectBankAccFundListTotalCnt(BankAccFundSearch dom);

    List<BankAccFundEntity> selectBankAccFundList(BankAccFundSearch dom);
}
