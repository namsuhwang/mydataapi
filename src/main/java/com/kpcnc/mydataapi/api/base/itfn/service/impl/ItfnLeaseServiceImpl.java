package com.kpcnc.mydataapi.api.base.itfn.service.impl;

import com.kpcnc.mydataapi.api.base.itfn.models.ItfnLeaseSearch;
import com.kpcnc.mydataapi.api.base.itfn.models.entity.ItfnLeaseEntity;
import com.kpcnc.mydataapi.api.base.itfn.models.form.ItfnLeaseForm;
import com.kpcnc.mydataapi.api.base.itfn.repository.ItfnLeaseMapper;
import com.kpcnc.mydataapi.api.base.itfn.service.ItfnLeaseService;
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
public class ItfnLeaseServiceImpl implements ItfnLeaseService {
    @Autowired
    ItfnLeaseMapper itfnLeaseMapper;

    @Override
    public ItfnLeaseEntity regItfnLease(ItfnLeaseForm dom) {
        itfnLeaseMapper.insertItfnLease(dom.getEntity());
        return itfnLeaseMapper.selectItfnLease(new ItfnLeaseSearch(dom));
    }

    @Override
    public ItfnLeaseEntity modItfnLease(ItfnLeaseForm dom) {
        itfnLeaseMapper.updateItfnLease(dom.getEntity());
        return itfnLeaseMapper.selectItfnLease(new ItfnLeaseSearch(dom));
    }

    @Override
    public void delItfnLease(ItfnLeaseForm dom) {
        itfnLeaseMapper.deleteItfnLease(dom.getEntity());
        return;
    }

    @Override
    public ItfnLeaseEntity getItfnLease(ItfnLeaseSearch dom) {
        return itfnLeaseMapper.selectItfnLease(dom);
    }

    @Override
    public ResultListDto<ItfnLeaseEntity> getItfnLeaseList(ItfnLeaseSearch dom) {
        ResultListDto<ItfnLeaseEntity> result = new ResultListDto<>();
        Long totalCnt = itfnLeaseMapper.selectItfnLeaseListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<ItfnLeaseEntity> list = itfnLeaseMapper.selectItfnLeaseList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
