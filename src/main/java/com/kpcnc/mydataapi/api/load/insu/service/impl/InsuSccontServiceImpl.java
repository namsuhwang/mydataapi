package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.load.insu.models.InsuSccontSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuSccontEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuSccontForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuSccontMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuSccontService;
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
public class InsuSccontServiceImpl implements InsuSccontService {
    @Autowired
    InsuSccontMapper insuSccontMapper;

    @Override
    public InsuSccontEntity regInsuSccont(InsuSccontForm dom) {
        insuSccontMapper.insertInsuSccont(dom.getEntity());
        return insuSccontMapper.selectInsuSccont(new InsuSccontSearch(dom));
    }

    @Override
    public InsuSccontEntity modInsuSccont(InsuSccontForm dom) {
        insuSccontMapper.updateInsuSccont(dom.getEntity());
        return insuSccontMapper.selectInsuSccont(new InsuSccontSearch(dom));
    }

    @Override
    public void delInsuSccont(InsuSccontForm dom) {
        insuSccontMapper.deleteInsuSccont(dom.getEntity());
        return;
    }

    @Override
    public InsuSccontEntity getInsuSccont(InsuSccontSearch dom) {
        return insuSccontMapper.selectInsuSccont(dom);
    }

    @Override
    public ResultListDto<InsuSccontEntity> getInsuSccontList(InsuSccontSearch dom) {
        ResultListDto<InsuSccontEntity> result = new ResultListDto<>();
        Long totalCnt = insuSccontMapper.selectInsuSccontListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuSccontEntity> list = insuSccontMapper.selectInsuSccontList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
