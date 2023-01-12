package com.kpcnc.mydataapi.api.load.card.repository;

import com.kpcnc.mydataapi.api.load.card.models.CardChargeAddSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardChargeAddEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardChargeAddMapper{
    int insertCardChargeAdd(CardChargeAddEntity dom);

    int updateCardChargeAdd(CardChargeAddEntity dom);

    int deleteCardChargeAdd(CardChargeAddEntity dom);

    CardChargeAddEntity selectCardChargeAdd(CardChargeAddSearch dom);

    Long selectCardChargeAddListTotalCnt(CardChargeAddSearch dom);

    List<CardChargeAddEntity> selectCardChargeAddList(CardChargeAddSearch dom);
}
