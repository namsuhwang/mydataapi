package com.abcc.mydataapi.api.base.elec.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.elec.models.ElecPpayHistSearch;
import com.abcc.mydataapi.api.base.elec.models.entity.ElecPpayHistEntity;
import com.abcc.mydataapi.api.base.elec.models.form.ElecPpayHistForm;
import com.abcc.mydataapi.api.base.elec.repository.ElecPpayHistMapper;
import com.abcc.mydataapi.api.base.elec.service.ElecPpayHistService;
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
public class ElecPpayHistServiceImpl implements ElecPpayHistService {
    @Autowired
    ElecPpayHistMapper elecPpayHistMapper;

    @Override
    public ElecPpayHistEntity regElecPpayHist(ElecPpayHistForm dom) {
        elecPpayHistMapper.insertElecPpayHist(dom.getEntity());
        return elecPpayHistMapper.selectElecPpayHist(new ElecPpayHistSearch(dom));
    }

    @Override
    public ElecPpayHistEntity modElecPpayHist(ElecPpayHistForm dom) {
        elecPpayHistMapper.updateElecPpayHist(dom.getEntity());
        return elecPpayHistMapper.selectElecPpayHist(new ElecPpayHistSearch(dom));
    }

    @Override
    public void delElecPpayHist(ElecPpayHistForm dom) {
        elecPpayHistMapper.deleteElecPpayHist(dom.getEntity());
        return;
    }

    @Override
    public ElecPpayHistEntity getElecPpayHist(ElecPpayHistSearch dom) {
        return elecPpayHistMapper.selectElecPpayHist(dom);
    }

    @Override
    public ResultListDto<ElecPpayHistEntity> getElecPpayHistList(ElecPpayHistSearch dom) {
        ResultListDto<ElecPpayHistEntity> result = new ResultListDto<>();
        Long totalCnt = elecPpayHistMapper.selectElecPpayHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<ElecPpayHistEntity> list = elecPpayHistMapper.selectElecPpayHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
