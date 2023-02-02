package com.abcc.mydataapi.api.base.elec.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.elec.models.ElecPpaySearch;
import com.abcc.mydataapi.api.base.elec.models.entity.ElecPpayEntity;
import com.abcc.mydataapi.api.base.elec.models.form.ElecPpayForm;
import com.abcc.mydataapi.api.base.elec.repository.ElecPpayMapper;
import com.abcc.mydataapi.api.base.elec.service.ElecPpayService;
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
public class ElecPpayServiceImpl implements ElecPpayService {
    @Autowired
    ElecPpayMapper elecPpayMapper;

    @Override
    public ElecPpayEntity regElecPpay(ElecPpayForm dom) {
        elecPpayMapper.insertElecPpay(dom.getEntity());
        return elecPpayMapper.selectElecPpay(new ElecPpaySearch(dom));
    }

    @Override
    public ElecPpayEntity modElecPpay(ElecPpayForm dom) {
        elecPpayMapper.updateElecPpay(dom.getEntity());
        return elecPpayMapper.selectElecPpay(new ElecPpaySearch(dom));
    }

    @Override
    public void delElecPpay(ElecPpayForm dom) {
        elecPpayMapper.deleteElecPpay(dom.getEntity());
        return;
    }

    @Override
    public ElecPpayEntity getElecPpay(ElecPpaySearch dom) {
        return elecPpayMapper.selectElecPpay(dom);
    }

    @Override
    public ResultListDto<ElecPpayEntity> getElecPpayList(ElecPpaySearch dom) {
        ResultListDto<ElecPpayEntity> result = new ResultListDto<>();
        Long totalCnt = elecPpayMapper.selectElecPpayListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<ElecPpayEntity> list = elecPpayMapper.selectElecPpayList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
