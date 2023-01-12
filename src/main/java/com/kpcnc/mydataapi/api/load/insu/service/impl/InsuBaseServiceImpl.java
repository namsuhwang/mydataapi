package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.load.insu.models.InsuBaseSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuBaseEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuBaseForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuBaseMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuBaseService;
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
public class InsuBaseServiceImpl implements InsuBaseService {
    @Autowired
    InsuBaseMapper insuBaseMapper;

    @Override
    public InsuBaseEntity regInsuBase(InsuBaseForm dom) {
        insuBaseMapper.insertInsuBase(dom.getEntity());
        return insuBaseMapper.selectInsuBase(new InsuBaseSearch(dom));
    }

    @Override
    public InsuBaseEntity modInsuBase(InsuBaseForm dom) {
        insuBaseMapper.updateInsuBase(dom.getEntity());
        return insuBaseMapper.selectInsuBase(new InsuBaseSearch(dom));
    }

    @Override
    public void delInsuBase(InsuBaseForm dom) {
        insuBaseMapper.deleteInsuBase(dom.getEntity());
        return;
    }

    @Override
    public InsuBaseEntity getInsuBase(InsuBaseSearch dom) {
        return insuBaseMapper.selectInsuBase(dom);
    }

    @Override
    public ResultListDto<InsuBaseEntity> getInsuBaseList(InsuBaseSearch dom) {
        ResultListDto<InsuBaseEntity> result = new ResultListDto<>();
        Long totalCnt = insuBaseMapper.selectInsuBaseListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuBaseEntity> list = insuBaseMapper.selectInsuBaseList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
