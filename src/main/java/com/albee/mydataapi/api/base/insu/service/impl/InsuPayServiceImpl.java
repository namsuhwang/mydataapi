package com.albee.mydataapi.api.base.insu.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuPaySearch;
import com.albee.mydataapi.api.base.insu.models.entity.InsuPayEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuPayForm;
import com.albee.mydataapi.api.base.insu.repository.InsuPayMapper;
import com.albee.mydataapi.api.base.insu.service.InsuPayService;
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
    public void regInsuPay(InsuPayForm dom) {
        insuPayMapper.insertInsuPay(dom.getEntity());
    }

    @Override
    public void updInsuPay(InsuPayForm dom) {
        insuPayMapper.updateInsuPay(dom.getEntity());
    }

    @Override
    public void modInsuPay(InsuPayForm dom) {
        if(getInsuPay(new InsuPaySearch(dom)) == null){
            regInsuPay(dom);
        }else{
            updInsuPay(dom);
        }
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
