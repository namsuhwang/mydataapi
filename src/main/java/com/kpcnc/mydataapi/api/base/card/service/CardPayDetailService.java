package com.kpcnc.mydataapi.api.base.card.service;

import com.kpcnc.mydataapi.api.base.card.models.CardPayDetailSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardPayDetailEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardPayDetailForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface CardPayDetailService{
    public CardPayDetailEntity regCardPayDetail(CardPayDetailForm dom);

    public CardPayDetailEntity modCardPayDetail(CardPayDetailForm dom);

    public void  delCardPayDetail(CardPayDetailForm dom);

    public CardPayDetailEntity getCardPayDetail(CardPayDetailSearch dom);

    public ResultListDto<CardPayDetailEntity> getCardPayDetailList(CardPayDetailSearch dom);
}
