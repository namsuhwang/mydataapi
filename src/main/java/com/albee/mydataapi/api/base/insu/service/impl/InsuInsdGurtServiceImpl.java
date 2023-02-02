package com.albee.mydataapi.api.base.insu.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuInsdGurtSearch;
import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdGurtEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuInsdGurtForm;
import com.albee.mydataapi.api.base.insu.repository.InsuInsdGurtMapper;
import com.albee.mydataapi.api.base.insu.service.InsuInsdGurtService;
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
public class InsuInsdGurtServiceImpl implements InsuInsdGurtService {
    @Autowired
    InsuInsdGurtMapper insuInsdGurtMapper;

    @Override
    public void regInsuInsdGurt(InsuInsdGurtForm dom) {
        insuInsdGurtMapper.insertInsuInsdGurt(dom.getEntity());
    }

    @Override
    public void updInsuInsdGurt(InsuInsdGurtForm dom) {
        insuInsdGurtMapper.updateInsuInsdGurt(dom.getEntity());
    }

    @Override
    public void modInsuInsdGurt(InsuInsdGurtForm dom) {
        if(getInsuInsdGurt(new InsuInsdGurtSearch(dom)) == null){
            regInsuInsdGurt(dom);
        }else{
            updInsuInsdGurt(dom);
        }
    }

    @Override
    public void delInsuInsdGurt(InsuInsdGurtForm dom) {
        insuInsdGurtMapper.deleteInsuInsdGurt(dom.getEntity());
        return;
    }

    @Override
    public void allDelInsuInsdGurt(InsuInsdGurtForm dom) {
        insuInsdGurtMapper.deleteAllInsuInsdGurt(dom.getEntity());
    }

    @Override
    public InsuInsdGurtEntity getInsuInsdGurt(InsuInsdGurtSearch dom) {
        return insuInsdGurtMapper.selectInsuInsdGurt(dom);
    }

    @Override
    public InsuInsdGurtEntity getInsuInsdGurtLast(InsuInsdGurtSearch dom) {
        return insuInsdGurtMapper.selectInsuInsdGurtLast(dom);
    }

    @Override
    public ResultListDto<InsuInsdGurtEntity> getInsuInsdGurtList(InsuInsdGurtSearch dom) {
        ResultListDto<InsuInsdGurtEntity> result = new ResultListDto<>();
        Long totalCnt = insuInsdGurtMapper.selectInsuInsdGurtListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuInsdGurtEntity> list = insuInsdGurtMapper.selectInsuInsdGurtList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
