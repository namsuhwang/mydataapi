package com.albee.mydataapi.api.base.card.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.card.models.CardChargeSearch;
import com.albee.mydataapi.api.base.card.models.entity.CardChargeEntity;
import com.albee.mydataapi.api.base.card.models.form.CardChargeForm;
import com.albee.mydataapi.api.base.card.repository.CardChargeMapper;
import com.albee.mydataapi.api.base.card.service.CardChargeService;
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
public class CardChargeServiceImpl implements CardChargeService {
    @Autowired
    CardChargeMapper cardChargeMapper;

    @Override
    public void regCardCharge(CardChargeForm dom) {
        cardChargeMapper.insertCardCharge(dom.getEntity());
        return;
    }

    @Override
    public void updCardCharge(CardChargeForm dom) {
        cardChargeMapper.updateCardCharge(dom.getEntity());
        return;
    }

    @Override
    public void modCardCharge(CardChargeForm dom) {
        if(getCardCharge(new CardChargeSearch(dom)) == null){
            regCardCharge(dom);
        }else{
            updCardCharge(dom);
        }

        return;

    }

    @Override
    public void delCardCharge(CardChargeForm dom) {
        cardChargeMapper.deleteCardCharge(dom.getEntity());
        return;
    }

    @Override
    public CardChargeEntity getCardCharge(CardChargeSearch dom) {
        return cardChargeMapper.selectCardCharge(dom);
    }

    @Override
    public CardChargeEntity getCardChargeLast(CardChargeSearch dom) {
        return cardChargeMapper.selectCardChargeLast(dom);
    }

    @Override
    public ResultListDto<CardChargeEntity> getCardChargeList(CardChargeSearch dom) {
        ResultListDto<CardChargeEntity> result = new ResultListDto<>();
        Long totalCnt = cardChargeMapper.selectCardChargeListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<CardChargeEntity> list = cardChargeMapper.selectCardChargeList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
