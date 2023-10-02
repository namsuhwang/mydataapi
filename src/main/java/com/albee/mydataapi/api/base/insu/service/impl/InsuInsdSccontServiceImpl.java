package com.albee.mydataapi.api.base.insu.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuInsdSccontSearch;
import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdSccontEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuInsdSccontForm;
import com.albee.mydataapi.api.base.insu.repository.InsuInsdSccontMapper;
import com.albee.mydataapi.api.base.insu.service.InsuInsdSccontService;
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
    public void regInsuInsdSccont(InsuInsdSccontForm dom) {
        insuInsdSccontMapper.insertInsuInsdSccont(dom.getEntity());
    }

    @Override
    public void updInsuInsdSccont(InsuInsdSccontForm dom) {
        insuInsdSccontMapper.updateInsuInsdSccont(dom.getEntity());
    }

    @Override
    public void modInsuInsdSccont(InsuInsdSccontForm dom) {
        if(getInsuInsdSccont(new InsuInsdSccontSearch(dom)) == null){
            regInsuInsdSccont(dom);
        }else{
            updInsuInsdSccont(dom);
        }
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
    public InsuInsdSccontEntity getInsuInsdSccontLast(InsuInsdSccontSearch dom) {
        return insuInsdSccontMapper.selectInsuInsdSccontLast(dom);
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
