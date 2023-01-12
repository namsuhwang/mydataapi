package com.kpcnc.mydataapi.api.load.card.service.impl;

import com.kpcnc.mydataapi.api.load.card.models.CardLoanLgHistSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardLoanLgHistEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardLoanLgHistForm;
import com.kpcnc.mydataapi.api.load.card.repository.CardLoanLgHistMapper;
import com.kpcnc.mydataapi.api.load.card.service.CardLoanLgHistService;
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
public class CardLoanLgHistServiceImpl implements CardLoanLgHistService {
    @Autowired
    CardLoanLgHistMapper cardLoanLgHistMapper;

    @Override
    public CardLoanLgHistEntity regCardLoanLgHist(CardLoanLgHistForm dom) {
        cardLoanLgHistMapper.insertCardLoanLgHist(dom.getEntity());
        return cardLoanLgHistMapper.selectCardLoanLgHist(new CardLoanLgHistSearch(dom));
    }

    @Override
    public CardLoanLgHistEntity modCardLoanLgHist(CardLoanLgHistForm dom) {
        cardLoanLgHistMapper.updateCardLoanLgHist(dom.getEntity());
        return cardLoanLgHistMapper.selectCardLoanLgHist(new CardLoanLgHistSearch(dom));
    }

    @Override
    public void delCardLoanLgHist(CardLoanLgHistForm dom) {
        cardLoanLgHistMapper.deleteCardLoanLgHist(dom.getEntity());
        return;
    }

    @Override
    public CardLoanLgHistEntity getCardLoanLgHist(CardLoanLgHistSearch dom) {
        return cardLoanLgHistMapper.selectCardLoanLgHist(dom);
    }

    @Override
    public ResultListDto<CardLoanLgHistEntity> getCardLoanLgHistList(CardLoanLgHistSearch dom) {
        ResultListDto<CardLoanLgHistEntity> result = new ResultListDto<>();
        Long totalCnt = cardLoanLgHistMapper.selectCardLoanLgHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<CardLoanLgHistEntity> list = cardLoanLgHistMapper.selectCardLoanLgHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
