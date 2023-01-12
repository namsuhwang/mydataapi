package com.kpcnc.mydataapi.api.load.elec.service.impl;

import com.kpcnc.mydataapi.api.ElecPpayAutoChargeSearch;
import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPpayAutoChargeEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecPpayAutoChargeForm;
import com.kpcnc.mydataapi.api.load.elec.repository.ElecPpayAutoChargeMapper;
import com.kpcnc.mydataapi.api.load.elec.service.ElecPpayAutoChargeService;
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
public class ElecPpayAutoChargeServiceImpl implements ElecPpayAutoChargeService {
    @Autowired
    ElecPpayAutoChargeMapper elecPpayAutoChargeMapper;

    @Override
    public ElecPpayAutoChargeEntity regElecPpayAutoCharge(ElecPpayAutoChargeForm dom) {
        elecPpayAutoChargeMapper.insertElecPpayAutoCharge(dom.getEntity());
        return elecPpayAutoChargeMapper.selectElecPpayAutoCharge(new ElecPpayAutoChargeSearch(dom));
    }

    @Override
    public ElecPpayAutoChargeEntity modElecPpayAutoCharge(ElecPpayAutoChargeForm dom) {
        elecPpayAutoChargeMapper.updateElecPpayAutoCharge(dom.getEntity());
        return elecPpayAutoChargeMapper.selectElecPpayAutoCharge(new ElecPpayAutoChargeSearch(dom));
    }

    @Override
    public void delElecPpayAutoCharge(ElecPpayAutoChargeForm dom) {
        elecPpayAutoChargeMapper.deleteElecPpayAutoCharge(dom.getEntity());
        return;
    }

    @Override
    public ElecPpayAutoChargeEntity getElecPpayAutoCharge(ElecPpayAutoChargeSearch dom) {
        return elecPpayAutoChargeMapper.selectElecPpayAutoCharge(dom);
    }

    @Override
    public ResultListDto<ElecPpayAutoChargeEntity> getElecPpayAutoChargeList(ElecPpayAutoChargeSearch dom) {
        ResultListDto<ElecPpayAutoChargeEntity> result = new ResultListDto<>();
        Long totalCnt = elecPpayAutoChargeMapper.selectElecPpayAutoChargeListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<ElecPpayAutoChargeEntity> list = elecPpayAutoChargeMapper.selectElecPpayAutoChargeList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
