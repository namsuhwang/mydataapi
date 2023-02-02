package com.abcc.mydataapi.api.base.itfn.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.itfn.models.ItfnCustSearch;
import com.abcc.mydataapi.api.base.itfn.models.entity.ItfnCustEntity;
import com.abcc.mydataapi.api.base.itfn.models.form.ItfnCustForm;
import com.abcc.mydataapi.api.base.itfn.repository.ItfnCustMapper;
import com.abcc.mydataapi.api.base.itfn.service.ItfnCustService;
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
public class ItfnCustServiceImpl implements ItfnCustService {
    @Autowired
    ItfnCustMapper itfnCustMapper;

    @Override
    public void regItfnCust(ItfnCustForm dom) {
        itfnCustMapper.insertItfnCust(dom.getEntity());
    }

    @Override
    public void updItfnCust(ItfnCustForm dom) {
        itfnCustMapper.updateItfnCust(dom.getEntity());
    }

    @Override
    public void modItfnCust(ItfnCustForm dom) {
        if(getItfnCust(new ItfnCustSearch(dom)) == null){
            regItfnCust(dom);
        }else{
            updItfnCust(dom);
        }
    }

    @Override
    public void delItfnCust(ItfnCustForm dom) {
        itfnCustMapper.deleteItfnCust(dom.getEntity());
        return;
    }

    @Override
    public ItfnCustEntity getItfnCust(ItfnCustSearch dom) {
        return itfnCustMapper.selectItfnCust(dom);
    }

    @Override
    public ResultListDto<ItfnCustEntity> getItfnCustList(ItfnCustSearch dom) {
        ResultListDto<ItfnCustEntity> result = new ResultListDto<>();
        Long totalCnt = itfnCustMapper.selectItfnCustListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<ItfnCustEntity> list = itfnCustMapper.selectItfnCustList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
