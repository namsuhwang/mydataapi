package com.abcc.mydataapi.api.base.insu.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuMiBaseSearch;
import com.abcc.mydataapi.api.base.insu.models.entity.InsuMiBaseEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuMiBaseForm;
import com.abcc.mydataapi.api.base.insu.repository.InsuMiBaseMapper;
import com.abcc.mydataapi.api.base.insu.service.InsuMiBaseService;
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
    public void regInsuMiBase(InsuMiBaseForm dom) {
        insuMiBaseMapper.insertInsuMiBase(dom.getEntity());
    }

    @Override
    public void updInsuMiBase(InsuMiBaseForm dom) {
        insuMiBaseMapper.updateInsuMiBase(dom.getEntity());
    }

    @Override
    public void modInsuMiBase(InsuMiBaseForm dom) {
        if(getInsuMiBase(new InsuMiBaseSearch(dom)) == null){
            regInsuMiBase(dom);
        }else{
            updInsuMiBase(dom);
        }
    }

    @Override
    public void delInsuMiBase(InsuMiBaseForm dom) {
        insuMiBaseMapper.deleteInsuMiBase(dom.getEntity());
        return;
    }

    @Override
    public void allDelInsuMiBase(InsuMiBaseForm dom) {
        insuMiBaseMapper.deleteAllInsuMiBase(dom.getEntity());
        return;
    }

    @Override
    public InsuMiBaseEntity getInsuMiBase(InsuMiBaseSearch dom) {
        return insuMiBaseMapper.selectInsuMiBase(dom);
    }

    @Override
    public InsuMiBaseEntity getInsuMiBaseLast(InsuMiBaseSearch dom) {
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
