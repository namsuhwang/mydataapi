package com.kpcnc.mydataapi.api.load.card.service;

import com.kpcnc.mydataapi.api.load.card.models.CardPayDetailSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardPayDetailEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardPayDetailForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface CardPayDetailService{
    public CardPayDetailEntity regCardPayDetail(CardPayDetailForm dom);

    public CardPayDetailEntity modCardPayDetail(CardPayDetailForm dom);

    public void  delCardPayDetail(CardPayDetailForm dom);

    public CardPayDetailEntity getCardPayDetail(CardPayDetailSearch dom);

    public ResultListDto<CardPayDetailEntity> getCardPayDetailList(CardPayDetailSearch dom);
}
