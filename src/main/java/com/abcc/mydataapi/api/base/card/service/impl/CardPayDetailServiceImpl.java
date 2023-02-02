package com.abcc.mydataapi.api.base.card.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.card.models.CardPayDetailSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardPayDetailEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardPayDetailForm;
import com.abcc.mydataapi.api.base.card.repository.CardPayDetailMapper;
import com.abcc.mydataapi.api.base.card.service.CardPayDetailService;
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
    public void regCardPayDetail(CardPayDetailForm dom) {
        cardPayDetailMapper.insertCardPayDetail(dom.getEntity());
        return;
    }

    @Override
    public void updCardPayDetail(CardPayDetailForm dom) {
        cardPayDetailMapper.updateCardPayDetail(dom.getEntity());
        return;
    }

    @Override
    public void modCardPayDetail(CardPayDetailForm dom) {
        if(getCardPayDetail(new CardPayDetailSearch(dom)) == null){
            regCardPayDetail(dom);
        }else{
            updCardPayDetail(dom);
        }
        return;
    }

    @Override
    public void delCardPayDetail(CardPayDetailForm dom) {
        cardPayDetailMapper.deleteCardPayDetail(dom.getEntity());
        return;
    }

    @Override
    public void allDelCardPayDetail(CardPayDetailForm dom) {
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
