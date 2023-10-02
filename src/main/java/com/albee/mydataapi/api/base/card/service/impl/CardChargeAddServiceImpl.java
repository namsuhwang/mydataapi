package com.albee.mydataapi.api.base.card.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.card.models.CardChargeAddSearch;
import com.albee.mydataapi.api.base.card.models.entity.CardChargeAddEntity;
import com.albee.mydataapi.api.base.card.models.form.CardChargeAddForm;
import com.albee.mydataapi.api.base.card.repository.CardChargeAddMapper;
import com.albee.mydataapi.api.base.card.service.CardChargeAddService;
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
    public void regCardChargeAdd(CardChargeAddForm dom) {
        cardChargeAddMapper.insertCardChargeAdd(dom.getEntity());
        return;
    }

    @Override
    public void updCardChargeAdd(CardChargeAddForm dom) {
        cardChargeAddMapper.updateCardChargeAdd(dom.getEntity());
        return;
    }

    @Override
    public void modCardChargeAdd(CardChargeAddForm dom) {
        if(getCardChargeAdd(new CardChargeAddSearch(dom)) == null){
            regCardChargeAdd(dom);
        }else{
            updCardChargeAdd(dom);
        }
        return;
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
    public CardChargeAddEntity getCardChargeAddLast(CardChargeAddSearch dom) {
        return cardChargeAddMapper.selectCardChargeAddLast(dom);
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
