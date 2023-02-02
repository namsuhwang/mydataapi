package com.abcc.mydataapi.api.base.card.repository;

import com.abcc.mydataapi.api.base.card.models.CardAprDmHistSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardAprDmHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardAprDmHistMapper{
    int insertCardAprDmHist(CardAprDmHistEntity dom);

    int updateCardAprDmHist(CardAprDmHistEntity dom);

    int deleteCardAprDmHist(CardAprDmHistEntity dom);

    CardAprDmHistEntity selectCardAprDmHist(CardAprDmHistSearch dom);

    CardAprDmHistEntity selectCardAprDmHistLast(CardAprDmHistSearch dom);

    Long selectCardAprDmHistListTotalCnt(CardAprDmHistSearch dom);

    List<CardAprDmHistEntity> selectCardAprDmHistList(CardAprDmHistSearch dom);
}
