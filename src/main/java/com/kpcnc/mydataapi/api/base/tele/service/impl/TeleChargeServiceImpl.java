package com.kpcnc.mydataapi.api.base.tele.service.impl;

import com.kpcnc.mydataapi.api.base.tele.models.TeleChargeSearch;
import com.kpcnc.mydataapi.api.base.tele.models.entity.TeleChargeEntity;
import com.kpcnc.mydataapi.api.base.tele.models.form.TeleChargeForm;
import com.kpcnc.mydataapi.api.base.tele.repository.TeleChargeMapper;
import com.kpcnc.mydataapi.api.base.tele.service.TeleChargeService;
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
public class TeleChargeServiceImpl implements TeleChargeService {
    @Autowired
    TeleChargeMapper teleChargeMapper;

    @Override
    public TeleChargeEntity regTeleCharge(TeleChargeForm dom) {
        teleChargeMapper.insertTeleCharge(dom.getEntity());
        return teleChargeMapper.selectTeleCharge(new TeleChargeSearch(dom));
    }

    @Override
    public TeleChargeEntity modTeleCharge(TeleChargeForm dom) {
        teleChargeMapper.updateTeleCharge(dom.getEntity());
        return teleChargeMapper.selectTeleCharge(new TeleChargeSearch(dom));
    }

    @Override
    public void delTeleCharge(TeleChargeForm dom) {
        teleChargeMapper.deleteTeleCharge(dom.getEntity());
        return;
    }

    @Override
    public TeleChargeEntity getTeleCharge(TeleChargeSearch dom) {
        return teleChargeMapper.selectTeleCharge(dom);
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
