package com.abcc.mydataapi.api.base.bank.service.impl;

import com.abcc.mydataapi.api.base.bank.models.BankAccFundSearch;
import com.abcc.mydataapi.api.base.bank.repository.BankAccFundMapper;
import com.abcc.mydataapi.api.base.bank.service.BankAccFundService;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccFundEntity;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccFundForm;
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
public class BankAccFundServiceImpl implements BankAccFundService {
    @Autowired
    BankAccFundMapper bankAccFundMapper;

    @Override
    public BankAccFundEntity regBankAccFund(BankAccFundForm dom) {
        bankAccFundMapper.insertBankAccFund(dom.getEntity());
        return bankAccFundMapper.selectBankAccFund(new BankAccFundSearch(dom));
    }

    @Override
    public BankAccFundEntity modBankAccFund(BankAccFundForm dom) {
        bankAccFundMapper.updateBankAccFund(dom.getEntity());
        return bankAccFundMapper.selectBankAccFund(new BankAccFundSearch(dom));
    }

    @Override
    public void delBankAccFund(BankAccFundForm dom) {
        bankAccFundMapper.deleteBankAccFund(dom.getEntity());
        return;
    }

    @Override
    public BankAccFundEntity getBankAccFund(BankAccFundSearch dom) {
        return bankAccFundMapper.selectBankAccFund(dom);
    }

    @Override
    public ResultListDto<BankAccFundEntity> getBankAccFundList(BankAccFundSearch dom) {
        ResultListDto<BankAccFundEntity> result = new ResultListDto<>();
        Long totalCnt = bankAccFundMapper.selectBankAccFundListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BankAccFundEntity> list = bankAccFundMapper.selectBankAccFundList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
