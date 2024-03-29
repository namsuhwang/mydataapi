package com.albee.mydataapi.api.base.bank.service.impl;

import com.albee.mydataapi.api.base.bank.models.BankAccLoanHistSearch;
import com.albee.mydataapi.api.base.bank.models.form.BankAccLoanHistForm;
import com.albee.mydataapi.api.base.bank.repository.BankAccLoanHistMapper;
import com.albee.mydataapi.api.base.bank.service.BankAccLoanHistService;
import com.albee.mydataapi.api.base.bank.models.entity.BankAccLoanHistEntity;
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
public class BankAccLoanHistServiceImpl implements BankAccLoanHistService {
    @Autowired
    BankAccLoanHistMapper bankAccLoanHistMapper;

    @Override
    public BankAccLoanHistEntity regBankAccLoanHist(BankAccLoanHistForm dom) {
        bankAccLoanHistMapper.insertBankAccLoanHist(dom.getEntity());
        return bankAccLoanHistMapper.selectBankAccLoanHist(new BankAccLoanHistSearch(dom));
    }

    @Override
    public BankAccLoanHistEntity modBankAccLoanHist(BankAccLoanHistForm dom) {
        bankAccLoanHistMapper.updateBankAccLoanHist(dom.getEntity());
        return bankAccLoanHistMapper.selectBankAccLoanHist(new BankAccLoanHistSearch(dom));
    }

    @Override
    public void delBankAccLoanHist(BankAccLoanHistForm dom) {
        bankAccLoanHistMapper.deleteBankAccLoanHist(dom.getEntity());
        return;
    }

    @Override
    public BankAccLoanHistEntity getBankAccLoanHist(BankAccLoanHistSearch dom) {
        return bankAccLoanHistMapper.selectBankAccLoanHist(dom);
    }

    @Override
    public BankAccLoanHistEntity getBankAccLoanHistLast(BankAccLoanHistSearch dom) {
        return bankAccLoanHistMapper.selectBankAccLoanHistLast(dom);
    }

    @Override
    public ResultListDto<BankAccLoanHistEntity> getBankAccLoanHistList(BankAccLoanHistSearch dom) {
        ResultListDto<BankAccLoanHistEntity> result = new ResultListDto<>();
        Long totalCnt = bankAccLoanHistMapper.selectBankAccLoanHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BankAccLoanHistEntity> list = bankAccLoanHistMapper.selectBankAccLoanHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
