package com.abcc.mydataapi.api.base.card.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.card.models.CardPaySearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardPayEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardPayForm;
import com.abcc.mydataapi.api.base.card.repository.CardPayMapper;
import com.abcc.mydataapi.api.base.card.service.CardPayService;
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
public class CardPayServiceImpl implements CardPayService {
    @Autowired
    CardPayMapper cardPayMapper;

    @Override
    public CardPayEntity regCardPay(CardPayForm dom) {
        cardPayMapper.insertCardPay(dom.getEntity());
        return cardPayMapper.selectCardPay(new CardPaySearch(dom));
    }

    @Override
    public CardPayEntity modCardPay(CardPayForm dom) {
        cardPayMapper.updateCardPay(dom.getEntity());
        return cardPayMapper.selectCardPay(new CardPaySearch(dom));
    }

    @Override
    public void delCardPay(CardPayForm dom) {
        cardPayMapper.deleteCardPay(dom.getEntity());
        return;
    }

    @Override
    public CardPayEntity getCardPay(CardPaySearch dom) {
        return cardPayMapper.selectCardPay(dom);
    }

    @Override
    public ResultListDto<CardPayEntity> getCardPayList(CardPaySearch dom) {
        ResultListDto<CardPayEntity> result = new ResultListDto<>();
        Long totalCnt = cardPayMapper.selectCardPayListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<CardPayEntity> list = cardPayMapper.selectCardPayList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
