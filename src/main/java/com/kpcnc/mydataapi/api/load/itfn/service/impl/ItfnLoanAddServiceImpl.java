package com.kpcnc.mydataapi.api.load.itfn.service.impl;

import com.kpcnc.mydataapi.api.load.itfn.models.ItfnLoanAddSearch;
import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnLoanAddEntity;
import com.kpcnc.mydataapi.api.load.itfn.models.form.ItfnLoanAddForm;
import com.kpcnc.mydataapi.api.load.itfn.repository.ItfnLoanAddMapper;
import com.kpcnc.mydataapi.api.load.itfn.service.ItfnLoanAddService;
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
public class ItfnLoanAddServiceImpl implements ItfnLoanAddService {
    @Autowired
    ItfnLoanAddMapper itfnLoanAddMapper;

    @Override
    public ItfnLoanAddEntity regItfnLoanAdd(ItfnLoanAddForm dom) {
        itfnLoanAddMapper.insertItfnLoanAdd(dom.getEntity());
        return itfnLoanAddMapper.selectItfnLoanAdd(new ItfnLoanAddSearch(dom));
    }

    @Override
    public ItfnLoanAddEntity modItfnLoanAdd(ItfnLoanAddForm dom) {
        itfnLoanAddMapper.updateItfnLoanAdd(dom.getEntity());
        return itfnLoanAddMapper.selectItfnLoanAdd(new ItfnLoanAddSearch(dom));
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
