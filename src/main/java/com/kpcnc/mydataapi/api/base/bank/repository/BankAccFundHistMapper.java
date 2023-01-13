package com.kpcnc.mydataapi.api.base.bank.repository;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccFundHistSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccFundHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAccFundHistMapper{
    int insertBankAccFundHist(BankAccFundHistEntity dom);

    int updateBankAccFundHist(BankAccFundHistEntity dom);

    int deleteBankAccFundHist(BankAccFundHistEntity dom);

    BankAccFundHistEntity selectBankAccFundHist(BankAccFundHistSearch dom);

    Long selectBankAccFundHistListTotalCnt(BankAccFundHistSearch dom);

    List<BankAccFundHistEntity> selectBankAccFundHistList(BankAccFundHistSearch dom);
}
