package com.kpcnc.mydataapi.api.base.itfn.service.impl;

import com.kpcnc.mydataapi.api.base.itfn.models.ItfnLeaseHistSearch;
import com.kpcnc.mydataapi.api.base.itfn.models.entity.ItfnLeaseHistEntity;
import com.kpcnc.mydataapi.api.base.itfn.models.form.ItfnLeaseHistForm;
import com.kpcnc.mydataapi.api.base.itfn.repository.ItfnLeaseHistMapper;
import com.kpcnc.mydataapi.api.base.itfn.service.ItfnLeaseHistService;
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
public class ItfnLeaseHistServiceImpl implements ItfnLeaseHistService {
    @Autowired
    ItfnLeaseHistMapper itfnLeaseHistMapper;

    @Override
    public ItfnLeaseHistEntity regItfnLeaseHist(ItfnLeaseHistForm dom) {
        itfnLeaseHistMapper.insertItfnLeaseHist(dom.getEntity());
        return itfnLeaseHistMapper.selectItfnLeaseHist(new ItfnLeaseHistSearch(dom));
    }

    @Override
    public ItfnLeaseHistEntity modItfnLeaseHist(ItfnLeaseHistForm dom) {
        itfnLeaseHistMapper.updateItfnLeaseHist(dom.getEntity());
        return itfnLeaseHistMapper.selectItfnLeaseHist(new ItfnLeaseHistSearch(dom));
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
