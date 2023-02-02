package com.abcc.mydataapi.api.base.card.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.card.models.CardLoanLgSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardLoanLgEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardLoanLgForm;
import com.abcc.mydataapi.api.base.card.repository.CardLoanLgMapper;
import com.abcc.mydataapi.api.base.card.service.CardLoanLgService;
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
    public void regCardLoanLg(CardLoanLgForm dom) {
        cardLoanLgMapper.insertCardLoanLg(dom.getEntity());
        return;
    }

    @Override
    public void updCardLoanLg(CardLoanLgForm dom) {
        cardLoanLgMapper.updateCardLoanLg(dom.getEntity());
        return;
    }

    @Override
    public void modCardLoanLg(CardLoanLgForm dom) {
        if(getCardLoanLg(new CardLoanLgSearch(dom)) == null){
            regCardLoanLg(dom);
        }else{
            updCardLoanLg(dom);
        }
        return;
    }

    @Override
    public void delCardLoanLg(CardLoanLgForm dom) {
        cardLoanLgMapper.deleteCardLoanLg(dom.getEntity());
        return;
    }

    @Override
    public void allDelCardLoanLg(CardLoanLgForm dom) {
        cardLoanLgMapper.deleteAllCardLoanLg(dom.getEntity());
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
