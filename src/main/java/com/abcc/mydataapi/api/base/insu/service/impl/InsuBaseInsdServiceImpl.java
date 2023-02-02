package com.abcc.mydataapi.api.base.insu.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuBaseInsdSearch;
import com.abcc.mydataapi.api.base.insu.models.entity.InsuBaseInsdEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuBaseInsdForm;
import com.abcc.mydataapi.api.base.insu.repository.InsuBaseInsdMapper;
import com.abcc.mydataapi.api.base.insu.service.InsuBaseInsdService;
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
    public void regInsuBaseInsd(InsuBaseInsdForm dom) {
        insuBaseInsdMapper.insertInsuBaseInsd(dom.getEntity());
    }

    @Override
    public void updInsuBaseInsd(InsuBaseInsdForm dom) {
        insuBaseInsdMapper.updateInsuBaseInsd(dom.getEntity());
    }

    @Override
    public void modInsuBaseInsd(InsuBaseInsdForm dom) {
        if(getInsuBaseInsd(new InsuBaseInsdSearch(dom)) == null){
            regInsuBaseInsd(dom);
        }else{
            updInsuBaseInsd(dom);
        }
    }

    @Override
    public void delInsuBaseInsd(InsuBaseInsdForm dom) {
        insuBaseInsdMapper.deleteInsuBaseInsd(dom.getEntity());
        return;
    }

    @Override
    public void allDelInsuBaseInsd(InsuBaseInsdForm dom) {
        insuBaseInsdMapper.deleteAllInsuBaseInsd(dom.getEntity());
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
