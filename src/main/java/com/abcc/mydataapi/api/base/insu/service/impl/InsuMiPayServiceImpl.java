package com.abcc.mydataapi.api.base.insu.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuMiPaySearch;
import com.abcc.mydataapi.api.base.insu.models.entity.InsuMiPayEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuMiPayForm;
import com.abcc.mydataapi.api.base.insu.repository.InsuMiPayMapper;
import com.abcc.mydataapi.api.base.insu.service.InsuMiPayService;
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
public class InsuMiPayServiceImpl implements InsuMiPayService {
    @Autowired
    InsuMiPayMapper insuMiPayMapper;

    @Override
    public InsuMiPayEntity regInsuMiPay(InsuMiPayForm dom) {
        insuMiPayMapper.insertInsuMiPay(dom.getEntity());
        return insuMiPayMapper.selectInsuMiPay(new InsuMiPaySearch(dom));
    }

    @Override
    public InsuMiPayEntity modInsuMiPay(InsuMiPayForm dom) {
        insuMiPayMapper.updateInsuMiPay(dom.getEntity());
        return insuMiPayMapper.selectInsuMiPay(new InsuMiPaySearch(dom));
    }

    @Override
    public void delInsuMiPay(InsuMiPayForm dom) {
        insuMiPayMapper.deleteInsuMiPay(dom.getEntity());
        return;
    }

    @Override
    public InsuMiPayEntity getInsuMiPay(InsuMiPaySearch dom) {
        return insuMiPayMapper.selectInsuMiPay(dom);
    }

    @Override
    public ResultListDto<InsuMiPayEntity> getInsuMiPayList(InsuMiPaySearch dom) {
        ResultListDto<InsuMiPayEntity> result = new ResultListDto<>();
        Long totalCnt = insuMiPayMapper.selectInsuMiPayListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuMiPayEntity> list = insuMiPayMapper.selectInsuMiPayList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
