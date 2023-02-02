package com.abcc.mydataapi.api.base.card.service;

import com.abcc.mydataapi.api.base.card.models.CardPayDetailSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardPayDetailEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardPayDetailForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface CardPayDetailService{
    public void regCardPayDetail(CardPayDetailForm dom);

    public void updCardPayDetail(CardPayDetailForm dom);

    public void modCardPayDetail(CardPayDetailForm dom);

    public void  delCardPayDetail(CardPayDetailForm dom);

    public void  allDelCardPayDetail(CardPayDetailForm dom);

    public CardPayDetailEntity getCardPayDetail(CardPayDetailSearch dom);

    public ResultListDto<CardPayDetailEntity> getCardPayDetailList(CardPayDetailSearch dom);
}
