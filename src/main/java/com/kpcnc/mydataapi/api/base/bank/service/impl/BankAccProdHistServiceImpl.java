package com.kpcnc.mydataapi.api.base.bank.service.impl;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccProdHistSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccProdHistEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccProdHistForm;
import com.kpcnc.mydataapi.api.base.bank.repository.BankAccProdHistMapper;
import com.kpcnc.mydataapi.api.base.bank.service.BankAccProdHistService;
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
public class BankAccProdHistServiceImpl implements BankAccProdHistService {
    @Autowired
    BankAccProdHistMapper bankAccProdHistMapper;

    @Override
    public BankAccProdHistEntity regBankAccProdHist(BankAccProdHistForm dom) {
        bankAccProdHistMapper.insertBankAccProdHist(dom.getEntity());
        return bankAccProdHistMapper.selectBankAccProdHist(new BankAccProdHistSearch(dom));
    }

    @Override
    public BankAccProdHistEntity modBankAccProdHist(BankAccProdHistForm dom) {
        bankAccProdHistMapper.updateBankAccProdHist(dom.getEntity());
        return bankAccProdHistMapper.selectBankAccProdHist(new BankAccProdHistSearch(dom));
    }

    @Override
    public void delBankAccProdHist(BankAccProdHistForm dom) {
        bankAccProdHistMapper.deleteBankAccProdHist(dom.getEntity());
        return;
    }

    @Override
    public BankAccProdHistEntity getBankAccProdHist(BankAccProdHistSearch dom) {
        return bankAccProdHistMapper.selectBankAccProdHist(dom);
    }

    @Override
    public ResultListDto<BankAccProdHistEntity> getBankAccProdHistList(BankAccProdHistSearch dom) {
        ResultListDto<BankAccProdHistEntity> result = new ResultListDto<>();
        Long totalCnt = bankAccProdHistMapper.selectBankAccProdHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BankAccProdHistEntity> list = bankAccProdHistMapper.selectBankAccProdHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
