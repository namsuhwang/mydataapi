package com.abcc.mydataapi.api.base.bank.service.impl;

import com.abcc.mydataapi.api.base.bank.models.BankAccDepositHistSearch;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccDepositHistForm;
import com.abcc.mydataapi.api.base.bank.repository.BankAccDepositHistMapper;
import com.abcc.mydataapi.api.base.bank.service.BankAccDepositHistService;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccDepositHistEntity;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
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
public class BankAccDepositHistServiceImpl implements BankAccDepositHistService {
    @Autowired
    BankAccDepositHistMapper bankAccDepositHistMapper;

    @Override
    public BankAccDepositHistEntity regBankAccDepositHist(BankAccDepositHistForm dom) {
        bankAccDepositHistMapper.insertBankAccDepositHist(dom.getEntity());
        return bankAccDepositHistMapper.selectBankAccDepositHist(new BankAccDepositHistSearch(dom));
    }

    @Override
    public BankAccDepositHistEntity modBankAccDepositHist(BankAccDepositHistForm dom) {
        bankAccDepositHistMapper.updateBankAccDepositHist(dom.getEntity());
        return bankAccDepositHistMapper.selectBankAccDepositHist(new BankAccDepositHistSearch(dom));
    }

    @Override
    public void delBankAccDepositHist(BankAccDepositHistForm dom) {
        bankAccDepositHistMapper.deleteBankAccDepositHist(dom.getEntity());
        return;
    }

    @Override
    public BankAccDepositHistEntity getBankAccDepositHist(BankAccDepositHistSearch dom) {
        return bankAccDepositHistMapper.selectBankAccDepositHist(dom);
    }

    @Override
    public BankAccDepositHistEntity getBankAccDepositHistLast(BankAccDepositHistSearch dom) {
        return bankAccDepositHistMapper.selectBankAccDepositHistMax(dom);
    }

    @Override
    public ResultListDto<BankAccDepositHistEntity> getBankAccDepositHistList(BankAccDepositHistSearch dom) {
        ResultListDto<BankAccDepositHistEntity> result = new ResultListDto<>();
        Long totalCnt = bankAccDepositHistMapper.selectBankAccDepositHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BankAccDepositHistEntity> list = bankAccDepositHistMapper.selectBankAccDepositHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
