package com.kpcnc.mydataapi.api.load.card.service;

import com.kpcnc.mydataapi.api.load.card.models.CardChargeAddSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardChargeAddEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardChargeAddForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface CardChargeAddService{
    public CardChargeAddEntity regCardChargeAdd(CardChargeAddForm dom);

    public CardChargeAddEntity modCardChargeAdd(CardChargeAddForm dom);

    public void  delCardChargeAdd(CardChargeAddForm dom);

    public CardChargeAddEntity getCardChargeAdd(CardChargeAddSearch dom);

    public ResultListDto<CardChargeAddEntity> getCardChargeAddList(CardChargeAddSearch dom);
}
