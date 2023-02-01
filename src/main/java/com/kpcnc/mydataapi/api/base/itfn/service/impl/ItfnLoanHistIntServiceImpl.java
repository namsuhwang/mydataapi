package com.kpcnc.mydataapi.api.base.itfn.service.impl;

import com.kpcnc.mydataapi.api.base.itfn.models.ItfnLoanHistIntSearch;
import com.kpcnc.mydataapi.api.base.itfn.models.entity.ItfnLoanHistIntEntity;
import com.kpcnc.mydataapi.api.base.itfn.models.form.ItfnLoanHistIntForm;
import com.kpcnc.mydataapi.api.base.itfn.repository.ItfnLoanHistIntMapper;
import com.kpcnc.mydataapi.api.base.itfn.service.ItfnLoanHistIntService;
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
public class ItfnLoanHistIntServiceImpl implements ItfnLoanHistIntService {
    @Autowired
    ItfnLoanHistIntMapper itfnLoanHistIntMapper;

    @Override
    public void regItfnLoanHistInt(ItfnLoanHistIntForm dom) {
        itfnLoanHistIntMapper.insertItfnLoanHistInt(dom.getEntity());
    }

    @Override
    public void updItfnLoanHistInt(ItfnLoanHistIntForm dom) {
        itfnLoanHistIntMapper.updateItfnLoanHistInt(dom.getEntity());
    }

    @Override
    public void modItfnLoanHistInt(ItfnLoanHistIntForm dom) {
        if(getItfnLoanHistInt(new ItfnLoanHistIntSearch(dom)) == null){
            regItfnLoanHistInt(dom);
        }else{
            updItfnLoanHistInt(dom);
        }
    }

    @Override
    public void delItfnLoanHistInt(ItfnLoanHistIntForm dom) {
        itfnLoanHistIntMapper.deleteItfnLoanHistInt(dom.getEntity());
        return;
    }

    @Override
    public ItfnLoanHistIntEntity getItfnLoanHistInt(ItfnLoanHistIntSearch dom) {
        return itfnLoanHistIntMapper.selectItfnLoanHistInt(dom);
    }

    @Override
    public ResultListDto<ItfnLoanHistIntEntity> getItfnLoanHistIntList(ItfnLoanHistIntSearch dom) {
        ResultListDto<ItfnLoanHistIntEntity> result = new ResultListDto<>();
        Long totalCnt = itfnLoanHistIntMapper.selectItfnLoanHistIntListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<ItfnLoanHistIntEntity> list = itfnLoanHistIntMapper.selectItfnLoanHistIntList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
