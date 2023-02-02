package com.albee.mydataapi.api.base.insu.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuInsdMiSccontSearch;
import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdMiSccontEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuInsdMiSccontForm;
import com.albee.mydataapi.api.base.insu.repository.InsuInsdMiSccontMapper;
import com.albee.mydataapi.api.base.insu.service.InsuInsdMiSccontService;
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
public class InsuInsdMiSccontServiceImpl implements InsuInsdMiSccontService {
    @Autowired
    InsuInsdMiSccontMapper insuInsdMiSccontMapper;

    @Override
    public void regInsuInsdMiSccont(InsuInsdMiSccontForm dom) {
        insuInsdMiSccontMapper.insertInsuInsdMiSccont(dom.getEntity());
    }

    @Override
    public void updInsuInsdMiSccont(InsuInsdMiSccontForm dom) {
        insuInsdMiSccontMapper.updateInsuInsdMiSccont(dom.getEntity());
    }
    @Override
    public void modInsuInsdMiSccont(InsuInsdMiSccontForm dom) {
        if(getInsuInsdMiSccont(new InsuInsdMiSccontSearch(dom)) == null){
            regInsuInsdMiSccont(dom);
        }else{
            updInsuInsdMiSccont(dom);
        }
    }

    @Override
    public void delInsuInsdMiSccont(InsuInsdMiSccontForm dom) {
        insuInsdMiSccontMapper.deleteInsuInsdMiSccont(dom.getEntity());
        return;
    }

    @Override
    public void allDelInsuInsdMiSccont(InsuInsdMiSccontForm dom) {
        insuInsdMiSccontMapper.deleteAllInsuInsdMiSccont(dom.getEntity());
        return;
    }

    @Override
    public InsuInsdMiSccontEntity getInsuInsdMiSccont(InsuInsdMiSccontSearch dom) {
        return insuInsdMiSccontMapper.selectInsuInsdMiSccont(dom);
    }

    @Override
    public InsuInsdMiSccontEntity getInsuInsdMiSccontLast(InsuInsdMiSccontSearch dom) {
        return insuInsdMiSccontMapper.selectInsuInsdMiSccontLast(dom);
    }

    @Override
    public ResultListDto<InsuInsdMiSccontEntity> getInsuInsdMiSccontList(InsuInsdMiSccontSearch dom) {
        ResultListDto<InsuInsdMiSccontEntity> result = new ResultListDto<>();
        Long totalCnt = insuInsdMiSccontMapper.selectInsuInsdMiSccontListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuInsdMiSccontEntity> list = insuInsdMiSccontMapper.selectInsuInsdMiSccontList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
