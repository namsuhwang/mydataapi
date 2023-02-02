package com.abcc.mydataapi.api.base.insu.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuInsdBaseSearch;
import com.abcc.mydataapi.api.base.insu.models.entity.InsuInsdBaseEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuInsdBaseForm;
import com.abcc.mydataapi.api.base.insu.repository.InsuInsdBaseMapper;
import com.abcc.mydataapi.api.base.insu.service.InsuInsdBaseService;
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
public class InsuInsdBaseServiceImpl implements InsuInsdBaseService {
    @Autowired
    InsuInsdBaseMapper insuInsdBaseMapper;

    @Override
    public InsuInsdBaseEntity regInsuInsdBase(InsuInsdBaseForm dom) {
        insuInsdBaseMapper.insertInsuInsdBase(dom.getEntity());
        return insuInsdBaseMapper.selectInsuInsdBase(new InsuInsdBaseSearch(dom));
    }

    @Override
    public InsuInsdBaseEntity modInsuInsdBase(InsuInsdBaseForm dom) {
        insuInsdBaseMapper.updateInsuInsdBase(dom.getEntity());
        return insuInsdBaseMapper.selectInsuInsdBase(new InsuInsdBaseSearch(dom));
    }

    @Override
    public void delInsuInsdBase(InsuInsdBaseForm dom) {
        insuInsdBaseMapper.deleteInsuInsdBase(dom.getEntity());
        return;
    }

    @Override
    public InsuInsdBaseEntity getInsuInsdBase(InsuInsdBaseSearch dom) {
        return insuInsdBaseMapper.selectInsuInsdBase(dom);
    }

    @Override
    public ResultListDto<InsuInsdBaseEntity> getInsuInsdBaseList(InsuInsdBaseSearch dom) {
        ResultListDto<InsuInsdBaseEntity> result = new ResultListDto<>();
        Long totalCnt = insuInsdBaseMapper.selectInsuInsdBaseListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuInsdBaseEntity> list = insuInsdBaseMapper.selectInsuInsdBaseList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
