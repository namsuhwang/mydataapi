package com.abcc.mydataapi.api.base.card.repository;

import com.abcc.mydataapi.api.base.card.models.CardPtSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardPtEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardPtMapper{
    int insertCardPt(CardPtEntity dom);

    int updateCardPt(CardPtEntity dom);

    int deleteCardPt(CardPtEntity dom);

    int deleteAllCardPt(CardPtEntity dom);

    CardPtEntity selectCardPt(CardPtSearch dom);

    CardPtEntity selectCardPtLast(CardPtSearch dom);

    Long selectCardPtListTotalCnt(CardPtSearch dom);

    List<CardPtEntity> selectCardPtList(CardPtSearch dom);
}
