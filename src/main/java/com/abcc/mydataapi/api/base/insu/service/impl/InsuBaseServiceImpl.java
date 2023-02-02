package com.abcc.mydataapi.api.base.insu.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuBaseSearch;
import com.abcc.mydataapi.api.base.insu.models.entity.InsuBaseEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuBaseForm;
import com.abcc.mydataapi.api.base.insu.repository.InsuBaseMapper;
import com.abcc.mydataapi.api.base.insu.service.InsuBaseService;
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
    public void regInsuBase(InsuBaseForm dom) {
        insuBaseMapper.insertInsuBase(dom.getEntity());
        return;
    }

    @Override
    public void updInsuBase(InsuBaseForm dom) {
        insuBaseMapper.updateInsuBase(dom.getEntity());
        return;
    }

    @Override
    public void modInsuBase(InsuBaseForm dom) {
        if(getInsuBase(new InsuBaseSearch(dom)) == null){
            regInsuBase(dom);
        }else{
            updInsuBase(dom);
        }
        return;
    }

    @Override
    public void delInsuBase(InsuBaseForm dom) {
        insuBaseMapper.deleteInsuBase(dom.getEntity());
        return;
    }


    @Override
    public void allDelInsuBase(InsuBaseForm dom) {
        insuBaseMapper.deleteAllInsuBase(dom.getEntity());
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
