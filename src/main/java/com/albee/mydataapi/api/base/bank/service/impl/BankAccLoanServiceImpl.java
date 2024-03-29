package com.albee.mydataapi.api.base.bank.service.impl;

import com.albee.mydataapi.api.base.bank.models.BankAccLoanSearch;
import com.albee.mydataapi.api.base.bank.repository.BankAccLoanMapper;
import com.albee.mydataapi.api.base.bank.service.BankAccLoanService;
import com.albee.mydataapi.api.base.bank.models.entity.BankAccLoanEntity;
import com.albee.mydataapi.api.base.bank.models.form.BankAccLoanForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class BankAccLoanServiceImpl implements BankAccLoanService {
    @Autowired
    BankAccLoanMapper bankAccLoanMapper;

    @Override
    public BankAccLoanEntity regBankAccLoan(BankAccLoanForm dom) {
        bankAccLoanMapper.insertBankAccLoan(dom.getEntity());
        return bankAccLoanMapper.selectBankAccLoan(new BankAccLoanSearch(dom));
    }

    @Override
    public BankAccLoanEntity modBankAccLoan(BankAccLoanForm dom) {
        bankAccLoanMapper.updateBankAccLoan(dom.getEntity());
        return bankAccLoanMapper.selectBankAccLoan(new BankAccLoanSearch(dom));
    }

    @Override
    public void delBankAccLoan(BankAccLoanForm dom) {
        bankAccLoanMapper.deleteBankAccLoan(dom.getEntity());
        return;
    }

    @Override
    public BankAccLoanEntity getBankAccLoan(BankAccLoanSearch dom) {
        return bankAccLoanMapper.selectBankAccLoan(dom);
    }

    @Override
    public ResultListDto<BankAccLoanEntity> getBankAccLoanList(BankAccLoanSearch dom) {
        ResultListDto<BankAccLoanEntity> result = new ResultListDto<>();
        Long totalCnt = bankAccLoanMapper.selectBankAccLoanListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BankAccLoanEntity> list = bankAccLoanMapper.selectBankAccLoanList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
