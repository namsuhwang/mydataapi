package com.abcc.mydataapi.api.base.insu.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuLoanAddSearch;
import com.abcc.mydataapi.api.base.insu.models.entity.InsuLoanAddEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuLoanAddForm;
import com.abcc.mydataapi.api.base.insu.repository.InsuLoanAddMapper;
import com.abcc.mydataapi.api.base.insu.service.InsuLoanAddService;
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
public class InsuLoanAddServiceImpl implements InsuLoanAddService {
    @Autowired
    InsuLoanAddMapper insuLoanAddMapper;

    @Override
    public void regInsuLoanAdd(InsuLoanAddForm dom) {
        insuLoanAddMapper.insertInsuLoanAdd(dom.getEntity());
    }

    @Override
    public void updInsuLoanAdd(InsuLoanAddForm dom) {
        insuLoanAddMapper.updateInsuLoanAdd(dom.getEntity());
    }

    @Override
    public void modInsuLoanAdd(InsuLoanAddForm dom) {
        insuLoanAddMapper.updateInsuLoanAdd(dom.getEntity());
    }

    @Override
    public void delInsuLoanAdd(InsuLoanAddForm dom) {
        insuLoanAddMapper.deleteInsuLoanAdd(dom.getEntity());
        return;
    }

    @Override
    public InsuLoanAddEntity getInsuLoanAdd(InsuLoanAddSearch dom) {
        return insuLoanAddMapper.selectInsuLoanAdd(dom);
    }

    @Override
    public ResultListDto<InsuLoanAddEntity> getInsuLoanAddList(InsuLoanAddSearch dom) {
        ResultListDto<InsuLoanAddEntity> result = new ResultListDto<>();
        Long totalCnt = insuLoanAddMapper.selectInsuLoanAddListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuLoanAddEntity> list = insuLoanAddMapper.selectInsuLoanAddList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
