package com.kpcnc.mydataapi.api.load.card.service;

import com.kpcnc.mydataapi.api.load.card.models.CardAprOsHistSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardAprOsHistEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardAprOsHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface CardAprOsHistService{
    public CardAprOsHistEntity regCardAprOsHist(CardAprOsHistForm dom);

    public CardAprOsHistEntity modCardAprOsHist(CardAprOsHistForm dom);

    public void  delCardAprOsHist(CardAprOsHistForm dom);

    public CardAprOsHistEntity getCardAprOsHist(CardAprOsHistSearch dom);

    public ResultListDto<CardAprOsHistEntity> getCardAprOsHistList(CardAprOsHistSearch dom);
}
