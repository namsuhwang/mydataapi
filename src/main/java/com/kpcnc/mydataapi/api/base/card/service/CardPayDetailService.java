package com.kpcnc.mydataapi.api.base.card.service;

import com.kpcnc.mydataapi.api.base.card.models.CardPayDetailSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardPayDetailEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardPayDetailForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface CardPayDetailService{
    public void regCardPayDetail(CardPayDetailForm dom);

    public void updCardPayDetail(CardPayDetailForm dom);

    public void modCardPayDetail(CardPayDetailForm dom);

    public void  delCardPayDetail(CardPayDetailForm dom);

    public void  allDelCardPayDetail(CardPayDetailForm dom);

    public CardPayDetailEntity getCardPayDetail(CardPayDetailSearch dom);

    public ResultListDto<CardPayDetailEntity> getCardPayDetailList(CardPayDetailSearch dom);
}
