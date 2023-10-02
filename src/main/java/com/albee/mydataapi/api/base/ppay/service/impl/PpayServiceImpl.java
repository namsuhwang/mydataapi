package com.albee.mydataapi.api.base.ppay.service.impl;

import com.albee.mydataapi.api.base.ppay.models.entity.PpayEntity;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.ppay.models.PpaySearch;
import com.albee.mydataapi.api.base.ppay.models.form.PpayForm;
import com.albee.mydataapi.api.base.ppay.repository.PpayMapper;
import com.albee.mydataapi.api.base.ppay.service.PpayService;
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
public class PpayServiceImpl implements PpayService {
    @Autowired
    PpayMapper ppayMapper;

    @Override
    public PpayEntity regPpay(PpayForm dom) {
        ppayMapper.insertPpay(dom.getEntity());
        return ppayMapper.selectPpay(new PpaySearch(dom));
    }

    @Override
    public PpayEntity modPpay(PpayForm dom) {
        ppayMapper.updatePpay(dom.getEntity());
        return ppayMapper.selectPpay(new PpaySearch(dom));
    }

    @Override
    public void delPpay(PpayForm dom) {
        ppayMapper.deletePpay(dom.getEntity());
        return;
    }

    @Override
    public void allDelPpay(PpayForm dom) {
        ppayMapper.deleteAllPpay(dom.getEntity());
        return;
    }

    @Override
    public PpayEntity getPpay(PpaySearch dom) {
        return ppayMapper.selectPpay(dom);
    }

    @Override
    public ResultListDto<PpayEntity> getPpayList(PpaySearch dom) {
        ResultListDto<PpayEntity> result = new ResultListDto<>();
        Long totalCnt = ppayMapper.selectPpayListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<PpayEntity> list = ppayMapper.selectPpayList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
