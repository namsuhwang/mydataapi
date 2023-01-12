package com.kpcnc.mydataapi.api.load.dc.service.impl;

import com.kpcnc.mydataapi.api.load.dc.models.DcHistSearch;
import com.kpcnc.mydataapi.api.load.dc.models.entity.DcHistEntity;
import com.kpcnc.mydataapi.api.load.dc.models.form.DcHistForm;
import com.kpcnc.mydataapi.api.load.dc.repository.DcHistMapper;
import com.kpcnc.mydataapi.api.load.dc.service.DcHistService;
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
public class DcHistServiceImpl implements DcHistService {
    @Autowired
    DcHistMapper dcHistMapper;

    @Override
    public DcHistEntity regDcHist(DcHistForm dom) {
        dcHistMapper.insertDcHist(dom.getEntity());
        return dcHistMapper.selectDcHist(new DcHistSearch(dom));
    }

    @Override
    public DcHistEntity modDcHist(DcHistForm dom) {
        dcHistMapper.updateDcHist(dom.getEntity());
        return dcHistMapper.selectDcHist(new DcHistSearch(dom));
    }

    @Override
    public void delDcHist(DcHistForm dom) {
        dcHistMapper.deleteDcHist(dom.getEntity());
        return;
    }

    @Override
    public DcHistEntity getDcHist(DcHistSearch dom) {
        return dcHistMapper.selectDcHist(dom);
    }

    @Override
    public ResultListDto<DcHistEntity> getDcHistList(DcHistSearch dom) {
        ResultListDto<DcHistEntity> result = new ResultListDto<>();
        Long totalCnt = dcHistMapper.selectDcHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<DcHistEntity> list = dcHistMapper.selectDcHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
