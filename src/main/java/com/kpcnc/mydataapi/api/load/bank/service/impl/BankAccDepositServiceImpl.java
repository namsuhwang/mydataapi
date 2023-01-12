package com.kpcnc.mydataapi.api.load.bank.service.impl;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccDepositSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccDepositEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccDepositForm;
import com.kpcnc.mydataapi.api.load.bank.repository.BankAccDepositMapper;
import com.kpcnc.mydataapi.api.load.bank.service.BankAccDepositService;
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
public class BankAccDepositServiceImpl implements BankAccDepositService {
    @Autowired
    BankAccDepositMapper bankAccDepositMapper;

    @Override
    public BankAccDepositEntity regBankAccDeposit(BankAccDepositForm dom) {
        bankAccDepositMapper.insertBankAccDeposit(dom.getEntity());
        return bankAccDepositMapper.selectBankAccDeposit(new BankAccDepositSearch(dom));
    }

    @Override
    public BankAccDepositEntity modBankAccDeposit(BankAccDepositForm dom) {
        bankAccDepositMapper.updateBankAccDeposit(dom.getEntity());
        return bankAccDepositMapper.selectBankAccDeposit(new BankAccDepositSearch(dom));
    }

    @Override
    public void delBankAccDeposit(BankAccDepositForm dom) {
        bankAccDepositMapper.deleteBankAccDeposit(dom.getEntity());
        return;
    }

    @Override
    public BankAccDepositEntity getBankAccDeposit(BankAccDepositSearch dom) {
        return bankAccDepositMapper.selectBankAccDeposit(dom);
    }

    @Override
    public ResultListDto<BankAccDepositEntity> getBankAccDepositList(BankAccDepositSearch dom) {
        ResultListDto<BankAccDepositEntity> result = new ResultListDto<>();
        Long totalCnt = bankAccDepositMapper.selectBankAccDepositListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BankAccDepositEntity> list = bankAccDepositMapper.selectBankAccDepositList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
