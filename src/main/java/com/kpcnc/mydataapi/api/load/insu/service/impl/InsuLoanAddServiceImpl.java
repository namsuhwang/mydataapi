package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.load.insu.models.InsuLoanAddSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuLoanAddEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuLoanAddForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuLoanAddMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuLoanAddService;
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
public class InsuLoanAddServiceImpl implements InsuLoanAddService {
    @Autowired
    InsuLoanAddMapper insuLoanAddMapper;

    @Override
    public InsuLoanAddEntity regInsuLoanAdd(InsuLoanAddForm dom) {
        insuLoanAddMapper.insertInsuLoanAdd(dom.getEntity());
        return insuLoanAddMapper.selectInsuLoanAdd(new InsuLoanAddSearch(dom));
    }

    @Override
    public InsuLoanAddEntity modInsuLoanAdd(InsuLoanAddForm dom) {
        insuLoanAddMapper.updateInsuLoanAdd(dom.getEntity());
        return insuLoanAddMapper.selectInsuLoanAdd(new InsuLoanAddSearch(dom));
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
