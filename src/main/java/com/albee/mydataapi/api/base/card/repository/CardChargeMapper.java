package com.albee.mydataapi.api.base.card.repository;

import com.albee.mydataapi.api.base.card.models.CardChargeSearch;
import com.albee.mydataapi.api.base.card.models.entity.CardChargeEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardChargeMapper{
    int insertCardCharge(CardChargeEntity dom);

    int updateCardCharge(CardChargeEntity dom);

    int deleteCardCharge(CardChargeEntity dom);

    CardChargeEntity selectCardCharge(CardChargeSearch dom);

    CardChargeEntity selectCardChargeLast(CardChargeSearch dom);

    Long selectCardChargeListTotalCnt(CardChargeSearch dom);

    List<CardChargeEntity> selectCardChargeList(CardChargeSearch dom);
}
