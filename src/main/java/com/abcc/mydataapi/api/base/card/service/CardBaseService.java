package com.abcc.mydataapi.api.base.card.service;

import com.abcc.mydataapi.api.base.card.models.CardBaseSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardBaseEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardBaseForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface CardBaseService{
    public CardBaseEntity regCardBase(CardBaseForm dom);

    public CardBaseEntity modCardBase(CardBaseForm dom);

    public void  delCardBase(CardBaseForm dom);

    public CardBaseEntity getCardBase(CardBaseSearch dom);

    public ResultListDto<CardBaseEntity> getCardBaseList(CardBaseSearch dom);
}
