package com.abcc.mydataapi.api.base.card.repository;

import com.abcc.mydataapi.api.base.card.models.CardChargeAddSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardChargeAddEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardChargeAddMapper{
    int insertCardChargeAdd(CardChargeAddEntity dom);

    int updateCardChargeAdd(CardChargeAddEntity dom);

    int deleteCardChargeAdd(CardChargeAddEntity dom);

    CardChargeAddEntity selectCardChargeAdd(CardChargeAddSearch dom);

    CardChargeAddEntity selectCardChargeAddLast(CardChargeAddSearch dom);

    Long selectCardChargeAddListTotalCnt(CardChargeAddSearch dom);

    List<CardChargeAddEntity> selectCardChargeAddList(CardChargeAddSearch dom);
}
