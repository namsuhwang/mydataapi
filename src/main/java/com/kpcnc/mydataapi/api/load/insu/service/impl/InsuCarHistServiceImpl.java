package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.load.insu.models.InsuCarHistSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuCarHistEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuCarHistForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuCarHistMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuCarHistService;
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
public class InsuCarHistServiceImpl implements InsuCarHistService {
    @Autowired
    InsuCarHistMapper insuCarHistMapper;

    @Override
    public InsuCarHistEntity regInsuCarHist(InsuCarHistForm dom) {
        insuCarHistMapper.insertInsuCarHist(dom.getEntity());
        return insuCarHistMapper.selectInsuCarHist(new InsuCarHistSearch(dom));
    }

    @Override
    public InsuCarHistEntity modInsuCarHist(InsuCarHistForm dom) {
        insuCarHistMapper.updateInsuCarHist(dom.getEntity());
        return insuCarHistMapper.selectInsuCarHist(new InsuCarHistSearch(dom));
    }

    @Override
    public void delInsuCarHist(InsuCarHistForm dom) {
        insuCarHistMapper.deleteInsuCarHist(dom.getEntity());
        return;
    }

    @Override
    public InsuCarHistEntity getInsuCarHist(InsuCarHistSearch dom) {
        return insuCarHistMapper.selectInsuCarHist(dom);
    }

    @Override
    public ResultListDto<InsuCarHistEntity> getInsuCarHistList(InsuCarHistSearch dom) {
        ResultListDto<InsuCarHistEntity> result = new ResultListDto<>();
        Long totalCnt = insuCarHistMapper.selectInsuCarHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuCarHistEntity> list = insuCarHistMapper.selectInsuCarHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
