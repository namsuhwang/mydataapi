package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdGurtSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdGurtEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdGurtForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuInsdGurtMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuInsdGurtService;
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
public class InsuInsdGurtServiceImpl implements InsuInsdGurtService {
    @Autowired
    InsuInsdGurtMapper insuInsdGurtMapper;

    @Override
    public InsuInsdGurtEntity regInsuInsdGurt(InsuInsdGurtForm dom) {
        insuInsdGurtMapper.insertInsuInsdGurt(dom.getEntity());
        return insuInsdGurtMapper.selectInsuInsdGurt(new InsuInsdGurtSearch(dom));
    }

    @Override
    public InsuInsdGurtEntity modInsuInsdGurt(InsuInsdGurtForm dom) {
        insuInsdGurtMapper.updateInsuInsdGurt(dom.getEntity());
        return insuInsdGurtMapper.selectInsuInsdGurt(new InsuInsdGurtSearch(dom));
    }

    @Override
    public void delInsuInsdGurt(InsuInsdGurtForm dom) {
        insuInsdGurtMapper.deleteInsuInsdGurt(dom.getEntity());
        return;
    }

    @Override
    public InsuInsdGurtEntity getInsuInsdGurt(InsuInsdGurtSearch dom) {
        return insuInsdGurtMapper.selectInsuInsdGurt(dom);
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
