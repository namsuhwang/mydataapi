package com.kpcnc.mydataapi.api.base.insu.service.impl;

import com.kpcnc.mydataapi.api.base.insu.models.InsuMiSccontSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuMiSccontEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiSccontForm;
import com.kpcnc.mydataapi.api.base.insu.repository.InsuMiSccontMapper;
import com.kpcnc.mydataapi.api.base.insu.service.InsuMiSccontService;
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
public class InsuMiSccontServiceImpl implements InsuMiSccontService {
    @Autowired
    InsuMiSccontMapper insuMiSccontMapper;

    @Override
    public InsuMiSccontEntity regInsuMiSccont(InsuMiSccontForm dom) {
        insuMiSccontMapper.insertInsuMiSccont(dom.getEntity());
        return insuMiSccontMapper.selectInsuMiSccont(new InsuMiSccontSearch(dom));
    }

    @Override
    public InsuMiSccontEntity modInsuMiSccont(InsuMiSccontForm dom) {
        insuMiSccontMapper.updateInsuMiSccont(dom.getEntity());
        return insuMiSccontMapper.selectInsuMiSccont(new InsuMiSccontSearch(dom));
    }

    @Override
    public void delInsuMiSccont(InsuMiSccontForm dom) {
        insuMiSccontMapper.deleteInsuMiSccont(dom.getEntity());
        return;
    }

    @Override
    public InsuMiSccontEntity getInsuMiSccont(InsuMiSccontSearch dom) {
        return insuMiSccontMapper.selectInsuMiSccont(dom);
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