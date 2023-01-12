package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdMiSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdMiEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdMiForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuInsdMiMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuInsdMiService;
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
public class InsuInsdMiServiceImpl implements InsuInsdMiService {
    @Autowired
    InsuInsdMiMapper insuInsdMiMapper;

    @Override
    public InsuInsdMiEntity regInsuInsdMi(InsuInsdMiForm dom) {
        insuInsdMiMapper.insertInsuInsdMi(dom.getEntity());
        return insuInsdMiMapper.selectInsuInsdMi(new InsuInsdMiSearch(dom));
    }

    @Override
    public InsuInsdMiEntity modInsuInsdMi(InsuInsdMiForm dom) {
        insuInsdMiMapper.updateInsuInsdMi(dom.getEntity());
        return insuInsdMiMapper.selectInsuInsdMi(new InsuInsdMiSearch(dom));
    }

    @Override
    public void delInsuInsdMi(InsuInsdMiForm dom) {
        insuInsdMiMapper.deleteInsuInsdMi(dom.getEntity());
        return;
    }

    @Override
    public InsuInsdMiEntity getInsuInsdMi(InsuInsdMiSearch dom) {
        return insuInsdMiMapper.selectInsuInsdMi(dom);
    }

    @Override
    public ResultListDto<InsuInsdMiEntity> getInsuInsdMiList(InsuInsdMiSearch dom) {
        ResultListDto<InsuInsdMiEntity> result = new ResultListDto<>();
        Long totalCnt = insuInsdMiMapper.selectInsuInsdMiListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuInsdMiEntity> list = insuInsdMiMapper.selectInsuInsdMiList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
