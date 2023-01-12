package com.kpcnc.mydataapi.api.load.bank.service.impl;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccLoanHistSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccLoanHistEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccLoanHistForm;
import com.kpcnc.mydataapi.api.load.bank.repository.BankAccLoanHistMapper;
import com.kpcnc.mydataapi.api.load.bank.service.BankAccLoanHistService;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;
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
