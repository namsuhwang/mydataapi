package com.kpcnc.mydataapi.api.base.ppay.service.impl;

import com.kpcnc.mydataapi.api.base.ppay.models.PpayHistSearch;
import com.kpcnc.mydataapi.api.base.ppay.models.entity.PpayHistEntity;
import com.kpcnc.mydataapi.api.base.ppay.models.form.PpayHistForm;
import com.kpcnc.mydataapi.api.base.ppay.repository.PpayHistMapper;
import com.kpcnc.mydataapi.api.base.ppay.service.PpayHistService;
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
public class PpayHistServiceImpl implements PpayHistService {
    @Autowired
    PpayHistMapper ppayHistMapper;

    @Override
    public PpayHistEntity regPpayHist(PpayHistForm dom) {
        ppayHistMapper.insertPpayHist(dom.getEntity());
        return ppayHistMapper.selectPpayHist(new PpayHistSearch(dom));
    }

    @Override
    public PpayHistEntity modPpayHist(PpayHistForm dom) {
        ppayHistMapper.updatePpayHist(dom.getEntity());
        return ppayHistMapper.selectPpayHist(new PpayHistSearch(dom));
    }

    @Override
    public void delPpayHist(PpayHistForm dom) {
        ppayHistMapper.deletePpayHist(dom.getEntity());
        return;
    }

    @Override
    public PpayHistEntity getPpayHist(PpayHistSearch dom) {
        return ppayHistMapper.selectPpayHist(dom);
    }


    @Override
    public PpayHistEntity getPpayHistLast(PpayHistSearch dom) {
        return ppayHistMapper.selectPpayHistLast(dom);
    }

    @Override
    public ResultListDto<PpayHistEntity> getPpayHistList(PpayHistSearch dom) {
        ResultListDto<PpayHistEntity> result = new ResultListDto<>();
        Long totalCnt = ppayHistMapper.selectPpayHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<PpayHistEntity> list = ppayHistMapper.selectPpayHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
