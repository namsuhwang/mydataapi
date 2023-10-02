package com.albee.mydataapi.api.base.bank.service.impl;

import com.albee.mydataapi.api.base.bank.models.BankAccEachProdSearch;
import com.albee.mydataapi.api.base.bank.repository.BankAccEachProdMapper;
import com.albee.mydataapi.api.base.bank.service.BankAccEachProdService;
import com.albee.mydataapi.api.base.bank.models.entity.BankAccEachProdEntity;
import com.albee.mydataapi.api.base.bank.models.form.BankAccEachProdForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
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
public class BankAccEachProdServiceImpl implements BankAccEachProdService {
    @Autowired
    BankAccEachProdMapper bankAccEachProdMapper;

    @Override
    public BankAccEachProdEntity regBankAccEachProd(BankAccEachProdForm dom) {
        bankAccEachProdMapper.insertBankAccEachProd(dom.getEntity());
        return bankAccEachProdMapper.selectBankAccEachProd(new BankAccEachProdSearch(dom));
    }

    @Override
    public BankAccEachProdEntity modBankAccEachProd(BankAccEachProdForm dom) {
        bankAccEachProdMapper.updateBankAccEachProd(dom.getEntity());
        return bankAccEachProdMapper.selectBankAccEachProd(new BankAccEachProdSearch(dom));
    }

    @Override
    public void delBankAccEachProd(BankAccEachProdForm dom) {
        bankAccEachProdMapper.deleteBankAccEachProd(dom.getEntity());
        return;
    }

    @Override
    public BankAccEachProdEntity getBankAccEachProd(BankAccEachProdSearch dom) {
        return bankAccEachProdMapper.selectBankAccEachProd(dom);
    }

    @Override
    public BankAccEachProdEntity getBankAccEachProdLast(BankAccEachProdSearch dom) {
        return null;
    }

    @Override
    public ResultListDto<BankAccEachProdEntity> getBankAccEachProdList(BankAccEachProdSearch dom) {
        ResultListDto<BankAccEachProdEntity> result = new ResultListDto<>();
        Long totalCnt = bankAccEachProdMapper.selectBankAccEachProdListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BankAccEachProdEntity> list = bankAccEachProdMapper.selectBankAccEachProdList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
