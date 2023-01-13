package com.kpcnc.mydataapi.api.base.card.repository;

import com.kpcnc.mydataapi.api.base.card.models.CardChargeSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardChargeEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardChargeMapper{
    int insertCardCharge(CardChargeEntity dom);

    int updateCardCharge(CardChargeEntity dom);

    int deleteCardCharge(CardChargeEntity dom);

    CardChargeEntity selectCardCharge(CardChargeSearch dom);

    Long selectCardChargeListTotalCnt(CardChargeSearch dom);

    List<CardChargeEntity> selectCardChargeList(CardChargeSearch dom);
}
