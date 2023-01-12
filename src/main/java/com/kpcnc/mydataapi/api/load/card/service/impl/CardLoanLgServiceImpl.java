package com.kpcnc.mydataapi.api.load.card.service.impl;

import com.kpcnc.mydataapi.api.load.card.models.CardLoanLgSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardLoanLgEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardLoanLgForm;
import com.kpcnc.mydataapi.api.load.card.repository.CardLoanLgMapper;
import com.kpcnc.mydataapi.api.load.card.service.CardLoanLgService;
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
public class CardLoanLgServiceImpl implements CardLoanLgService {
    @Autowired
    CardLoanLgMapper cardLoanLgMapper;

    @Override
    public CardLoanLgEntity regCardLoanLg(CardLoanLgForm dom) {
        cardLoanLgMapper.insertCardLoanLg(dom.getEntity());
        return cardLoanLgMapper.selectCardLoanLg(new CardLoanLgSearch(dom));
    }

    @Override
    public CardLoanLgEntity modCardLoanLg(CardLoanLgForm dom) {
        cardLoanLgMapper.updateCardLoanLg(dom.getEntity());
        return cardLoanLgMapper.selectCardLoanLg(new CardLoanLgSearch(dom));
    }

    @Override
    public void delCardLoanLg(CardLoanLgForm dom) {
        cardLoanLgMapper.deleteCardLoanLg(dom.getEntity());
        return;
    }

    @Override
    public CardLoanLgEntity getCardLoanLg(CardLoanLgSearch dom) {
        return cardLoanLgMapper.selectCardLoanLg(dom);
    }

    @Override
    public ResultListDto<CardLoanLgEntity> getCardLoanLgList(CardLoanLgSearch dom) {
        ResultListDto<CardLoanLgEntity> result = new ResultListDto<>();
        Long totalCnt = cardLoanLgMapper.selectCardLoanLgListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<CardLoanLgEntity> list = cardLoanLgMapper.selectCardLoanLgList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
