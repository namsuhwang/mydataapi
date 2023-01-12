package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.load.insu.models.InsuGurtSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuGurtEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuGurtForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuGurtMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuGurtService;
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
    public InsuGurtEntity regInsuGurt(InsuGurtForm dom) {
        insuGurtMapper.insertInsuGurt(dom.getEntity());
        return insuGurtMapper.selectInsuGurt(new InsuGurtSearch(dom));
    }

    @Override
    public InsuGurtEntity modInsuGurt(InsuGurtForm dom) {
        insuGurtMapper.updateInsuGurt(dom.getEntity());
        return insuGurtMapper.selectInsuGurt(new InsuGurtSearch(dom));
    }

    @Override
    public void delInsuGurt(InsuGurtForm dom) {
        insuGurtMapper.deleteInsuGurt(dom.getEntity());
        return;
    }

    @Override
    public InsuGurtEntity getInsuGurt(InsuGurtSearch dom) {
        return insuGurtMapper.selectInsuGurt(dom);
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
