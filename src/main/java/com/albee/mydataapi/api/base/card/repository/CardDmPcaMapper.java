package com.albee.mydataapi.api.base.card.repository;

import com.albee.mydataapi.api.base.card.models.CardDmPcaSearch;
import com.albee.mydataapi.api.base.card.models.entity.CardDmPcaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardDmPcaMapper{
    int insertCardDmPca(CardDmPcaEntity dom);

    int updateCardDmPca(CardDmPcaEntity dom);

    int deleteCardDmPca(CardDmPcaEntity dom);

    CardDmPcaEntity selectCardDmPca(CardDmPcaSearch dom);

    CardDmPcaEntity selectCardDmPcaLast(CardDmPcaSearch dom);

    Long selectCardDmPcaListTotalCnt(CardDmPcaSearch dom);

    List<CardDmPcaEntity> selectCardDmPcaList(CardDmPcaSearch dom);
}
