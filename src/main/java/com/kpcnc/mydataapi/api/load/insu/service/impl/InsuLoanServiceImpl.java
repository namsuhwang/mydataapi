package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.load.insu.models.InsuLoanSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuLoanEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuLoanForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuLoanMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuLoanService;
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
public class InsuLoanServiceImpl implements InsuLoanService {
    @Autowired
    InsuLoanMapper insuLoanMapper;

    @Override
    public InsuLoanEntity regInsuLoan(InsuLoanForm dom) {
        insuLoanMapper.insertInsuLoan(dom.getEntity());
        return insuLoanMapper.selectInsuLoan(new InsuLoanSearch(dom));
    }

    @Override
    public InsuLoanEntity modInsuLoan(InsuLoanForm dom) {
        insuLoanMapper.updateInsuLoan(dom.getEntity());
        return insuLoanMapper.selectInsuLoan(new InsuLoanSearch(dom));
    }

    @Override
    public void delInsuLoan(InsuLoanForm dom) {
        insuLoanMapper.deleteInsuLoan(dom.getEntity());
        return;
    }

    @Override
    public InsuLoanEntity getInsuLoan(InsuLoanSearch dom) {
        return insuLoanMapper.selectInsuLoan(dom);
    }

    @Override
    public ResultListDto<InsuLoanEntity> getInsuLoanList(InsuLoanSearch dom) {
        ResultListDto<InsuLoanEntity> result = new ResultListDto<>();
        Long totalCnt = insuLoanMapper.selectInsuLoanListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuLoanEntity> list = insuLoanMapper.selectInsuLoanList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
