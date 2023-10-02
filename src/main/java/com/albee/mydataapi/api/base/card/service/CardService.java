package com.albee.mydataapi.api.base.card.service;

import com.albee.mydataapi.api.base.card.models.CardSearch;
import com.albee.mydataapi.api.base.card.models.entity.CardEntity;
import com.albee.mydataapi.api.base.card.models.form.CardForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface CardService{
    public CardEntity regCard(CardForm dom);

    public CardEntity modCard(CardForm dom);

    public void  delCard(CardForm dom);

    public void  allDelCard(CardForm dom);

    public CardEntity getCard(CardSearch dom);

    public ResultListDto<CardEntity> getCardList(CardSearch dom);
}
