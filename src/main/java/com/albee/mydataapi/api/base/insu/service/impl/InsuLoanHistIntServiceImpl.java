package com.albee.mydataapi.api.base.insu.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuLoanHistIntSearch;
import com.albee.mydataapi.api.base.insu.models.entity.InsuLoanHistIntEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuLoanHistIntForm;
import com.albee.mydataapi.api.base.insu.repository.InsuLoanHistIntMapper;
import com.albee.mydataapi.api.base.insu.service.InsuLoanHistIntService;
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
    public void regInsuLoanHistInt(InsuLoanHistIntForm dom) {
        insuLoanHistIntMapper.insertInsuLoanHistInt(dom.getEntity());
    }

    @Override
    public void updInsuLoanHistInt(InsuLoanHistIntForm dom) {
        insuLoanHistIntMapper.updateInsuLoanHistInt(dom.getEntity());
    }

    @Override
    public void modInsuLoanHistInt(InsuLoanHistIntForm dom) {
        if(getInsuLoanHistInt(new InsuLoanHistIntSearch(dom)) == null){
            regInsuLoanHistInt(dom);
        }else{
            updInsuLoanHistInt(dom);
        }
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
