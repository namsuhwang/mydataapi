package com.albee.mydataapi.api.base.card.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.card.models.CardPtSearch;
import com.albee.mydataapi.api.base.card.models.entity.CardPtEntity;
import com.albee.mydataapi.api.base.card.models.form.CardPtForm;
import com.albee.mydataapi.api.base.card.repository.CardPtMapper;
import com.albee.mydataapi.api.base.card.service.CardPtService;
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
public class CardPtServiceImpl implements CardPtService {
    @Autowired
    CardPtMapper cardPtMapper;

    @Override
    public CardPtEntity regCardPt(CardPtForm dom) {
        cardPtMapper.insertCardPt(dom.getEntity());
        return cardPtMapper.selectCardPt(new CardPtSearch(dom));
    }

    @Override
    public CardPtEntity modCardPt(CardPtForm dom) {
        cardPtMapper.updateCardPt(dom.getEntity());
        return cardPtMapper.selectCardPt(new CardPtSearch(dom));
    }

    @Override
    public void delCardPt(CardPtForm dom) {
        cardPtMapper.deleteCardPt(dom.getEntity());
        return;
    }

    @Override
    public void allDelCardPt(CardPtForm dom) {
        cardPtMapper.deleteAllCardPt(dom.getEntity());
        return;
    }

    @Override
    public CardPtEntity getCardPt(CardPtSearch dom) {
        return cardPtMapper.selectCardPt(dom);
    }

    @Override
    public ResultListDto<CardPtEntity> getCardPtList(CardPtSearch dom) {
        ResultListDto<CardPtEntity> result = new ResultListDto<>();
        Long totalCnt = cardPtMapper.selectCardPtListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<CardPtEntity> list = cardPtMapper.selectCardPtList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
