package com.abcc.mydataapi.api.base.card.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.card.models.CardSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardForm;
import com.abcc.mydataapi.api.base.card.repository.CardMapper;
import com.abcc.mydataapi.api.base.card.service.CardService;
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
public class CardServiceImpl implements CardService {
    @Autowired
    CardMapper cardMapper;

    @Override
    public CardEntity regCard(CardForm dom) {
        cardMapper.insertCard(dom.getEntity());
        return cardMapper.selectCard(new CardSearch(dom));
    }

    @Override
    public CardEntity modCard(CardForm dom) {
        cardMapper.updateCard(dom.getEntity());
        return cardMapper.selectCard(new CardSearch(dom));
    }

    @Override
    public void delCard(CardForm dom) {
        cardMapper.deleteCard(dom.getEntity());
        return;
    }

    @Override
    public void allDelCard(CardForm dom) {
        cardMapper.deleteAllCard(dom.getEntity());
        return;
    }

    @Override
    public CardEntity getCard(CardSearch dom) {
        return cardMapper.selectCard(dom);
    }

    @Override
    public ResultListDto<CardEntity> getCardList(CardSearch dom) {
        ResultListDto<CardEntity> result = new ResultListDto<>();
        Long totalCnt = cardMapper.selectCardListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<CardEntity> list = cardMapper.selectCardList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
