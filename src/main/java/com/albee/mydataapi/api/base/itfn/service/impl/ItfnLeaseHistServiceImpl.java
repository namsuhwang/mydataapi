package com.albee.mydataapi.api.base.itfn.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.itfn.models.ItfnLeaseHistSearch;
import com.albee.mydataapi.api.base.itfn.models.entity.ItfnLeaseHistEntity;
import com.albee.mydataapi.api.base.itfn.models.form.ItfnLeaseHistForm;
import com.albee.mydataapi.api.base.itfn.repository.ItfnLeaseHistMapper;
import com.albee.mydataapi.api.base.itfn.service.ItfnLeaseHistService;
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
public class ItfnLeaseHistServiceImpl implements ItfnLeaseHistService {
    @Autowired
    ItfnLeaseHistMapper itfnLeaseHistMapper;

    @Override
    public void regItfnLeaseHist(ItfnLeaseHistForm dom) {
        itfnLeaseHistMapper.insertItfnLeaseHist(dom.getEntity());
    }

    @Override
    public void updItfnLeaseHist(ItfnLeaseHistForm dom) {
        itfnLeaseHistMapper.updateItfnLeaseHist(dom.getEntity());
    }

    @Override
    public void modItfnLeaseHist(ItfnLeaseHistForm dom) {
        if(getItfnLeaseHist(new ItfnLeaseHistSearch(dom)) == null){
            regItfnLeaseHist(dom);
        }else{
            updItfnLeaseHist(dom);
        }
    }

    @Override
    public void delItfnLeaseHist(ItfnLeaseHistForm dom) {
        itfnLeaseHistMapper.deleteItfnLeaseHist(dom.getEntity());
        return;
    }

    @Override
    public ItfnLeaseHistEntity getItfnLeaseHist(ItfnLeaseHistSearch dom) {
        return itfnLeaseHistMapper.selectItfnLeaseHist(dom);
    }

    @Override
    public ItfnLeaseHistEntity getItfnLeaseHistLast(ItfnLeaseHistSearch dom) {
        return itfnLeaseHistMapper.selectItfnLeaseHistLast(dom);
    }

    @Override
    public ResultListDto<ItfnLeaseHistEntity> getItfnLeaseHistList(ItfnLeaseHistSearch dom) {
        ResultListDto<ItfnLeaseHistEntity> result = new ResultListDto<>();
        Long totalCnt = itfnLeaseHistMapper.selectItfnLeaseHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<ItfnLeaseHistEntity> list = itfnLeaseHistMapper.selectItfnLeaseHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
