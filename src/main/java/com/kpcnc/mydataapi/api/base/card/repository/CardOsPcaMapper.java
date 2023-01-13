package com.kpcnc.mydataapi.api.base.card.repository;

import com.kpcnc.mydataapi.api.base.card.models.CardOsPcaSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardOsPcaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardOsPcaMapper{
    int insertCardOsPca(CardOsPcaEntity dom);

    int updateCardOsPca(CardOsPcaEntity dom);

    int deleteCardOsPca(CardOsPcaEntity dom);

    CardOsPcaEntity selectCardOsPca(CardOsPcaSearch dom);

    Long selectCardOsPcaListTotalCnt(CardOsPcaSearch dom);

    List<CardOsPcaEntity> selectCardOsPcaList(CardOsPcaSearch dom);
}
