package com.kpcnc.mydataapi.api.base.insu.service.impl;

import com.kpcnc.mydataapi.api.base.insu.models.InsuInsdMiBasePpSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdMiBasePpEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuInsdMiBasePpForm;
import com.kpcnc.mydataapi.api.base.insu.repository.InsuInsdMiBasePpMapper;
import com.kpcnc.mydataapi.api.base.insu.service.InsuInsdMiBasePpService;
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
public class InsuInsdMiBasePpServiceImpl implements InsuInsdMiBasePpService {
    @Autowired
    InsuInsdMiBasePpMapper insuInsdMiBasePpMapper;

    @Override
    public InsuInsdMiBasePpEntity regInsuInsdMiBasePp(InsuInsdMiBasePpForm dom) {
        insuInsdMiBasePpMapper.insertInsuInsdMiBasePp(dom.getEntity());
        return insuInsdMiBasePpMapper.selectInsuInsdMiBasePp(new InsuInsdMiBasePpSearch(dom));
    }

    @Override
    public InsuInsdMiBasePpEntity modInsuInsdMiBasePp(InsuInsdMiBasePpForm dom) {
        insuInsdMiBasePpMapper.updateInsuInsdMiBasePp(dom.getEntity());
        return insuInsdMiBasePpMapper.selectInsuInsdMiBasePp(new InsuInsdMiBasePpSearch(dom));
    }

    @Override
    public void delInsuInsdMiBasePp(InsuInsdMiBasePpForm dom) {
        insuInsdMiBasePpMapper.deleteInsuInsdMiBasePp(dom.getEntity());
        return;
    }

    @Override
    public InsuInsdMiBasePpEntity getInsuInsdMiBasePp(InsuInsdMiBasePpSearch dom) {
        return insuInsdMiBasePpMapper.selectInsuInsdMiBasePp(dom);
    }

    @Override
    public ResultListDto<InsuInsdMiBasePpEntity> getInsuInsdMiBasePpList(InsuInsdMiBasePpSearch dom) {
        ResultListDto<InsuInsdMiBasePpEntity> result = new ResultListDto<>();
        Long totalCnt = insuInsdMiBasePpMapper.selectInsuInsdMiBasePpListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuInsdMiBasePpEntity> list = insuInsdMiBasePpMapper.selectInsuInsdMiBasePpList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
