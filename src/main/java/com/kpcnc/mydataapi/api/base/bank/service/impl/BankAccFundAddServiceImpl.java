package com.kpcnc.mydataapi.api.base.bank.service.impl;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccFundAddSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccFundAddEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccFundAddForm;
import com.kpcnc.mydataapi.api.base.bank.repository.BankAccFundAddMapper;
import com.kpcnc.mydataapi.api.base.bank.service.BankAccFundAddService;
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
public class BankAccFundAddServiceImpl implements BankAccFundAddService {
    @Autowired
    BankAccFundAddMapper bankAccFundAddMapper;

    @Override
    public BankAccFundAddEntity regBankAccFundAdd(BankAccFundAddForm dom) {
        bankAccFundAddMapper.insertBankAccFundAdd(dom.getEntity());
        return bankAccFundAddMapper.selectBankAccFundAdd(new BankAccFundAddSearch(dom));
    }

    @Override
    public BankAccFundAddEntity modBankAccFundAdd(BankAccFundAddForm dom) {
        bankAccFundAddMapper.updateBankAccFundAdd(dom.getEntity());
        return bankAccFundAddMapper.selectBankAccFundAdd(new BankAccFundAddSearch(dom));
    }

    @Override
    public void delBankAccFundAdd(BankAccFundAddForm dom) {
        bankAccFundAddMapper.deleteBankAccFundAdd(dom.getEntity());
        return;
    }

    @Override
    public BankAccFundAddEntity getBankAccFundAdd(BankAccFundAddSearch dom) {
        return bankAccFundAddMapper.selectBankAccFundAdd(dom);
    }

    @Override
    public ResultListDto<BankAccFundAddEntity> getBankAccFundAddList(BankAccFundAddSearch dom) {
        ResultListDto<BankAccFundAddEntity> result = new ResultListDto<>();
        Long totalCnt = bankAccFundAddMapper.selectBankAccFundAddListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BankAccFundAddEntity> list = bankAccFundAddMapper.selectBankAccFundAddList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
