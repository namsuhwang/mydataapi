package com.kpcnc.mydataapi.api.load.card.repository;

import com.kpcnc.mydataapi.api.load.card.models.CardBaseSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardBaseEntity;
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
