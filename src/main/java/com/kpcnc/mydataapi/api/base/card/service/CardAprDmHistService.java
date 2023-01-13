package com.kpcnc.mydataapi.api.base.card.service;

import com.kpcnc.mydataapi.api.base.card.models.CardAprDmHistSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardAprDmHistEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardAprDmHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface CardAprDmHistService{
    public CardAprDmHistEntity regCardAprDmHist(CardAprDmHistForm dom);

    public CardAprDmHistEntity modCardAprDmHist(CardAprDmHistForm dom);

    public void  delCardAprDmHist(CardAprDmHistForm dom);

    public CardAprDmHistEntity getCardAprDmHist(CardAprDmHistSearch dom);

    public ResultListDto<CardAprDmHistEntity> getCardAprDmHistList(CardAprDmHistSearch dom);
}