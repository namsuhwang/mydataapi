package com.kpcnc.mydataapi.api.base.bank.service.impl;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccDepositAddSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccDepositAddEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccDepositAddForm;
import com.kpcnc.mydataapi.api.base.bank.repository.BankAccDepositAddMapper;
import com.kpcnc.mydataapi.api.base.bank.service.BankAccDepositAddService;
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
    public void regBankAccDepositAdd(BankAccDepositAddForm dom) {
        bankAccDepositAddMapper.insertBankAccDepositAdd(dom.getEntity());
        return;
    }

    @Override
    public void updBankAccDepositAdd(BankAccDepositAddForm dom) {
        bankAccDepositAddMapper.updateBankAccDepositAdd(dom.getEntity());
        return;
    }

    @Override
    public void modBankAccDepositAdd(BankAccDepositAddForm dom) {
        if(getBankAccDepositAdd(new BankAccDepositAddSearch(dom)) == null){
            regBankAccDepositAdd(dom);
        }else{
            updBankAccDepositAdd(dom);
        }
        return;
    }

    @Override
    public void delBankAccDepositAdd(BankAccDepositAddForm dom) {
        bankAccDepositAddMapper.deleteBankAccDepositAdd(dom.getEntity());
        return;
    }

    @Override
    public void delAllBankAccDepositAdd(BankAccDepositAddForm dom) {
        bankAccDepositAddMapper.deleteAllBankAccDepositAdd(dom.getEntity());
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
