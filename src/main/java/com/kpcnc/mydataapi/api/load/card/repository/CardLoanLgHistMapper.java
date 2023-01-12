package com.kpcnc.mydataapi.api.load.card.repository;

import com.kpcnc.mydataapi.api.load.card.models.CardLoanLgHistSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardLoanLgHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardLoanLgHistMapper{
    int insertCardLoanLgHist(CardLoanLgHistEntity dom);

    int updateCardLoanLgHist(CardLoanLgHistEntity dom);

    int deleteCardLoanLgHist(CardLoanLgHistEntity dom);

    CardLoanLgHistEntity selectCardLoanLgHist(CardLoanLgHistSearch dom);

    Long selectCardLoanLgHistListTotalCnt(CardLoanLgHistSearch dom);

    List<CardLoanLgHistEntity> selectCardLoanLgHistList(CardLoanLgHistSearch dom);
}
