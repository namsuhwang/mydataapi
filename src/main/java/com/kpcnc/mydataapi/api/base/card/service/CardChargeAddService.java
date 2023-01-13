package com.kpcnc.mydataapi.api.base.card.service;

import com.kpcnc.mydataapi.api.base.card.models.CardChargeAddSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardChargeAddEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardChargeAddForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface CardChargeAddService{
    public CardChargeAddEntity regCardChargeAdd(CardChargeAddForm dom);

    public CardChargeAddEntity modCardChargeAdd(CardChargeAddForm dom);

    public void  delCardChargeAdd(CardChargeAddForm dom);

    public CardChargeAddEntity getCardChargeAdd(CardChargeAddSearch dom);

    public ResultListDto<CardChargeAddEntity> getCardChargeAddList(CardChargeAddSearch dom);
}
