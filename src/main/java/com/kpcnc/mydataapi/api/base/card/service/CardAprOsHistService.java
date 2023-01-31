package com.kpcnc.mydataapi.api.base.card.service;

import com.kpcnc.mydataapi.api.base.card.models.CardAprOsHistSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardAprOsHistEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardAprOsHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface CardAprOsHistService{
    public void regCardAprOsHist(CardAprOsHistForm dom);

    public void updCardAprOsHist(CardAprOsHistForm dom);

    public void modCardAprOsHist(CardAprOsHistForm dom);

    public void  delCardAprOsHist(CardAprOsHistForm dom);

    public CardAprOsHistEntity getCardAprOsHist(CardAprOsHistSearch dom);

    public CardAprOsHistEntity getCardAprOsHistLast(CardAprOsHistSearch dom);

    public ResultListDto<CardAprOsHistEntity> getCardAprOsHistList(CardAprOsHistSearch dom);
}
