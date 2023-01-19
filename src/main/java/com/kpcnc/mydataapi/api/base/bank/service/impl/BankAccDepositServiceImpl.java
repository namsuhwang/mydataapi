package com.kpcnc.mydataapi.api.base.bank.service.impl;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccDepositSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccDepositEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccDepositForm;
import com.kpcnc.mydataapi.api.base.bank.repository.BankAccDepositMapper;
import com.kpcnc.mydataapi.api.base.bank.service.BankAccDepositService;
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
    public void regBankAccDeposit(BankAccDepositForm dom) {
        bankAccDepositMapper.insertBankAccDeposit(dom.getEntity());
        return;
    }

    @Override
    public void updBankAccDeposit(BankAccDepositForm dom) {
        bankAccDepositMapper.updateBankAccDeposit(dom.getEntity());
        return;
    }

    @Override
    public void modBankAccDeposit(BankAccDepositForm dom) {
        if(getBankAccDeposit(new BankAccDepositSearch(dom)) == null){
            regBankAccDeposit(dom);
        }else{
            updBankAccDeposit(dom);
        }
        return;
    }

    @Override
    public void delBankAccDeposit(BankAccDepositForm dom) {
        bankAccDepositMapper.deleteBankAccDeposit(dom.getEntity());
        return;
    }

    @Override
    public void delAllBankAccDeposit(BankAccDepositForm dom) {
        bankAccDepositMapper.deleteAllBankAccDeposit(dom.getEntity());
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
