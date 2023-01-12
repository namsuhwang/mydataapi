package com.kpcnc.mydataapi.api.load.card.service.impl;

import com.kpcnc.mydataapi.api.load.card.models.CardLoanSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardLoanEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardLoanForm;
import com.kpcnc.mydataapi.api.load.card.repository.CardLoanMapper;
import com.kpcnc.mydataapi.api.load.card.service.CardLoanService;
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
public class CardLoanServiceImpl implements CardLoanService {
    @Autowired
    CardLoanMapper cardLoanMapper;

    @Override
    public CardLoanEntity regCardLoan(CardLoanForm dom) {
        cardLoanMapper.insertCardLoan(dom.getEntity());
        return cardLoanMapper.selectCardLoan(new CardLoanSearch(dom));
    }

    @Override
    public CardLoanEntity modCardLoan(CardLoanForm dom) {
        cardLoanMapper.updateCardLoan(dom.getEntity());
        return cardLoanMapper.selectCardLoan(new CardLoanSearch(dom));
    }

    @Override
    public void delCardLoan(CardLoanForm dom) {
        cardLoanMapper.deleteCardLoan(dom.getEntity());
        return;
    }

    @Override
    public CardLoanEntity getCardLoan(CardLoanSearch dom) {
        return cardLoanMapper.selectCardLoan(dom);
    }

    @Override
    public ResultListDto<CardLoanEntity> getCardLoanList(CardLoanSearch dom) {
        ResultListDto<CardLoanEntity> result = new ResultListDto<>();
        Long totalCnt = cardLoanMapper.selectCardLoanListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<CardLoanEntity> list = cardLoanMapper.selectCardLoanList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
