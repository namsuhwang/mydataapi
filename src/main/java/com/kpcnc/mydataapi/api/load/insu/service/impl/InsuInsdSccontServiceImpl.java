package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdSccontSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdSccontEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdSccontForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuInsdSccontMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuInsdSccontService;
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
public class InsuInsdSccontServiceImpl implements InsuInsdSccontService {
    @Autowired
    InsuInsdSccontMapper insuInsdSccontMapper;

    @Override
    public InsuInsdSccontEntity regInsuInsdSccont(InsuInsdSccontForm dom) {
        insuInsdSccontMapper.insertInsuInsdSccont(dom.getEntity());
        return insuInsdSccontMapper.selectInsuInsdSccont(new InsuInsdSccontSearch(dom));
    }

    @Override
    public InsuInsdSccontEntity modInsuInsdSccont(InsuInsdSccontForm dom) {
        insuInsdSccontMapper.updateInsuInsdSccont(dom.getEntity());
        return insuInsdSccontMapper.selectInsuInsdSccont(new InsuInsdSccontSearch(dom));
    }

    @Override
    public void delInsuInsdSccont(InsuInsdSccontForm dom) {
        insuInsdSccontMapper.deleteInsuInsdSccont(dom.getEntity());
        return;
    }

    @Override
    public InsuInsdSccontEntity getInsuInsdSccont(InsuInsdSccontSearch dom) {
        return insuInsdSccontMapper.selectInsuInsdSccont(dom);
    }

    @Override
    public ResultListDto<InsuInsdSccontEntity> getInsuInsdSccontList(InsuInsdSccontSearch dom) {
        ResultListDto<InsuInsdSccontEntity> result = new ResultListDto<>();
        Long totalCnt = insuInsdSccontMapper.selectInsuInsdSccontListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuInsdSccontEntity> list = insuInsdSccontMapper.selectInsuInsdSccontList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
