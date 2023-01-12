package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.load.insu.models.InsuMiHistSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuMiHistEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuMiHistForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuMiHistMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuMiHistService;
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
public class InsuMiHistServiceImpl implements InsuMiHistService {
    @Autowired
    InsuMiHistMapper insuMiHistMapper;

    @Override
    public InsuMiHistEntity regInsuMiHist(InsuMiHistForm dom) {
        insuMiHistMapper.insertInsuMiHist(dom.getEntity());
        return insuMiHistMapper.selectInsuMiHist(new InsuMiHistSearch(dom));
    }

    @Override
    public InsuMiHistEntity modInsuMiHist(InsuMiHistForm dom) {
        insuMiHistMapper.updateInsuMiHist(dom.getEntity());
        return insuMiHistMapper.selectInsuMiHist(new InsuMiHistSearch(dom));
    }

    @Override
    public void delInsuMiHist(InsuMiHistForm dom) {
        insuMiHistMapper.deleteInsuMiHist(dom.getEntity());
        return;
    }

    @Override
    public InsuMiHistEntity getInsuMiHist(InsuMiHistSearch dom) {
        return insuMiHistMapper.selectInsuMiHist(dom);
    }

    @Override
    public ResultListDto<InsuMiHistEntity> getInsuMiHistList(InsuMiHistSearch dom) {
        ResultListDto<InsuMiHistEntity> result = new ResultListDto<>();
        Long totalCnt = insuMiHistMapper.selectInsuMiHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuMiHistEntity> list = insuMiHistMapper.selectInsuMiHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
