package com.kpcnc.mydataapi.api.base.insu.service.impl;

import com.kpcnc.mydataapi.api.base.insu.models.InsuBaseInsdSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuBaseInsdEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuBaseInsdForm;
import com.kpcnc.mydataapi.api.base.insu.repository.InsuBaseInsdMapper;
import com.kpcnc.mydataapi.api.base.insu.service.InsuBaseInsdService;
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
public class InsuBaseInsdServiceImpl implements InsuBaseInsdService {
    @Autowired
    InsuBaseInsdMapper insuBaseInsdMapper;

    @Override
    public InsuBaseInsdEntity regInsuBaseInsd(InsuBaseInsdForm dom) {
        insuBaseInsdMapper.insertInsuBaseInsd(dom.getEntity());
        return insuBaseInsdMapper.selectInsuBaseInsd(new InsuBaseInsdSearch(dom));
    }

    @Override
    public InsuBaseInsdEntity modInsuBaseInsd(InsuBaseInsdForm dom) {
        insuBaseInsdMapper.updateInsuBaseInsd(dom.getEntity());
        return insuBaseInsdMapper.selectInsuBaseInsd(new InsuBaseInsdSearch(dom));
    }

    @Override
    public void delInsuBaseInsd(InsuBaseInsdForm dom) {
        insuBaseInsdMapper.deleteInsuBaseInsd(dom.getEntity());
        return;
    }

    @Override
    public InsuBaseInsdEntity getInsuBaseInsd(InsuBaseInsdSearch dom) {
        return insuBaseInsdMapper.selectInsuBaseInsd(dom);
    }

    @Override
    public ResultListDto<InsuBaseInsdEntity> getInsuBaseInsdList(InsuBaseInsdSearch dom) {
        ResultListDto<InsuBaseInsdEntity> result = new ResultListDto<>();
        Long totalCnt = insuBaseInsdMapper.selectInsuBaseInsdListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuBaseInsdEntity> list = insuBaseInsdMapper.selectInsuBaseInsdList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
