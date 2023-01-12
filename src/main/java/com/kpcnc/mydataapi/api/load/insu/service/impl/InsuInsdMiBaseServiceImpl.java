package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdMiBaseSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdMiBaseEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdMiBaseForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuInsdMiBaseMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuInsdMiBaseService;
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
public class InsuInsdMiBaseServiceImpl implements InsuInsdMiBaseService {
    @Autowired
    InsuInsdMiBaseMapper insuInsdMiBaseMapper;

    @Override
    public InsuInsdMiBaseEntity regInsuInsdMiBase(InsuInsdMiBaseForm dom) {
        insuInsdMiBaseMapper.insertInsuInsdMiBase(dom.getEntity());
        return insuInsdMiBaseMapper.selectInsuInsdMiBase(new InsuInsdMiBaseSearch(dom));
    }

    @Override
    public InsuInsdMiBaseEntity modInsuInsdMiBase(InsuInsdMiBaseForm dom) {
        insuInsdMiBaseMapper.updateInsuInsdMiBase(dom.getEntity());
        return insuInsdMiBaseMapper.selectInsuInsdMiBase(new InsuInsdMiBaseSearch(dom));
    }

    @Override
    public void delInsuInsdMiBase(InsuInsdMiBaseForm dom) {
        insuInsdMiBaseMapper.deleteInsuInsdMiBase(dom.getEntity());
        return;
    }

    @Override
    public InsuInsdMiBaseEntity getInsuInsdMiBase(InsuInsdMiBaseSearch dom) {
        return insuInsdMiBaseMapper.selectInsuInsdMiBase(dom);
    }

    @Override
    public ResultListDto<InsuInsdMiBaseEntity> getInsuInsdMiBaseList(InsuInsdMiBaseSearch dom) {
        ResultListDto<InsuInsdMiBaseEntity> result = new ResultListDto<>();
        Long totalCnt = insuInsdMiBaseMapper.selectInsuInsdMiBaseListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuInsdMiBaseEntity> list = insuInsdMiBaseMapper.selectInsuInsdMiBaseList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
