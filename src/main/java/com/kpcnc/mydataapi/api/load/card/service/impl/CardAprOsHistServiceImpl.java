package com.kpcnc.mydataapi.api.load.card.service.impl;

import com.kpcnc.mydataapi.api.load.card.models.CardAprOsHistSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardAprOsHistEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardAprOsHistForm;
import com.kpcnc.mydataapi.api.load.card.repository.CardAprOsHistMapper;
import com.kpcnc.mydataapi.api.load.card.service.CardAprOsHistService;
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
public class CardAprOsHistServiceImpl implements CardAprOsHistService {
    @Autowired
    CardAprOsHistMapper cardAprOsHistMapper;

    @Override
    public CardAprOsHistEntity regCardAprOsHist(CardAprOsHistForm dom) {
        cardAprOsHistMapper.insertCardAprOsHist(dom.getEntity());
        return cardAprOsHistMapper.selectCardAprOsHist(new CardAprOsHistSearch(dom));
    }

    @Override
    public CardAprOsHistEntity modCardAprOsHist(CardAprOsHistForm dom) {
        cardAprOsHistMapper.updateCardAprOsHist(dom.getEntity());
        return cardAprOsHistMapper.selectCardAprOsHist(new CardAprOsHistSearch(dom));
    }

    @Override
    public void delCardAprOsHist(CardAprOsHistForm dom) {
        cardAprOsHistMapper.deleteCardAprOsHist(dom.getEntity());
        return;
    }

    @Override
    public CardAprOsHistEntity getCardAprOsHist(CardAprOsHistSearch dom) {
        return cardAprOsHistMapper.selectCardAprOsHist(dom);
    }

    @Override
    public ResultListDto<CardAprOsHistEntity> getCardAprOsHistList(CardAprOsHistSearch dom) {
        ResultListDto<CardAprOsHistEntity> result = new ResultListDto<>();
        Long totalCnt = cardAprOsHistMapper.selectCardAprOsHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<CardAprOsHistEntity> list = cardAprOsHistMapper.selectCardAprOsHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
