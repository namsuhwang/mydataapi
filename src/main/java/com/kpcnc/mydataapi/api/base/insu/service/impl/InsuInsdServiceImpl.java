package com.kpcnc.mydataapi.api.base.insu.service.impl;

import com.kpcnc.mydataapi.api.base.insu.models.InsuInsdSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuInsdForm;
import com.kpcnc.mydataapi.api.base.insu.repository.InsuInsdMapper;
import com.kpcnc.mydataapi.api.base.insu.service.InsuInsdService;
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
public class InsuInsdServiceImpl implements InsuInsdService {
    @Autowired
    InsuInsdMapper insuInsdMapper;

    @Override
    public InsuInsdEntity regInsuInsd(InsuInsdForm dom) {
        insuInsdMapper.insertInsuInsd(dom.getEntity());
        return insuInsdMapper.selectInsuInsd(new InsuInsdSearch(dom));
    }

    @Override
    public InsuInsdEntity modInsuInsd(InsuInsdForm dom) {
        insuInsdMapper.updateInsuInsd(dom.getEntity());
        return insuInsdMapper.selectInsuInsd(new InsuInsdSearch(dom));
    }

    @Override
    public void delInsuInsd(InsuInsdForm dom) {
        insuInsdMapper.deleteInsuInsd(dom.getEntity());
        return;
    }

    @Override
    public InsuInsdEntity getInsuInsd(InsuInsdSearch dom) {
        return insuInsdMapper.selectInsuInsd(dom);
    }

    @Override
    public ResultListDto<InsuInsdEntity> getInsuInsdList(InsuInsdSearch dom) {
        ResultListDto<InsuInsdEntity> result = new ResultListDto<>();
        Long totalCnt = insuInsdMapper.selectInsuInsdListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuInsdEntity> list = insuInsdMapper.selectInsuInsdList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
