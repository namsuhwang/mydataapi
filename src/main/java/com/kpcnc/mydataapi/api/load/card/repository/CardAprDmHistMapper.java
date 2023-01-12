package com.kpcnc.mydataapi.api.load.card.repository;

import com.kpcnc.mydataapi.api.load.card.models.CardAprDmHistSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardAprDmHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardAprDmHistMapper{
    int insertCardAprDmHist(CardAprDmHistEntity dom);

    int updateCardAprDmHist(CardAprDmHistEntity dom);

    int deleteCardAprDmHist(CardAprDmHistEntity dom);

    CardAprDmHistEntity selectCardAprDmHist(CardAprDmHistSearch dom);

    Long selectCardAprDmHistListTotalCnt(CardAprDmHistSearch dom);

    List<CardAprDmHistEntity> selectCardAprDmHistList(CardAprDmHistSearch dom);
}
