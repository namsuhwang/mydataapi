package com.kpcnc.mydataapi.api.base.insu.service.impl;

import com.kpcnc.mydataapi.api.base.insu.models.InsuGurtSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuGurtEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuGurtForm;
import com.kpcnc.mydataapi.api.base.insu.repository.InsuGurtMapper;
import com.kpcnc.mydataapi.api.base.insu.service.InsuGurtService;
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
public class InsuGurtServiceImpl implements InsuGurtService {
    @Autowired
    InsuGurtMapper insuGurtMapper;

    @Override
    public void regInsuGurt(InsuGurtForm dom) {
        insuGurtMapper.insertInsuGurt(dom.getEntity());
    }

    @Override
    public void updInsuGurt(InsuGurtForm dom) {
        insuGurtMapper.updateInsuGurt(dom.getEntity());
    }

    @Override
    public void modInsuGurt(InsuGurtForm dom) {
        if(getInsuGurt(new InsuGurtSearch(dom)) == null){
            regInsuGurt(dom);
        }else{
            updInsuGurt(dom);
        }
    }

    @Override
    public void delInsuGurt(InsuGurtForm dom) {
        insuGurtMapper.deleteInsuGurt(dom.getEntity());
        return;
    }

    @Override
    public void allDelInsuGurt(InsuGurtForm dom) {
        insuGurtMapper.deleteAllInsuGurt(dom.getEntity());
        return;
    }

    @Override
    public InsuGurtEntity getInsuGurt(InsuGurtSearch dom) {
        return insuGurtMapper.selectInsuGurt(dom);
    }


    @Override
    public InsuGurtEntity getInsuGurtLast(InsuGurtSearch dom) {
        return insuGurtMapper.selectInsuGurtLast(dom);
    }

    @Override
    public ResultListDto<InsuGurtEntity> getInsuGurtList(InsuGurtSearch dom) {
        ResultListDto<InsuGurtEntity> result = new ResultListDto<>();
        Long totalCnt = insuGurtMapper.selectInsuGurtListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuGurtEntity> list = insuGurtMapper.selectInsuGurtList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
