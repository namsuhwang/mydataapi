package com.kpcnc.mydataapi.api.base.bank.service.impl;

import com.kpcnc.mydataapi.api.base.bank.models.BankCustSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankCustEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankCustForm;
import com.kpcnc.mydataapi.api.base.bank.repository.BankCustMapper;
import com.kpcnc.mydataapi.api.base.bank.service.BankCustService;
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
public class BankCustServiceImpl implements BankCustService {
    @Autowired
    BankCustMapper bankCustMapper;

    @Override
    public void regBankCust(BankCustForm dom) {
        bankCustMapper.insertBankCust(dom.getEntity());
        return;
    }

    @Override
    public void updBankCust(BankCustForm dom) {
        bankCustMapper.updateBankCust(dom.getEntity());
        return;
    }


    @Override
    public void modBankCust(BankCustForm dom) {
        if(getBankCust(new BankCustSearch(dom)) == null){
            regBankCust(dom);
        }else{
            updBankCust(dom);
        }

        return;
    }



    @Override
    public void delBankCust(BankCustForm dom) {
        bankCustMapper.deleteBankCust(dom.getEntity());
        return;
    }

    @Override
    public BankCustEntity getBankCust(BankCustSearch dom) {
        return bankCustMapper.selectBankCust(dom);
    }

    @Override
    public ResultListDto<BankCustEntity> getBankCustList(BankCustSearch dom) {
        ResultListDto<BankCustEntity> result = new ResultListDto<>();
        Long totalCnt = bankCustMapper.selectBankCustListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BankCustEntity> list = bankCustMapper.selectBankCustList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
