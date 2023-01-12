package com.kpcnc.mydataapi.api.load.bank.service.impl;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccForm;
import com.kpcnc.mydataapi.api.load.bank.repository.BankAccMapper;
import com.kpcnc.mydataapi.api.load.bank.service.BankAccService;
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
public class BankAccServiceImpl implements BankAccService {
    @Autowired
    BankAccMapper bankAccMapper;

    @Override
    public BankAccEntity regBankAcc(BankAccForm dom) {
        bankAccMapper.insertBankAcc(dom.getEntity());
        return bankAccMapper.selectBankAcc(new BankAccSearch(dom));
    }

    @Override
    public BankAccEntity modBankAcc(BankAccForm dom) {
        bankAccMapper.updateBankAcc(dom.getEntity());
        return bankAccMapper.selectBankAcc(new BankAccSearch(dom));
    }

    @Override
    public void delBankAcc(BankAccForm dom) {
        bankAccMapper.deleteBankAcc(dom.getEntity());
        return;
    }

    @Override
    public BankAccEntity getBankAcc(BankAccSearch dom) {
        return bankAccMapper.selectBankAcc(dom);
    }

    @Override
    public ResultListDto<BankAccEntity> getBankAccList(BankAccSearch dom) {
        ResultListDto<BankAccEntity> result = new ResultListDto<>();
        Long totalCnt = bankAccMapper.selectBankAccListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BankAccEntity> list = bankAccMapper.selectBankAccList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
