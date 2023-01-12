package com.kpcnc.mydataapi.api.load.card.service;

import com.kpcnc.mydataapi.api.load.card.models.CardBaseSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardBaseEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardBaseForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface CardBaseService{
    public CardBaseEntity regCardBase(CardBaseForm dom);

    public CardBaseEntity modCardBase(CardBaseForm dom);

    public void  delCardBase(CardBaseForm dom);

    public CardBaseEntity getCardBase(CardBaseSearch dom);

    public ResultListDto<CardBaseEntity> getCardBaseList(CardBaseSearch dom);
}
