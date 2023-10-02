package com.albee.mydataapi.api.base.insu.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuCarHistSearch;
import com.albee.mydataapi.api.base.insu.models.entity.InsuCarHistEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuCarHistForm;
import com.albee.mydataapi.api.base.insu.repository.InsuCarHistMapper;
import com.albee.mydataapi.api.base.insu.service.InsuCarHistService;
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
    public void regInsuCarHist(InsuCarHistForm dom) {
        insuCarHistMapper.insertInsuCarHist(dom.getEntity());
        return;
    }

    @Override
    public void updInsuCarHist(InsuCarHistForm dom) {
        insuCarHistMapper.updateInsuCarHist(dom.getEntity());
        return;
    }

    @Override
    public void modInsuCarHist(InsuCarHistForm dom) {
        if(getInsuCarHist(new InsuCarHistSearch(dom)) == null){
            regInsuCarHist(dom);
        }else{
            updInsuCarHist(dom);
        }
        return;
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
    public InsuCarHistEntity getInsuCarHistLast(InsuCarHistSearch dom) {
        return insuCarHistMapper.selectInsuCarHistLast(dom);
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
