package com.kpcnc.mydataapi.api.base.card.service;

import com.kpcnc.mydataapi.api.base.card.models.CardPaySearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardPayEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardPayForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface CardPayService{
    public CardPayEntity regCardPay(CardPayForm dom);

    public CardPayEntity modCardPay(CardPayForm dom);

    public void  delCardPay(CardPayForm dom);

    public CardPayEntity getCardPay(CardPaySearch dom);

    public ResultListDto<CardPayEntity> getCardPayList(CardPaySearch dom);
}
