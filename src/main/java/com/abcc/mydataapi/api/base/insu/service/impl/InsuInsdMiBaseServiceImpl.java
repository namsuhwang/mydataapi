package com.abcc.mydataapi.api.base.insu.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuInsdMiBaseSearch;
import com.abcc.mydataapi.api.base.insu.models.entity.InsuInsdMiBaseEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuInsdMiBaseForm;
import com.abcc.mydataapi.api.base.insu.repository.InsuInsdMiBaseMapper;
import com.abcc.mydataapi.api.base.insu.service.InsuInsdMiBaseService;
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
    public void regInsuInsdMiBase(InsuInsdMiBaseForm dom) {
        insuInsdMiBaseMapper.insertInsuInsdMiBase(dom.getEntity());
    }

    @Override
    public void updInsuInsdMiBase(InsuInsdMiBaseForm dom) {
        insuInsdMiBaseMapper.updateInsuInsdMiBase(dom.getEntity());
    }

    @Override
    public void modInsuInsdMiBase(InsuInsdMiBaseForm dom) {
        if(getInsuInsdMiBase(new InsuInsdMiBaseSearch(dom)) == null){
            regInsuInsdMiBase(dom);
        }else{
            updInsuInsdMiBase(dom);
        }
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
