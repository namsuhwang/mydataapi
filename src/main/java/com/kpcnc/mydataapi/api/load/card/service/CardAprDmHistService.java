package com.kpcnc.mydataapi.api.load.card.service;

import com.kpcnc.mydataapi.api.load.card.models.CardAprDmHistSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardAprDmHistEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardAprDmHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface CardAprDmHistService{
    public CardAprDmHistEntity regCardAprDmHist(CardAprDmHistForm dom);

    public CardAprDmHistEntity modCardAprDmHist(CardAprDmHistForm dom);

    public void  delCardAprDmHist(CardAprDmHistForm dom);

    public CardAprDmHistEntity getCardAprDmHist(CardAprDmHistSearch dom);

    public ResultListDto<CardAprDmHistEntity> getCardAprDmHistList(CardAprDmHistSearch dom);
}
