package com.albee.mydataapi.api.base.insu.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuMiSccontSearch;
import com.albee.mydataapi.api.base.insu.models.entity.InsuMiSccontEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuMiSccontForm;
import com.albee.mydataapi.api.base.insu.repository.InsuMiSccontMapper;
import com.albee.mydataapi.api.base.insu.service.InsuMiSccontService;
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
public class InsuMiSccontServiceImpl implements InsuMiSccontService {
    @Autowired
    InsuMiSccontMapper insuMiSccontMapper;

    @Override
    public void regInsuMiSccont(InsuMiSccontForm dom) {
        insuMiSccontMapper.insertInsuMiSccont(dom.getEntity());
    }

    @Override
    public void updInsuMiSccont(InsuMiSccontForm dom) {
        insuMiSccontMapper.updateInsuMiSccont(dom.getEntity());
    }

    @Override
    public void modInsuMiSccont(InsuMiSccontForm dom) {
        if(getInsuMiSccont(new InsuMiSccontSearch(dom)) == null){
            regInsuMiSccont(dom);
        }else{
            updInsuMiSccont(dom);
        }
    }

    @Override
    public void delInsuMiSccont(InsuMiSccontForm dom) {
        insuMiSccontMapper.deleteInsuMiSccont(dom.getEntity());
        return;
    }

    @Override
    public void allDelInsuMiSccont(InsuMiSccontForm dom) {
        insuMiSccontMapper.deleteAllInsuMiSccont(dom.getEntity());
        return;
    }

    @Override
    public InsuMiSccontEntity getInsuMiSccont(InsuMiSccontSearch dom) {
        return insuMiSccontMapper.selectInsuMiSccont(dom);
    }

    @Override
    public InsuMiSccontEntity getInsuMiSccontLast(InsuMiSccontSearch dom) {
        return insuMiSccontMapper.selectInsuMiSccontLast(dom);
    }

    @Override
    public ResultListDto<InsuMiSccontEntity> getInsuMiSccontList(InsuMiSccontSearch dom) {
        ResultListDto<InsuMiSccontEntity> result = new ResultListDto<>();
        Long totalCnt = insuMiSccontMapper.selectInsuMiSccontListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuMiSccontEntity> list = insuMiSccontMapper.selectInsuMiSccontList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
