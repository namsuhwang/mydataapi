package com.abcc.mydataapi.api.base.card.repository;

import com.abcc.mydataapi.api.base.card.models.CardBaseSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardBaseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardBaseMapper{
    int insertCardBase(CardBaseEntity dom);

    int updateCardBase(CardBaseEntity dom);

    int deleteCardBase(CardBaseEntity dom);

    CardBaseEntity selectCardBase(CardBaseSearch dom);

    Long selectCardBaseListTotalCnt(CardBaseSearch dom);

    List<CardBaseEntity> selectCardBaseList(CardBaseSearch dom);
}
