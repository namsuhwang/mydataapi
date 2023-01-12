package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.load.insu.models.InsuPaySearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuPayEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuPayForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuPayMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuPayService;
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
public class InsuPayServiceImpl implements InsuPayService {
    @Autowired
    InsuPayMapper insuPayMapper;

    @Override
    public InsuPayEntity regInsuPay(InsuPayForm dom) {
        insuPayMapper.insertInsuPay(dom.getEntity());
        return insuPayMapper.selectInsuPay(new InsuPaySearch(dom));
    }

    @Override
    public InsuPayEntity modInsuPay(InsuPayForm dom) {
        insuPayMapper.updateInsuPay(dom.getEntity());
        return insuPayMapper.selectInsuPay(new InsuPaySearch(dom));
    }

    @Override
    public void delInsuPay(InsuPayForm dom) {
        insuPayMapper.deleteInsuPay(dom.getEntity());
        return;
    }

    @Override
    public InsuPayEntity getInsuPay(InsuPaySearch dom) {
        return insuPayMapper.selectInsuPay(dom);
    }

    @Override
    public ResultListDto<InsuPayEntity> getInsuPayList(InsuPaySearch dom) {
        ResultListDto<InsuPayEntity> result = new ResultListDto<>();
        Long totalCnt = insuPayMapper.selectInsuPayListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuPayEntity> list = insuPayMapper.selectInsuPayList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
