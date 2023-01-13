package com.kpcnc.mydataapi.api.base.card.service.impl;

import com.kpcnc.mydataapi.api.base.card.models.CardChargeAddSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardChargeAddEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardChargeAddForm;
import com.kpcnc.mydataapi.api.base.card.repository.CardChargeAddMapper;
import com.kpcnc.mydataapi.api.base.card.service.CardChargeAddService;
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
public class CardChargeAddServiceImpl implements CardChargeAddService {
    @Autowired
    CardChargeAddMapper cardChargeAddMapper;

    @Override
    public CardChargeAddEntity regCardChargeAdd(CardChargeAddForm dom) {
        cardChargeAddMapper.insertCardChargeAdd(dom.getEntity());
        return cardChargeAddMapper.selectCardChargeAdd(new CardChargeAddSearch(dom));
    }

    @Override
    public CardChargeAddEntity modCardChargeAdd(CardChargeAddForm dom) {
        cardChargeAddMapper.updateCardChargeAdd(dom.getEntity());
        return cardChargeAddMapper.selectCardChargeAdd(new CardChargeAddSearch(dom));
    }

    @Override
    public void delCardChargeAdd(CardChargeAddForm dom) {
        cardChargeAddMapper.deleteCardChargeAdd(dom.getEntity());
        return;
    }

    @Override
    public CardChargeAddEntity getCardChargeAdd(CardChargeAddSearch dom) {
        return cardChargeAddMapper.selectCardChargeAdd(dom);
    }

    @Override
    public ResultListDto<CardChargeAddEntity> getCardChargeAddList(CardChargeAddSearch dom) {
        ResultListDto<CardChargeAddEntity> result = new ResultListDto<>();
        Long totalCnt = cardChargeAddMapper.selectCardChargeAddListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<CardChargeAddEntity> list = cardChargeAddMapper.selectCardChargeAddList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
