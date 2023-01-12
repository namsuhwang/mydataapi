package com.kpcnc.mydataapi.api.load.bank.service.impl;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccDepositAddSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccDepositAddEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccDepositAddForm;
import com.kpcnc.mydataapi.api.load.bank.repository.BankAccDepositAddMapper;
import com.kpcnc.mydataapi.api.load.bank.service.BankAccDepositAddService;
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
public class BankAccDepositAddServiceImpl implements BankAccDepositAddService {
    @Autowired
    BankAccDepositAddMapper bankAccDepositAddMapper;

    @Override
    public BankAccDepositAddEntity regBankAccDepositAdd(BankAccDepositAddForm dom) {
        bankAccDepositAddMapper.insertBankAccDepositAdd(dom.getEntity());
        return bankAccDepositAddMapper.selectBankAccDepositAdd(new BankAccDepositAddSearch(dom));
    }

    @Override
    public BankAccDepositAddEntity modBankAccDepositAdd(BankAccDepositAddForm dom) {
        bankAccDepositAddMapper.updateBankAccDepositAdd(dom.getEntity());
        return bankAccDepositAddMapper.selectBankAccDepositAdd(new BankAccDepositAddSearch(dom));
    }

    @Override
    public void delBankAccDepositAdd(BankAccDepositAddForm dom) {
        bankAccDepositAddMapper.deleteBankAccDepositAdd(dom.getEntity());
        return;
    }

    @Override
    public BankAccDepositAddEntity getBankAccDepositAdd(BankAccDepositAddSearch dom) {
        return bankAccDepositAddMapper.selectBankAccDepositAdd(dom);
    }

    @Override
    public ResultListDto<BankAccDepositAddEntity> getBankAccDepositAddList(BankAccDepositAddSearch dom) {
        ResultListDto<BankAccDepositAddEntity> result = new ResultListDto<>();
        Long totalCnt = bankAccDepositAddMapper.selectBankAccDepositAddListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BankAccDepositAddEntity> list = bankAccDepositAddMapper.selectBankAccDepositAddList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
