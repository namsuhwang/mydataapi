package com.kpcnc.mydataapi.api.base.card.service.impl;

import com.kpcnc.mydataapi.api.base.card.models.CardLoanStSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardLoanStEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardLoanStForm;
import com.kpcnc.mydataapi.api.base.card.repository.CardLoanStMapper;
import com.kpcnc.mydataapi.api.base.card.service.CardLoanStService;
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
    public void regCardLoanSt(CardLoanStForm dom) {
        cardLoanStMapper.insertCardLoanSt(dom.getEntity());
        return;
    }

    @Override
    public void updCardLoanSt(CardLoanStForm dom) {
        cardLoanStMapper.updateCardLoanSt(dom.getEntity());
        return;
    }

    @Override
    public void modCardLoanSt(CardLoanStForm dom) {
        if(getCardLoanSt(new CardLoanStSearch(dom)) == null){
            regCardLoanSt(dom);
        }else{
            updCardLoanSt(dom);
        }
        return;
    }

    @Override
    public void delCardLoanSt(CardLoanStForm dom) {
        cardLoanStMapper.deleteCardLoanSt(dom.getEntity());
        return;
    }

    @Override
    public void allDelCardLoanSt(CardLoanStForm dom) {
        cardLoanStMapper.deleteAllCardLoanSt(dom.getEntity());
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
