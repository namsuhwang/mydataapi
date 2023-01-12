package com.kpcnc.mydataapi.api.load.bank.service.impl;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccFundHistSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccFundHistEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccFundHistForm;
import com.kpcnc.mydataapi.api.load.bank.repository.BankAccFundHistMapper;
import com.kpcnc.mydataapi.api.load.bank.service.BankAccFundHistService;
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
public class BankAccFundHistServiceImpl implements BankAccFundHistService {
    @Autowired
    BankAccFundHistMapper bankAccFundHistMapper;

    @Override
    public BankAccFundHistEntity regBankAccFundHist(BankAccFundHistForm dom) {
        bankAccFundHistMapper.insertBankAccFundHist(dom.getEntity());
        return bankAccFundHistMapper.selectBankAccFundHist(new BankAccFundHistSearch(dom));
    }

    @Override
    public BankAccFundHistEntity modBankAccFundHist(BankAccFundHistForm dom) {
        bankAccFundHistMapper.updateBankAccFundHist(dom.getEntity());
        return bankAccFundHistMapper.selectBankAccFundHist(new BankAccFundHistSearch(dom));
    }

    @Override
    public void delBankAccFundHist(BankAccFundHistForm dom) {
        bankAccFundHistMapper.deleteBankAccFundHist(dom.getEntity());
        return;
    }

    @Override
    public BankAccFundHistEntity getBankAccFundHist(BankAccFundHistSearch dom) {
        return bankAccFundHistMapper.selectBankAccFundHist(dom);
    }

    @Override
    public ResultListDto<BankAccFundHistEntity> getBankAccFundHistList(BankAccFundHistSearch dom) {
        ResultListDto<BankAccFundHistEntity> result = new ResultListDto<>();
        Long totalCnt = bankAccFundHistMapper.selectBankAccFundHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BankAccFundHistEntity> list = bankAccFundHistMapper.selectBankAccFundHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
