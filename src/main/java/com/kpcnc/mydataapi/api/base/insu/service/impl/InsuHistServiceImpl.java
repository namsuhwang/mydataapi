package com.kpcnc.mydataapi.api.base.insu.service.impl;

import com.kpcnc.mydataapi.api.base.insu.models.InsuHistSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuHistEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuHistForm;
import com.kpcnc.mydataapi.api.base.insu.repository.InsuHistMapper;
import com.kpcnc.mydataapi.api.base.insu.service.InsuHistService;
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
public class InsuHistServiceImpl implements InsuHistService {
    @Autowired
    InsuHistMapper insuHistMapper;

    @Override
    public void regInsuHist(InsuHistForm dom) {
        insuHistMapper.insertInsuHist(dom.getEntity());
        return;
    }

    @Override
    public void updInsuHist(InsuHistForm dom) {
        insuHistMapper.updateInsuHist(dom.getEntity());
        return;
    }

    @Override
    public void modInsuHist(InsuHistForm dom) {
        if(getInsuHist(new InsuHistSearch(dom)) == null){
            regInsuHist(dom);
        }else{
            updInsuHist(dom);
        }
        return;
    }

    @Override
    public void delInsuHist(InsuHistForm dom) {
        insuHistMapper.deleteInsuHist(dom.getEntity());
        return;
    }

    @Override
    public InsuHistEntity getInsuHist(InsuHistSearch dom) {
        return insuHistMapper.selectInsuHist(dom);
    }

    @Override
    public InsuHistEntity getInsuHistLast(InsuHistSearch dom) {
        return insuHistMapper.selectInsuHistLast(dom);
    }

    @Override
    public ResultListDto<InsuHistEntity> getInsuHistList(InsuHistSearch dom) {
        ResultListDto<InsuHistEntity> result = new ResultListDto<>();
        Long totalCnt = insuHistMapper.selectInsuHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuHistEntity> list = insuHistMapper.selectInsuHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
