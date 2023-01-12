package com.kpcnc.mydataapi.api.load.card.service.impl;

import com.kpcnc.mydataapi.api.load.card.models.CardPayDetailSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardPayDetailEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardPayDetailForm;
import com.kpcnc.mydataapi.api.load.card.repository.CardPayDetailMapper;
import com.kpcnc.mydataapi.api.load.card.service.CardPayDetailService;
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
public class CardPayDetailServiceImpl implements CardPayDetailService {
    @Autowired
    CardPayDetailMapper cardPayDetailMapper;

    @Override
    public CardPayDetailEntity regCardPayDetail(CardPayDetailForm dom) {
        cardPayDetailMapper.insertCardPayDetail(dom.getEntity());
        return cardPayDetailMapper.selectCardPayDetail(new CardPayDetailSearch(dom));
    }

    @Override
    public CardPayDetailEntity modCardPayDetail(CardPayDetailForm dom) {
        cardPayDetailMapper.updateCardPayDetail(dom.getEntity());
        return cardPayDetailMapper.selectCardPayDetail(new CardPayDetailSearch(dom));
    }

    @Override
    public void delCardPayDetail(CardPayDetailForm dom) {
        cardPayDetailMapper.deleteCardPayDetail(dom.getEntity());
        return;
    }

    @Override
    public CardPayDetailEntity getCardPayDetail(CardPayDetailSearch dom) {
        return cardPayDetailMapper.selectCardPayDetail(dom);
    }

    @Override
    public ResultListDto<CardPayDetailEntity> getCardPayDetailList(CardPayDetailSearch dom) {
        ResultListDto<CardPayDetailEntity> result = new ResultListDto<>();
        Long totalCnt = cardPayDetailMapper.selectCardPayDetailListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<CardPayDetailEntity> list = cardPayDetailMapper.selectCardPayDetailList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
