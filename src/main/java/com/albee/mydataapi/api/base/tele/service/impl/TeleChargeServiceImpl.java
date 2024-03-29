package com.albee.mydataapi.api.base.tele.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.tele.models.TeleChargeSearch;
import com.albee.mydataapi.api.base.tele.models.entity.TeleChargeEntity;
import com.albee.mydataapi.api.base.tele.models.form.TeleChargeForm;
import com.albee.mydataapi.api.base.tele.repository.TeleChargeMapper;
import com.albee.mydataapi.api.base.tele.service.TeleChargeService;
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
public class TeleChargeServiceImpl implements TeleChargeService {
    @Autowired
    TeleChargeMapper teleChargeMapper;

    @Override
    public void regTeleCharge(TeleChargeForm dom) {
        teleChargeMapper.insertTeleCharge(dom.getEntity());
    }

    @Override
    public void updTeleCharge(TeleChargeForm dom) {
        teleChargeMapper.updateTeleCharge(dom.getEntity());
    }
    @Override
    public void modTeleCharge(TeleChargeForm dom) {
        if(getTeleCharge(new TeleChargeSearch(dom)) == null){
            regTeleCharge(dom);
        }else{
            updTeleCharge(dom);
        }
    }

    @Override
    public void delTeleCharge(TeleChargeForm dom) {
        teleChargeMapper.deleteTeleCharge(dom.getEntity());
    }

    @Override
    public TeleChargeEntity getTeleCharge(TeleChargeSearch dom) {
        return teleChargeMapper.selectTeleCharge(dom);
    }

    @Override
    public TeleChargeEntity getTeleChargeLast(TeleChargeSearch dom) {
        return teleChargeMapper.selectTeleChargeLast(dom);
    }


    @Override
    public ResultListDto<TeleChargeEntity> getTeleChargeList(TeleChargeSearch dom) {
        ResultListDto<TeleChargeEntity> result = new ResultListDto<>();
        Long totalCnt = teleChargeMapper.selectTeleChargeListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<TeleChargeEntity> list = teleChargeMapper.selectTeleChargeList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
