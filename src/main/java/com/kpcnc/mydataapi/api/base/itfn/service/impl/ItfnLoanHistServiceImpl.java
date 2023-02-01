package com.kpcnc.mydataapi.api.base.itfn.service.impl;

import com.kpcnc.mydataapi.api.base.itfn.models.ItfnLoanHistSearch;
import com.kpcnc.mydataapi.api.base.itfn.models.entity.ItfnLoanHistEntity;
import com.kpcnc.mydataapi.api.base.itfn.models.form.ItfnLoanHistForm;
import com.kpcnc.mydataapi.api.base.itfn.repository.ItfnLoanHistMapper;
import com.kpcnc.mydataapi.api.base.itfn.service.ItfnLoanHistService;
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
public class ItfnLoanHistServiceImpl implements ItfnLoanHistService {
    @Autowired
    ItfnLoanHistMapper itfnLoanHistMapper;

    @Override
    public void regItfnLoanHist(ItfnLoanHistForm dom) {
        itfnLoanHistMapper.insertItfnLoanHist(dom.getEntity());
    }

    @Override
    public void updItfnLoanHist(ItfnLoanHistForm dom) {
        itfnLoanHistMapper.updateItfnLoanHist(dom.getEntity());
    }

    @Override
    public void modItfnLoanHist(ItfnLoanHistForm dom) {
        if(getItfnLoanHist(new ItfnLoanHistSearch(dom)) == null){
            regItfnLoanHist(dom);
        }else{
            updItfnLoanHist(dom);
        }
    }

    @Override
    public void delItfnLoanHist(ItfnLoanHistForm dom) {
        itfnLoanHistMapper.deleteItfnLoanHist(dom.getEntity());
        return;
    }

    @Override
    public ItfnLoanHistEntity getItfnLoanHist(ItfnLoanHistSearch dom) {
        return itfnLoanHistMapper.selectItfnLoanHist(dom);
    }

    @Override
    public ItfnLoanHistEntity getItfnLoanHistLast(ItfnLoanHistSearch dom) {
        return itfnLoanHistMapper.selectItfnLoanHistLast(dom);
    }

    @Override
    public ResultListDto<ItfnLoanHistEntity> getItfnLoanHistList(ItfnLoanHistSearch dom) {
        ResultListDto<ItfnLoanHistEntity> result = new ResultListDto<>();
        Long totalCnt = itfnLoanHistMapper.selectItfnLoanHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<ItfnLoanHistEntity> list = itfnLoanHistMapper.selectItfnLoanHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
