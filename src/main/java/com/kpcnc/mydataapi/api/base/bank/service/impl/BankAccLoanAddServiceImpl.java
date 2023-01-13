package com.kpcnc.mydataapi.api.base.bank.service.impl;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccLoanAddSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccLoanAddEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccLoanAddForm;
import com.kpcnc.mydataapi.api.base.bank.repository.BankAccLoanAddMapper;
import com.kpcnc.mydataapi.api.base.bank.service.BankAccLoanAddService;
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
public class BankAccLoanAddServiceImpl implements BankAccLoanAddService {
    @Autowired
    BankAccLoanAddMapper bankAccLoanAddMapper;

    @Override
    public BankAccLoanAddEntity regBankAccLoanAdd(BankAccLoanAddForm dom) {
        bankAccLoanAddMapper.insertBankAccLoanAdd(dom.getEntity());
        return bankAccLoanAddMapper.selectBankAccLoanAdd(new BankAccLoanAddSearch(dom));
    }

    @Override
    public BankAccLoanAddEntity modBankAccLoanAdd(BankAccLoanAddForm dom) {
        bankAccLoanAddMapper.updateBankAccLoanAdd(dom.getEntity());
        return bankAccLoanAddMapper.selectBankAccLoanAdd(new BankAccLoanAddSearch(dom));
    }

    @Override
    public void delBankAccLoanAdd(BankAccLoanAddForm dom) {
        bankAccLoanAddMapper.deleteBankAccLoanAdd(dom.getEntity());
        return;
    }

    @Override
    public BankAccLoanAddEntity getBankAccLoanAdd(BankAccLoanAddSearch dom) {
        return bankAccLoanAddMapper.selectBankAccLoanAdd(dom);
    }

    @Override
    public ResultListDto<BankAccLoanAddEntity> getBankAccLoanAddList(BankAccLoanAddSearch dom) {
        ResultListDto<BankAccLoanAddEntity> result = new ResultListDto<>();
        Long totalCnt = bankAccLoanAddMapper.selectBankAccLoanAddListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BankAccLoanAddEntity> list = bankAccLoanAddMapper.selectBankAccLoanAddList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
