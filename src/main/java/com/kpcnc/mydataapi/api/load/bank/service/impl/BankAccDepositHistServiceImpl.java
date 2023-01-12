package com.kpcnc.mydataapi.api.load.bank.service.impl;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccDepositHistSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccDepositHistEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccDepositHistForm;
import com.kpcnc.mydataapi.api.load.bank.repository.BankAccDepositHistMapper;
import com.kpcnc.mydataapi.api.load.bank.service.BankAccDepositHistService;
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
