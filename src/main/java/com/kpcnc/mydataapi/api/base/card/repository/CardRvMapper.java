package com.kpcnc.mydataapi.api.base.card.repository;

import com.kpcnc.mydataapi.api.base.card.models.CardRvSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardRvEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardRvMapper{
    int insertCardRv(CardRvEntity dom);

    int updateCardRv(CardRvEntity dom);

    int deleteCardRv(CardRvEntity dom);

    CardRvEntity selectCardRv(CardRvSearch dom);

    Long selectCardRvListTotalCnt(CardRvSearch dom);

    List<CardRvEntity> selectCardRvList(CardRvSearch dom);
}
