package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdMiSccontSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdMiSccontEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdMiSccontForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuInsdMiSccontMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuInsdMiSccontService;
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
public class InsuInsdMiSccontServiceImpl implements InsuInsdMiSccontService {
    @Autowired
    InsuInsdMiSccontMapper insuInsdMiSccontMapper;

    @Override
    public InsuInsdMiSccontEntity regInsuInsdMiSccont(InsuInsdMiSccontForm dom) {
        insuInsdMiSccontMapper.insertInsuInsdMiSccont(dom.getEntity());
        return insuInsdMiSccontMapper.selectInsuInsdMiSccont(new InsuInsdMiSccontSearch(dom));
    }

    @Override
    public InsuInsdMiSccontEntity modInsuInsdMiSccont(InsuInsdMiSccontForm dom) {
        insuInsdMiSccontMapper.updateInsuInsdMiSccont(dom.getEntity());
        return insuInsdMiSccontMapper.selectInsuInsdMiSccont(new InsuInsdMiSccontSearch(dom));
    }

    @Override
    public void delInsuInsdMiSccont(InsuInsdMiSccontForm dom) {
        insuInsdMiSccontMapper.deleteInsuInsdMiSccont(dom.getEntity());
        return;
    }

    @Override
    public InsuInsdMiSccontEntity getInsuInsdMiSccont(InsuInsdMiSccontSearch dom) {
        return insuInsdMiSccontMapper.selectInsuInsdMiSccont(dom);
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
