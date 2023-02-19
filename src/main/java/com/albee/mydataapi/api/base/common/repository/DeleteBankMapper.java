package com.albee.mydataapi.api.base.common.repository;

import com.albee.mydataapi.api.base.common.models.dto.DeleteKeyDto;
import org.springframework.stereotype.Component;

@Component
public interface DeleteBankMapper {

    int deleteBankCust(DeleteKeyDto dom);

    int deleteBankAcc(DeleteKeyDto dom);

    int deleteBankAccDeposit(DeleteKeyDto dom);

    int deleteBankAccDepositAdd(DeleteKeyDto dom);

    int deleteBankAccDepositHist(DeleteKeyDto dom);

    int deleteBankAccEachProd(DeleteKeyDto dom);

    int deleteBankAccFundAdd(DeleteKeyDto dom);

    int deleteBankAccFundHist(DeleteKeyDto dom);

    int deleteBankAccFund(DeleteKeyDto dom);

    int deleteBankAccLoanAdd(DeleteKeyDto dom);

    int deleteBankAccLoanHistInt(DeleteKeyDto dom);

    int deleteBankAccLoanHist(DeleteKeyDto dom);

    int deleteBankAccLoan(DeleteKeyDto dom);

    int deleteBankAccProd(DeleteKeyDto dom);

    int deleteBankAccProdHist(DeleteKeyDto dom);

    int deleteBankAutoTrans(DeleteKeyDto dom);

}
