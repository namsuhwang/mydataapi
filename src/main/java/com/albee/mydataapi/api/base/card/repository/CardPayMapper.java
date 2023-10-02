package com.albee.mydataapi.api.base.card.repository;

import com.albee.mydataapi.api.base.card.models.CardPaySearch;
import com.albee.mydataapi.api.base.card.models.entity.CardPayEntity;
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
