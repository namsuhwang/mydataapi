package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdBaseSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdBaseEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdBaseForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuInsdBaseMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuInsdBaseService;
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
