package com.kpcnc.mydataapi.api.base.insu.service.impl;

import com.kpcnc.mydataapi.api.base.insu.models.InsuMiSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuMiEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiForm;
import com.kpcnc.mydataapi.api.base.insu.repository.InsuMiMapper;
import com.kpcnc.mydataapi.api.base.insu.service.InsuMiService;
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
public class InsuMiServiceImpl implements InsuMiService {
    @Autowired
    InsuMiMapper insuMiMapper;

    @Override
    public InsuMiEntity regInsuMi(InsuMiForm dom) {
        insuMiMapper.insertInsuMi(dom.getEntity());
        return insuMiMapper.selectInsuMi(new InsuMiSearch(dom));
    }

    @Override
    public InsuMiEntity modInsuMi(InsuMiForm dom) {
        insuMiMapper.updateInsuMi(dom.getEntity());
        return insuMiMapper.selectInsuMi(new InsuMiSearch(dom));
    }

    @Override
    public void delInsuMi(InsuMiForm dom) {
        insuMiMapper.deleteInsuMi(dom.getEntity());
        return;
    }

    @Override
    public InsuMiEntity getInsuMi(InsuMiSearch dom) {
        return insuMiMapper.selectInsuMi(dom);
    }

    @Override
    public ResultListDto<InsuMiEntity> getInsuMiList(InsuMiSearch dom) {
        ResultListDto<InsuMiEntity> result = new ResultListDto<>();
        Long totalCnt = insuMiMapper.selectInsuMiListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuMiEntity> list = insuMiMapper.selectInsuMiList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
