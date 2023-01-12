package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.load.insu.models.InsuMiBaseSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuMiBaseEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuMiBaseForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuMiBaseMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuMiBaseService;
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
public class InsuMiBaseServiceImpl implements InsuMiBaseService {
    @Autowired
    InsuMiBaseMapper insuMiBaseMapper;

    @Override
    public InsuMiBaseEntity regInsuMiBase(InsuMiBaseForm dom) {
        insuMiBaseMapper.insertInsuMiBase(dom.getEntity());
        return insuMiBaseMapper.selectInsuMiBase(new InsuMiBaseSearch(dom));
    }

    @Override
    public InsuMiBaseEntity modInsuMiBase(InsuMiBaseForm dom) {
        insuMiBaseMapper.updateInsuMiBase(dom.getEntity());
        return insuMiBaseMapper.selectInsuMiBase(new InsuMiBaseSearch(dom));
    }

    @Override
    public void delInsuMiBase(InsuMiBaseForm dom) {
        insuMiBaseMapper.deleteInsuMiBase(dom.getEntity());
        return;
    }

    @Override
    public InsuMiBaseEntity getInsuMiBase(InsuMiBaseSearch dom) {
        return insuMiBaseMapper.selectInsuMiBase(dom);
    }

    @Override
    public ResultListDto<InsuMiBaseEntity> getInsuMiBaseList(InsuMiBaseSearch dom) {
        ResultListDto<InsuMiBaseEntity> result = new ResultListDto<>();
        Long totalCnt = insuMiBaseMapper.selectInsuMiBaseListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuMiBaseEntity> list = insuMiBaseMapper.selectInsuMiBaseList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
