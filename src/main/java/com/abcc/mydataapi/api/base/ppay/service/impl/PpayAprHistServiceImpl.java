package com.abcc.mydataapi.api.base.ppay.service.impl;

import com.abcc.mydataapi.api.base.ppay.models.entity.PpayAprHistEntity;
import com.abcc.mydataapi.api.base.ppay.service.PpayAprHistService;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.ppay.models.PpayAprHistSearch;
import com.abcc.mydataapi.api.base.ppay.models.form.PpayAprHistForm;
import com.abcc.mydataapi.api.base.ppay.repository.PpayAprHistMapper;
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
public class PpayAprHistServiceImpl implements PpayAprHistService {
    @Autowired
    PpayAprHistMapper ppayAprHistMapper;

    @Override
    public PpayAprHistEntity regPpayAprHist(PpayAprHistForm dom) {
        ppayAprHistMapper.insertPpayAprHist(dom.getEntity());
        return ppayAprHistMapper.selectPpayAprHist(new PpayAprHistSearch(dom));
    }

    @Override
    public PpayAprHistEntity modPpayAprHist(PpayAprHistForm dom) {
        ppayAprHistMapper.updatePpayAprHist(dom.getEntity());
        return ppayAprHistMapper.selectPpayAprHist(new PpayAprHistSearch(dom));
    }

    @Override
    public void delPpayAprHist(PpayAprHistForm dom) {
        ppayAprHistMapper.deletePpayAprHist(dom.getEntity());
        return;
    }

    @Override
    public PpayAprHistEntity getPpayAprHist(PpayAprHistSearch dom) {
        return ppayAprHistMapper.selectPpayAprHist(dom);
    }

    @Override
    public PpayAprHistEntity getPpayAprHistLast(PpayAprHistSearch dom) {
        return ppayAprHistMapper.selectPpayAprHistLast(dom);
    }

    @Override
    public ResultListDto<PpayAprHistEntity> getPpayAprHistList(PpayAprHistSearch dom) {
        ResultListDto<PpayAprHistEntity> result = new ResultListDto<>();
        Long totalCnt = ppayAprHistMapper.selectPpayAprHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<PpayAprHistEntity> list = ppayAprHistMapper.selectPpayAprHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
