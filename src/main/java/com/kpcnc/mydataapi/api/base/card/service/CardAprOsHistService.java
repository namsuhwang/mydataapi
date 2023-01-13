package com.kpcnc.mydataapi.api.base.card.service;

import com.kpcnc.mydataapi.api.base.card.models.CardAprOsHistSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardAprOsHistEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardAprOsHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface CardAprOsHistService{
    public CardAprOsHistEntity regCardAprOsHist(CardAprOsHistForm dom);

    public CardAprOsHistEntity modCardAprOsHist(CardAprOsHistForm dom);

    public void  delCardAprOsHist(CardAprOsHistForm dom);

    public CardAprOsHistEntity getCardAprOsHist(CardAprOsHistSearch dom);

    public ResultListDto<CardAprOsHistEntity> getCardAprOsHistList(CardAprOsHistSearch dom);
}
