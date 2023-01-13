package com.kpcnc.mydataapi.api.base.insu.service.impl;

import com.kpcnc.mydataapi.api.base.insu.models.InsuLoanBaseSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuLoanBaseEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuLoanBaseForm;
import com.kpcnc.mydataapi.api.base.insu.repository.InsuLoanBaseMapper;
import com.kpcnc.mydataapi.api.base.insu.service.InsuLoanBaseService;
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
public class InsuLoanBaseServiceImpl implements InsuLoanBaseService {
    @Autowired
    InsuLoanBaseMapper insuLoanBaseMapper;

    @Override
    public InsuLoanBaseEntity regInsuLoanBase(InsuLoanBaseForm dom) {
        insuLoanBaseMapper.insertInsuLoanBase(dom.getEntity());
        return insuLoanBaseMapper.selectInsuLoanBase(new InsuLoanBaseSearch(dom));
    }

    @Override
    public InsuLoanBaseEntity modInsuLoanBase(InsuLoanBaseForm dom) {
        insuLoanBaseMapper.updateInsuLoanBase(dom.getEntity());
        return insuLoanBaseMapper.selectInsuLoanBase(new InsuLoanBaseSearch(dom));
    }

    @Override
    public void delInsuLoanBase(InsuLoanBaseForm dom) {
        insuLoanBaseMapper.deleteInsuLoanBase(dom.getEntity());
        return;
    }

    @Override
    public InsuLoanBaseEntity getInsuLoanBase(InsuLoanBaseSearch dom) {
        return insuLoanBaseMapper.selectInsuLoanBase(dom);
    }

    @Override
    public ResultListDto<InsuLoanBaseEntity> getInsuLoanBaseList(InsuLoanBaseSearch dom) {
        ResultListDto<InsuLoanBaseEntity> result = new ResultListDto<>();
        Long totalCnt = insuLoanBaseMapper.selectInsuLoanBaseListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuLoanBaseEntity> list = insuLoanBaseMapper.selectInsuLoanBaseList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
