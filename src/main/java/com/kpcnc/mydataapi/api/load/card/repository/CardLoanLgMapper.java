package com.kpcnc.mydataapi.api.load.card.repository;

import com.kpcnc.mydataapi.api.load.card.models.CardLoanLgSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardLoanLgEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardLoanLgMapper{
    int insertCardLoanLg(CardLoanLgEntity dom);

    int updateCardLoanLg(CardLoanLgEntity dom);

    int deleteCardLoanLg(CardLoanLgEntity dom);

    CardLoanLgEntity selectCardLoanLg(CardLoanLgSearch dom);

    Long selectCardLoanLgListTotalCnt(CardLoanLgSearch dom);

    List<CardLoanLgEntity> selectCardLoanLgList(CardLoanLgSearch dom);
}
