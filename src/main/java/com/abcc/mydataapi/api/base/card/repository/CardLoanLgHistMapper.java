package com.abcc.mydataapi.api.base.card.repository;

import com.abcc.mydataapi.api.base.card.models.CardLoanLgHistSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardLoanLgHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardLoanLgHistMapper{
    int insertCardLoanLgHist(CardLoanLgHistEntity dom);

    int updateCardLoanLgHist(CardLoanLgHistEntity dom);

    int deleteCardLoanLgHist(CardLoanLgHistEntity dom);

    CardLoanLgHistEntity selectCardLoanLgHist(CardLoanLgHistSearch dom);

    CardLoanLgHistEntity selectCardLoanLgHistLast(CardLoanLgHistSearch dom);

    Long selectCardLoanLgHistListTotalCnt(CardLoanLgHistSearch dom);

    List<CardLoanLgHistEntity> selectCardLoanLgHistList(CardLoanLgHistSearch dom);
}
