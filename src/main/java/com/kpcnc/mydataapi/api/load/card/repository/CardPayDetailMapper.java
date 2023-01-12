package com.kpcnc.mydataapi.api.load.card.repository;

import com.kpcnc.mydataapi.api.load.card.models.CardPayDetailSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardPayDetailEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardPayDetailMapper{
    int insertCardPayDetail(CardPayDetailEntity dom);

    int updateCardPayDetail(CardPayDetailEntity dom);

    int deleteCardPayDetail(CardPayDetailEntity dom);

    CardPayDetailEntity selectCardPayDetail(CardPayDetailSearch dom);

    Long selectCardPayDetailListTotalCnt(CardPayDetailSearch dom);

    List<CardPayDetailEntity> selectCardPayDetailList(CardPayDetailSearch dom);
}
