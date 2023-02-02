package com.abcc.mydataapi.api.base.card.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.card.models.CardAprDmHistSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardAprDmHistEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardAprDmHistForm;
import com.abcc.mydataapi.api.base.card.repository.CardAprDmHistMapper;
import com.abcc.mydataapi.api.base.card.service.CardAprDmHistService;
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
public class CardAprDmHistServiceImpl implements CardAprDmHistService {
    @Autowired
    CardAprDmHistMapper cardAprDmHistMapper;

    @Override
    public void regCardAprDmHist(CardAprDmHistForm dom) {
        cardAprDmHistMapper.insertCardAprDmHist(dom.getEntity());
        return;
    }

    @Override
    public void updCardAprDmHist(CardAprDmHistForm dom) {
        cardAprDmHistMapper.updateCardAprDmHist(dom.getEntity());
        return;
    }

    @Override
    public void modCardAprDmHist(CardAprDmHistForm dom) {
        if(getCardAprDmHist(new CardAprDmHistSearch(dom)) == null){
            regCardAprDmHist(dom);
        }else{
            updCardAprDmHist(dom);
        }
        return;
    }

    @Override
    public void delCardAprDmHist(CardAprDmHistForm dom) {
        cardAprDmHistMapper.deleteCardAprDmHist(dom.getEntity());
        return;
    }

    @Override
    public CardAprDmHistEntity getCardAprDmHist(CardAprDmHistSearch dom) {
        return cardAprDmHistMapper.selectCardAprDmHist(dom);
    }

    @Override
    public CardAprDmHistEntity getCardAprDmHistLast(CardAprDmHistSearch dom) {
        return cardAprDmHistMapper.selectCardAprDmHistLast(dom);
    }


    @Override
    public ResultListDto<CardAprDmHistEntity> getCardAprDmHistList(CardAprDmHistSearch dom) {
        ResultListDto<CardAprDmHistEntity> result = new ResultListDto<>();
        Long totalCnt = cardAprDmHistMapper.selectCardAprDmHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<CardAprDmHistEntity> list = cardAprDmHistMapper.selectCardAprDmHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
