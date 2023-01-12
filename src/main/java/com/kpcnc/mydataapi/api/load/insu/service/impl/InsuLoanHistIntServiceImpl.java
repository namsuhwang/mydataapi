package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.load.insu.models.InsuLoanHistIntSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuLoanHistIntEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuLoanHistIntForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuLoanHistIntMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuLoanHistIntService;
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
public class InsuLoanHistIntServiceImpl implements InsuLoanHistIntService {
    @Autowired
    InsuLoanHistIntMapper insuLoanHistIntMapper;

    @Override
    public InsuLoanHistIntEntity regInsuLoanHistInt(InsuLoanHistIntForm dom) {
        insuLoanHistIntMapper.insertInsuLoanHistInt(dom.getEntity());
        return insuLoanHistIntMapper.selectInsuLoanHistInt(new InsuLoanHistIntSearch(dom));
    }

    @Override
    public InsuLoanHistIntEntity modInsuLoanHistInt(InsuLoanHistIntForm dom) {
        insuLoanHistIntMapper.updateInsuLoanHistInt(dom.getEntity());
        return insuLoanHistIntMapper.selectInsuLoanHistInt(new InsuLoanHistIntSearch(dom));
    }

    @Override
    public void delInsuLoanHistInt(InsuLoanHistIntForm dom) {
        insuLoanHistIntMapper.deleteInsuLoanHistInt(dom.getEntity());
        return;
    }

    @Override
    public InsuLoanHistIntEntity getInsuLoanHistInt(InsuLoanHistIntSearch dom) {
        return insuLoanHistIntMapper.selectInsuLoanHistInt(dom);
    }

    @Override
    public ResultListDto<InsuLoanHistIntEntity> getInsuLoanHistIntList(InsuLoanHistIntSearch dom) {
        ResultListDto<InsuLoanHistIntEntity> result = new ResultListDto<>();
        Long totalCnt = insuLoanHistIntMapper.selectInsuLoanHistIntListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuLoanHistIntEntity> list = insuLoanHistIntMapper.selectInsuLoanHistIntList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
