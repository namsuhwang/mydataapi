package com.kpcnc.mydataapi.api.base.bank.service.impl;

import com.kpcnc.mydataapi.api.base.bank.models.BankAutoTransSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAutoTransEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAutoTransForm;
import com.kpcnc.mydataapi.api.base.bank.repository.BankAutoTransMapper;
import com.kpcnc.mydataapi.api.base.bank.service.BankAutoTransService;
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
public class BankAutoTransServiceImpl implements BankAutoTransService {
    @Autowired
    BankAutoTransMapper bankAutoTransMapper;

    @Override
    public BankAutoTransEntity regBankAutoTrans(BankAutoTransForm dom) {
        bankAutoTransMapper.insertBankAutoTrans(dom.getEntity());
        return bankAutoTransMapper.selectBankAutoTrans(new BankAutoTransSearch(dom));
    }

    @Override
    public BankAutoTransEntity modBankAutoTrans(BankAutoTransForm dom) {
        bankAutoTransMapper.updateBankAutoTrans(dom.getEntity());
        return bankAutoTransMapper.selectBankAutoTrans(new BankAutoTransSearch(dom));
    }

    @Override
    public void delBankAutoTrans(BankAutoTransForm dom) {
        bankAutoTransMapper.deleteBankAutoTrans(dom.getEntity());
        return;
    }

    @Override
    public BankAutoTransEntity getBankAutoTrans(BankAutoTransSearch dom) {
        return bankAutoTransMapper.selectBankAutoTrans(dom);
    }

    @Override
    public ResultListDto<BankAutoTransEntity> getBankAutoTransList(BankAutoTransSearch dom) {
        ResultListDto<BankAutoTransEntity> result = new ResultListDto<>();
        Long totalCnt = bankAutoTransMapper.selectBankAutoTransListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BankAutoTransEntity> list = bankAutoTransMapper.selectBankAutoTransList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}