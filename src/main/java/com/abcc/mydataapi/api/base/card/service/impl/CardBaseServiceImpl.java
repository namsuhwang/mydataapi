package com.abcc.mydataapi.api.base.card.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.card.models.CardBaseSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardBaseEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardBaseForm;
import com.abcc.mydataapi.api.base.card.repository.CardBaseMapper;
import com.abcc.mydataapi.api.base.card.service.CardBaseService;
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
public class CardBaseServiceImpl implements CardBaseService {
    @Autowired
    CardBaseMapper cardBaseMapper;

    @Override
    public CardBaseEntity regCardBase(CardBaseForm dom) {
        cardBaseMapper.insertCardBase(dom.getEntity());
        return cardBaseMapper.selectCardBase(new CardBaseSearch(dom));
    }

    @Override
    public CardBaseEntity modCardBase(CardBaseForm dom) {
        cardBaseMapper.updateCardBase(dom.getEntity());
        return cardBaseMapper.selectCardBase(new CardBaseSearch(dom));
    }

    @Override
    public void delCardBase(CardBaseForm dom) {
        cardBaseMapper.deleteCardBase(dom.getEntity());
        return;
    }

    @Override
    public CardBaseEntity getCardBase(CardBaseSearch dom) {
        return cardBaseMapper.selectCardBase(dom);
    }

    @Override
    public ResultListDto<CardBaseEntity> getCardBaseList(CardBaseSearch dom) {
        ResultListDto<CardBaseEntity> result = new ResultListDto<>();
        Long totalCnt = cardBaseMapper.selectCardBaseListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<CardBaseEntity> list = cardBaseMapper.selectCardBaseList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
