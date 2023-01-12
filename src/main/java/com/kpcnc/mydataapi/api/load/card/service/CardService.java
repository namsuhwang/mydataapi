package com.kpcnc.mydataapi.api.load.card.service;

import com.kpcnc.mydataapi.api.load.card.models.CardSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface CardService{
    public CardEntity regCard(CardForm dom);

    public CardEntity modCard(CardForm dom);

    public void  delCard(CardForm dom);

    public CardEntity getCard(CardSearch dom);

    public ResultListDto<CardEntity> getCardList(CardSearch dom);
}
