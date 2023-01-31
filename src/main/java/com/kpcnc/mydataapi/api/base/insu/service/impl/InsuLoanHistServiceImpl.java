package com.kpcnc.mydataapi.api.base.insu.service.impl;

import com.kpcnc.mydataapi.api.base.insu.models.InsuLoanHistSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuLoanHistEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuLoanHistForm;
import com.kpcnc.mydataapi.api.base.insu.repository.InsuLoanHistMapper;
import com.kpcnc.mydataapi.api.base.insu.service.InsuLoanHistService;
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
public class InsuLoanHistServiceImpl implements InsuLoanHistService {
    @Autowired
    InsuLoanHistMapper insuLoanHistMapper;

    @Override
    public void regInsuLoanHist(InsuLoanHistForm dom) {
        insuLoanHistMapper.insertInsuLoanHist(dom.getEntity());
    }

    @Override
    public void updInsuLoanHist(InsuLoanHistForm dom) {
        insuLoanHistMapper.updateInsuLoanHist(dom.getEntity());
    }

    @Override
    public void modInsuLoanHist(InsuLoanHistForm dom) {
        if(getInsuLoanHist(new InsuLoanHistSearch(dom)) == null){
            regInsuLoanHist(dom);
        }else{
            updInsuLoanHist(dom);
        }
    }

    @Override
    public void delInsuLoanHist(InsuLoanHistForm dom) {
        insuLoanHistMapper.deleteInsuLoanHist(dom.getEntity());
        return;
    }

    @Override
    public InsuLoanHistEntity getInsuLoanHist(InsuLoanHistSearch dom) {
        return insuLoanHistMapper.selectInsuLoanHist(dom);
    }

    @Override
    public InsuLoanHistEntity getInsuLoanHistLast(InsuLoanHistSearch dom) {
        return insuLoanHistMapper.selectInsuLoanHistLast(dom);
    }

    @Override
    public ResultListDto<InsuLoanHistEntity> getInsuLoanHistList(InsuLoanHistSearch dom) {
        ResultListDto<InsuLoanHistEntity> result = new ResultListDto<>();
        Long totalCnt = insuLoanHistMapper.selectInsuLoanHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuLoanHistEntity> list = insuLoanHistMapper.selectInsuLoanHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
