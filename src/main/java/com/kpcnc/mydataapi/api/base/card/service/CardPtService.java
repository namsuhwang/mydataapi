package com.kpcnc.mydataapi.api.base.card.service;

import com.kpcnc.mydataapi.api.base.card.models.CardPtSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardPtEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardPtForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface CardPtService{
    public CardPtEntity regCardPt(CardPtForm dom);

    public CardPtEntity modCardPt(CardPtForm dom);

    public void  delCardPt(CardPtForm dom);

    public void  allDelCardPt(CardPtForm dom);

    public CardPtEntity getCardPt(CardPtSearch dom);

    public ResultListDto<CardPtEntity> getCardPtList(CardPtSearch dom);
}
