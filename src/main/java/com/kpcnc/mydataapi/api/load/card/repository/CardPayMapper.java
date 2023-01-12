package com.kpcnc.mydataapi.api.load.card.repository;

import com.kpcnc.mydataapi.api.load.card.models.CardPaySearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardPayEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardPayMapper{
    int insertCardPay(CardPayEntity dom);

    int updateCardPay(CardPayEntity dom);

    int deleteCardPay(CardPayEntity dom);

    CardPayEntity selectCardPay(CardPaySearch dom);

    Long selectCardPayListTotalCnt(CardPaySearch dom);

    List<CardPayEntity> selectCardPayList(CardPaySearch dom);
}
