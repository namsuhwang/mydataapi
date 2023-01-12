package com.kpcnc.mydataapi.api.load.bank.service.impl;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccProdSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccProdEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccProdForm;
import com.kpcnc.mydataapi.api.load.bank.repository.BankAccProdMapper;
import com.kpcnc.mydataapi.api.load.bank.service.BankAccProdService;
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
public class BankAccProdServiceImpl implements BankAccProdService {
    @Autowired
    BankAccProdMapper bankAccProdMapper;

    @Override
    public BankAccProdEntity regBankAccProd(BankAccProdForm dom) {
        bankAccProdMapper.insertBankAccProd(dom.getEntity());
        return bankAccProdMapper.selectBankAccProd(new BankAccProdSearch(dom));
    }

    @Override
    public BankAccProdEntity modBankAccProd(BankAccProdForm dom) {
        bankAccProdMapper.updateBankAccProd(dom.getEntity());
        return bankAccProdMapper.selectBankAccProd(new BankAccProdSearch(dom));
    }

    @Override
    public void delBankAccProd(BankAccProdForm dom) {
        bankAccProdMapper.deleteBankAccProd(dom.getEntity());
        return;
    }

    @Override
    public BankAccProdEntity getBankAccProd(BankAccProdSearch dom) {
        return bankAccProdMapper.selectBankAccProd(dom);
    }

    @Override
    public ResultListDto<BankAccProdEntity> getBankAccProdList(BankAccProdSearch dom) {
        ResultListDto<BankAccProdEntity> result = new ResultListDto<>();
        Long totalCnt = bankAccProdMapper.selectBankAccProdListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BankAccProdEntity> list = bankAccProdMapper.selectBankAccProdList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
