package com.abcc.mydataapi.api.base.bank.service.impl;

import com.abcc.mydataapi.api.base.bank.models.BankAccSearch;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccForm;
import com.abcc.mydataapi.api.base.bank.repository.BankAccMapper;
import com.abcc.mydataapi.api.base.bank.service.BankAccService;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccEntity;
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
public class BankAccServiceImpl implements BankAccService {
    @Autowired
    BankAccMapper bankAccMapper;

    @Override
    public void regBankAcc(BankAccForm dom) {
        bankAccMapper.insertBankAcc(dom.getEntity());
        return;
    }

    @Override
    public void updBankAcc(BankAccForm dom) {
        bankAccMapper.updateBankAcc(dom.getEntity());
        return;
    }

    @Override
    public void modBankAcc(BankAccForm dom) {
        if(getBankAcc(new BankAccSearch(dom)) == null){
            regBankAcc(dom);
        }else{
            updBankAcc(dom);
        }
        return;
    }

    @Override
    public void delBankAcc(BankAccForm dom) {
        bankAccMapper.deleteBankAcc(dom.getEntity());
        return;
    }

    @Override
    public void allDelBankAcc(BankAccForm dom) {
        bankAccMapper.deleteAllBankAcc(dom.getEntity());
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
