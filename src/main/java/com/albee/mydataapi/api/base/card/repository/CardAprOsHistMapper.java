package com.albee.mydataapi.api.base.card.repository;

import com.albee.mydataapi.api.base.card.models.CardAprOsHistSearch;
import com.albee.mydataapi.api.base.card.models.entity.CardAprOsHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardAprOsHistMapper{
    int insertCardAprOsHist(CardAprOsHistEntity dom);

    int updateCardAprOsHist(CardAprOsHistEntity dom);

    int deleteCardAprOsHist(CardAprOsHistEntity dom);

    CardAprOsHistEntity selectCardAprOsHist(CardAprOsHistSearch dom);

    CardAprOsHistEntity selectCardAprOsHistLast(CardAprOsHistSearch dom);

    Long selectCardAprOsHistListTotalCnt(CardAprOsHistSearch dom);

    List<CardAprOsHistEntity> selectCardAprOsHistList(CardAprOsHistSearch dom);
}
