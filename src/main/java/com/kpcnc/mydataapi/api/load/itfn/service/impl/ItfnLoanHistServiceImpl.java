package com.kpcnc.mydataapi.api.load.itfn.service.impl;

import com.kpcnc.mydataapi.api.load.itfn.models.ItfnLoanHistSearch;
import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnLoanHistEntity;
import com.kpcnc.mydataapi.api.load.itfn.models.form.ItfnLoanHistForm;
import com.kpcnc.mydataapi.api.load.itfn.repository.ItfnLoanHistMapper;
import com.kpcnc.mydataapi.api.load.itfn.service.ItfnLoanHistService;
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
    public ItfnLoanHistEntity regItfnLoanHist(ItfnLoanHistForm dom) {
        itfnLoanHistMapper.insertItfnLoanHist(dom.getEntity());
        return itfnLoanHistMapper.selectItfnLoanHist(new ItfnLoanHistSearch(dom));
    }

    @Override
    public ItfnLoanHistEntity modItfnLoanHist(ItfnLoanHistForm dom) {
        itfnLoanHistMapper.updateItfnLoanHist(dom.getEntity());
        return itfnLoanHistMapper.selectItfnLoanHist(new ItfnLoanHistSearch(dom));
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
