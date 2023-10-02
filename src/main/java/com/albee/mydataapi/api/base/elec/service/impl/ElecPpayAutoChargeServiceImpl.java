package com.albee.mydataapi.api.base.elec.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.elec.models.ElecPpayAutoChargeSearch;
import com.albee.mydataapi.api.base.elec.models.entity.ElecPpayAutoChargeEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPpayAutoChargeForm;
import com.albee.mydataapi.api.base.elec.repository.ElecPpayAutoChargeMapper;
import com.albee.mydataapi.api.base.elec.service.ElecPpayAutoChargeService;
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
    public void regElecPpayAutoCharge(ElecPpayAutoChargeForm dom) {
        elecPpayAutoChargeMapper.insertElecPpayAutoCharge(dom.getEntity());
    }

    @Override
    public void updElecPpayAutoCharge(ElecPpayAutoChargeForm dom) {
        elecPpayAutoChargeMapper.updateElecPpayAutoCharge(dom.getEntity());
    }

    @Override
    public void modElecPpayAutoCharge(ElecPpayAutoChargeForm dom) {
        if(getElecPpayAutoCharge(new ElecPpayAutoChargeSearch(dom)) == null){
            regElecPpayAutoCharge(dom);
        }else{
            updElecPpayAutoCharge(dom);
        }
    }

    @Override
    public void delElecPpayAutoCharge(ElecPpayAutoChargeForm dom) {
        elecPpayAutoChargeMapper.deleteElecPpayAutoCharge(dom.getEntity());
        return;
    }

    @Override
    public void allDelElecPpayAutoCharge(ElecPpayAutoChargeForm dom) {
        elecPpayAutoChargeMapper.deleteAllElecPpayAutoCharge(dom.getEntity());
        return;
    }

    @Override
    public ElecPpayAutoChargeEntity getElecPpayAutoCharge(ElecPpayAutoChargeSearch dom) {
        return elecPpayAutoChargeMapper.selectElecPpayAutoCharge(dom);
    }

    @Override
    public ElecPpayAutoChargeEntity getElecPpayAutoChargeLast(ElecPpayAutoChargeSearch dom) {
        return elecPpayAutoChargeMapper.selectElecPpayAutoChargeLast(dom);
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
