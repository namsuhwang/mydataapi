package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.InsuMiBasePpEntity;
import com.kpcnc.mydataapi.api.load.insu.models.InsuMiBasePpSearch;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuMiBasePpForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuMiBasePpMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuMiBasePpService;
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
public class InsuMiBasePpServiceImpl implements InsuMiBasePpService {
    @Autowired
    InsuMiBasePpMapper insuMiBasePpMapper;

    @Override
    public InsuMiBasePpEntity regInsuMiBasePp(InsuMiBasePpForm dom) {
        insuMiBasePpMapper.insertInsuMiBasePp(dom.getEntity());
        return insuMiBasePpMapper.selectInsuMiBasePp(new InsuMiBasePpSearch(dom));
    }

    @Override
    public InsuMiBasePpEntity modInsuMiBasePp(InsuMiBasePpForm dom) {
        insuMiBasePpMapper.updateInsuMiBasePp(dom.getEntity());
        return insuMiBasePpMapper.selectInsuMiBasePp(new InsuMiBasePpSearch(dom));
    }

    @Override
    public void delInsuMiBasePp(InsuMiBasePpForm dom) {
        insuMiBasePpMapper.deleteInsuMiBasePp(dom.getEntity());
        return;
    }

    @Override
    public InsuMiBasePpEntity getInsuMiBasePp(InsuMiBasePpSearch dom) {
        return insuMiBasePpMapper.selectInsuMiBasePp(dom);
    }

    @Override
    public ResultListDto<InsuMiBasePpEntity> getInsuMiBasePpList(InsuMiBasePpSearch dom) {
        ResultListDto<InsuMiBasePpEntity> result = new ResultListDto<>();
        Long totalCnt = insuMiBasePpMapper.selectInsuMiBasePpListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuMiBasePpEntity> list = insuMiBasePpMapper.selectInsuMiBasePpList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
