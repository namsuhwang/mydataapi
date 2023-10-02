package com.albee.mydataapi.api.base.insu.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuLoanSearch;
import com.albee.mydataapi.api.base.insu.models.entity.InsuLoanEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuLoanForm;
import com.albee.mydataapi.api.base.insu.repository.InsuLoanMapper;
import com.albee.mydataapi.api.base.insu.service.InsuLoanService;
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
    public void regInsuLoan(InsuLoanForm dom) {
        insuLoanMapper.insertInsuLoan(dom.getEntity());
    }

    @Override
    public void updInsuLoan(InsuLoanForm dom) {
        insuLoanMapper.updateInsuLoan(dom.getEntity());
    }

    @Override
    public void modInsuLoan(InsuLoanForm dom) {
        if(getInsuLoan(new InsuLoanSearch(dom)) == null){
            regInsuLoan(dom);
        }else{
            updInsuLoan(dom);
        }
    }


    @Override
    public void delInsuLoan(InsuLoanForm dom) {
        insuLoanMapper.deleteInsuLoan(dom.getEntity());
    }

    @Override
    public void allDelInsuLoan(InsuLoanForm dom) {
        insuLoanMapper.deleteAllInsuLoan(dom.getEntity());
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
