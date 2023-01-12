package com.kpcnc.mydataapi.api.load.card.service;

import com.kpcnc.mydataapi.api.load.card.models.CardPaySearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardPayEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardPayForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface CardPayService{
    public CardPayEntity regCardPay(CardPayForm dom);

    public CardPayEntity modCardPay(CardPayForm dom);

    public void  delCardPay(CardPayForm dom);

    public CardPayEntity getCardPay(CardPaySearch dom);

    public ResultListDto<CardPayEntity> getCardPayList(CardPaySearch dom);
}
