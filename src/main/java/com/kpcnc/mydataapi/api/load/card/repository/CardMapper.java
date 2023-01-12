package com.kpcnc.mydataapi.api.load.card.repository;

import com.kpcnc.mydataapi.api.load.card.models.CardSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardMapper{
    int insertCard(CardEntity dom);

    int updateCard(CardEntity dom);

    int deleteCard(CardEntity dom);

    CardEntity selectCard(CardSearch dom);

    Long selectCardListTotalCnt(CardSearch dom);

    List<CardEntity> selectCardList(CardSearch dom);
}
