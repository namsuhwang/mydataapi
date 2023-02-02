package com.albee.mydataapi.api.base.itfn.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.itfn.models.ItfnLeaseSearch;
import com.albee.mydataapi.api.base.itfn.models.entity.ItfnLeaseEntity;
import com.albee.mydataapi.api.base.itfn.models.form.ItfnLeaseForm;
import com.albee.mydataapi.api.base.itfn.repository.ItfnLeaseMapper;
import com.albee.mydataapi.api.base.itfn.service.ItfnLeaseService;
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
    public void regItfnLease(ItfnLeaseForm dom) {
        itfnLeaseMapper.insertItfnLease(dom.getEntity());
    }

    @Override
    public void updItfnLease(ItfnLeaseForm dom) {
        itfnLeaseMapper.updateItfnLease(dom.getEntity());
    }

    @Override
    public void modItfnLease(ItfnLeaseForm dom) {
        if(getItfnLease(new ItfnLeaseSearch(dom)) == null){
            regItfnLease(dom);
        }else{
            updItfnLease(dom);
        }
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
