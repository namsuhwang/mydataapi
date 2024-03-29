package com.albee.mydataapi.api.base.insu.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuInsdMiBasePpSearch;
import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdMiBasePpEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuInsdMiBasePpForm;
import com.albee.mydataapi.api.base.insu.repository.InsuInsdMiBasePpMapper;
import com.albee.mydataapi.api.base.insu.service.InsuInsdMiBasePpService;
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
    public void regInsuInsdMiBasePp(InsuInsdMiBasePpForm dom) {
        insuInsdMiBasePpMapper.insertInsuInsdMiBasePp(dom.getEntity());
    }

    @Override
    public void updInsuInsdMiBasePp(InsuInsdMiBasePpForm dom) {
        insuInsdMiBasePpMapper.updateInsuInsdMiBasePp(dom.getEntity());
    }

    @Override
    public void modInsuInsdMiBasePp(InsuInsdMiBasePpForm dom) {
        if(getInsuInsdMiBasePp(new InsuInsdMiBasePpSearch(dom)) == null){
            regInsuInsdMiBasePp(dom);
        }else{
            updInsuInsdMiBasePp(dom);
        }
    }

    @Override
    public void delInsuInsdMiBasePp(InsuInsdMiBasePpForm dom) {
        insuInsdMiBasePpMapper.deleteInsuInsdMiBasePp(dom.getEntity());
        return;
    }

    @Override
    public void allDelInsuInsdMiBasePp(InsuInsdMiBasePpForm dom) {
        insuInsdMiBasePpMapper.deleteAllInsuInsdMiBasePp(dom.getEntity());
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
