package com.albee.mydataapi.api.base.insu.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuMiBasePpSearch;
import com.albee.mydataapi.api.base.insu.models.entity.InsuMiBasePpEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuMiBasePpForm;
import com.albee.mydataapi.api.base.insu.repository.InsuMiBasePpMapper;
import com.albee.mydataapi.api.base.insu.service.InsuMiBasePpService;
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
    public void regInsuMiBasePp(InsuMiBasePpForm dom) {
        insuMiBasePpMapper.insertInsuMiBasePp(dom.getEntity());
    }

    @Override
    public void updInsuMiBasePp(InsuMiBasePpForm dom) {
        insuMiBasePpMapper.updateInsuMiBasePp(dom.getEntity());
    }

    @Override
    public void modInsuMiBasePp(InsuMiBasePpForm dom) {
        if(getInsuMiBasePp(new InsuMiBasePpSearch(dom)) == null){
            regInsuMiBasePp(dom);
        }else{
            updInsuMiBasePp(dom);
        }
    }

    @Override
    public void delInsuMiBasePp(InsuMiBasePpForm dom) {
        insuMiBasePpMapper.deleteInsuMiBasePp(dom.getEntity());
        return;
    }

    @Override
    public void allDelInsuMiBasePp(InsuMiBasePpForm dom) {
        insuMiBasePpMapper.deleteAllInsuMiBasePp(dom.getEntity());
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
