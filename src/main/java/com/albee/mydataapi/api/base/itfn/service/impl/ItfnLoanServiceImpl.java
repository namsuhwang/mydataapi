package com.albee.mydataapi.api.base.itfn.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.itfn.models.ItfnLoanSearch;
import com.albee.mydataapi.api.base.itfn.models.entity.ItfnLoanEntity;
import com.albee.mydataapi.api.base.itfn.models.form.ItfnLoanForm;
import com.albee.mydataapi.api.base.itfn.repository.ItfnLoanMapper;
import com.albee.mydataapi.api.base.itfn.service.ItfnLoanService;
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
public class ItfnLoanServiceImpl implements ItfnLoanService {
    @Autowired
    ItfnLoanMapper itfnLoanMapper;

    @Override
    public void regItfnLoan(ItfnLoanForm dom) {
        itfnLoanMapper.insertItfnLoan(dom.getEntity());
    }

    @Override
    public void updItfnLoan(ItfnLoanForm dom) {
        itfnLoanMapper.updateItfnLoan(dom.getEntity());
    }

    @Override
    public void modItfnLoan(ItfnLoanForm dom) {
        if(getItfnLoan(new ItfnLoanSearch(dom)) == null){
            regItfnLoan(dom);
        }else{
            updItfnLoan(dom);
        }
    }

    @Override
    public void delItfnLoan(ItfnLoanForm dom) {
        itfnLoanMapper.deleteItfnLoan(dom.getEntity());
        return;
    }

    @Override
    public ItfnLoanEntity getItfnLoan(ItfnLoanSearch dom) {
        return itfnLoanMapper.selectItfnLoan(dom);
    }

    @Override
    public ResultListDto<ItfnLoanEntity> getItfnLoanList(ItfnLoanSearch dom) {
        ResultListDto<ItfnLoanEntity> result = new ResultListDto<>();
        Long totalCnt = itfnLoanMapper.selectItfnLoanListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<ItfnLoanEntity> list = itfnLoanMapper.selectItfnLoanList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
