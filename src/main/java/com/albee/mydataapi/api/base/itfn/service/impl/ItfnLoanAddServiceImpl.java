package com.albee.mydataapi.api.base.itfn.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.itfn.models.ItfnLoanAddSearch;
import com.albee.mydataapi.api.base.itfn.models.entity.ItfnLoanAddEntity;
import com.albee.mydataapi.api.base.itfn.models.form.ItfnLoanAddForm;
import com.albee.mydataapi.api.base.itfn.repository.ItfnLoanAddMapper;
import com.albee.mydataapi.api.base.itfn.service.ItfnLoanAddService;
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
public class ItfnLoanAddServiceImpl implements ItfnLoanAddService {
    @Autowired
    ItfnLoanAddMapper itfnLoanAddMapper;

    @Override
    public void regItfnLoanAdd(ItfnLoanAddForm dom) {
        itfnLoanAddMapper.insertItfnLoanAdd(dom.getEntity());
    }

    @Override
    public void updItfnLoanAdd(ItfnLoanAddForm dom) {
        itfnLoanAddMapper.updateItfnLoanAdd(dom.getEntity());
    }

    @Override
    public void modItfnLoanAdd(ItfnLoanAddForm dom) {
        if(getItfnLoanAdd(new ItfnLoanAddSearch(dom)) == null){
            regItfnLoanAdd(dom);
        }else{
            updItfnLoanAdd(dom);
        }
    }

    @Override
    public void delItfnLoanAdd(ItfnLoanAddForm dom) {
        itfnLoanAddMapper.deleteItfnLoanAdd(dom.getEntity());
        return;
    }

    @Override
    public ItfnLoanAddEntity getItfnLoanAdd(ItfnLoanAddSearch dom) {
        return itfnLoanAddMapper.selectItfnLoanAdd(dom);
    }

    @Override
    public ResultListDto<ItfnLoanAddEntity> getItfnLoanAddList(ItfnLoanAddSearch dom) {
        ResultListDto<ItfnLoanAddEntity> result = new ResultListDto<>();
        Long totalCnt = itfnLoanAddMapper.selectItfnLoanAddListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<ItfnLoanAddEntity> list = itfnLoanAddMapper.selectItfnLoanAddList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
