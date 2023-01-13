package com.kpcnc.mydataapi.api.base.bank.service.impl;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccLoanHistIntSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccLoanHistIntEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccLoanHistIntForm;
import com.kpcnc.mydataapi.api.base.bank.repository.BankAccLoanHistIntMapper;
import com.kpcnc.mydataapi.api.base.bank.service.BankAccLoanHistIntService;
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
public class BankAccLoanHistIntServiceImpl implements BankAccLoanHistIntService {
    @Autowired
    BankAccLoanHistIntMapper bankAccLoanHistIntMapper;

    @Override
    public BankAccLoanHistIntEntity regBankAccLoanHistInt(BankAccLoanHistIntForm dom) {
        bankAccLoanHistIntMapper.insertBankAccLoanHistInt(dom.getEntity());
        return bankAccLoanHistIntMapper.selectBankAccLoanHistInt(new BankAccLoanHistIntSearch(dom));
    }

    @Override
    public BankAccLoanHistIntEntity modBankAccLoanHistInt(BankAccLoanHistIntForm dom) {
        bankAccLoanHistIntMapper.updateBankAccLoanHistInt(dom.getEntity());
        return bankAccLoanHistIntMapper.selectBankAccLoanHistInt(new BankAccLoanHistIntSearch(dom));
    }

    @Override
    public void delBankAccLoanHistInt(BankAccLoanHistIntForm dom) {
        bankAccLoanHistIntMapper.deleteBankAccLoanHistInt(dom.getEntity());
        return;
    }

    @Override
    public BankAccLoanHistIntEntity getBankAccLoanHistInt(BankAccLoanHistIntSearch dom) {
        return bankAccLoanHistIntMapper.selectBankAccLoanHistInt(dom);
    }

    @Override
    public ResultListDto<BankAccLoanHistIntEntity> getBankAccLoanHistIntList(BankAccLoanHistIntSearch dom) {
        ResultListDto<BankAccLoanHistIntEntity> result = new ResultListDto<>();
        Long totalCnt = bankAccLoanHistIntMapper.selectBankAccLoanHistIntListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BankAccLoanHistIntEntity> list = bankAccLoanHistIntMapper.selectBankAccLoanHistIntList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
