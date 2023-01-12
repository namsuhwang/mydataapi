package com.kpcnc.mydataapi.api.load.card.service.impl;

import com.kpcnc.mydataapi.api.load.card.models.CardLoanStSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardLoanStEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardLoanStForm;
import com.kpcnc.mydataapi.api.load.card.repository.CardLoanStMapper;
import com.kpcnc.mydataapi.api.load.card.service.CardLoanStService;
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
public class CardLoanStServiceImpl implements CardLoanStService {
    @Autowired
    CardLoanStMapper cardLoanStMapper;

    @Override
    public CardLoanStEntity regCardLoanSt(CardLoanStForm dom) {
        cardLoanStMapper.insertCardLoanSt(dom.getEntity());
        return cardLoanStMapper.selectCardLoanSt(new CardLoanStSearch(dom));
    }

    @Override
    public CardLoanStEntity modCardLoanSt(CardLoanStForm dom) {
        cardLoanStMapper.updateCardLoanSt(dom.getEntity());
        return cardLoanStMapper.selectCardLoanSt(new CardLoanStSearch(dom));
    }

    @Override
    public void delCardLoanSt(CardLoanStForm dom) {
        cardLoanStMapper.deleteCardLoanSt(dom.getEntity());
        return;
    }

    @Override
    public CardLoanStEntity getCardLoanSt(CardLoanStSearch dom) {
        return cardLoanStMapper.selectCardLoanSt(dom);
    }

    @Override
    public ResultListDto<CardLoanStEntity> getCardLoanStList(CardLoanStSearch dom) {
        ResultListDto<CardLoanStEntity> result = new ResultListDto<>();
        Long totalCnt = cardLoanStMapper.selectCardLoanStListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<CardLoanStEntity> list = cardLoanStMapper.selectCardLoanStList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
