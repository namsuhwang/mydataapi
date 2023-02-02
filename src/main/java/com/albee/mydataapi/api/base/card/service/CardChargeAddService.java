package com.albee.mydataapi.api.base.card.service;

import com.albee.mydataapi.api.base.card.models.CardChargeAddSearch;
import com.albee.mydataapi.api.base.card.models.entity.CardChargeAddEntity;
import com.albee.mydataapi.api.base.card.models.form.CardChargeAddForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface CardChargeAddService{
    public void regCardChargeAdd(CardChargeAddForm dom);

    public void updCardChargeAdd(CardChargeAddForm dom);

    public void modCardChargeAdd(CardChargeAddForm dom);

    public void  delCardChargeAdd(CardChargeAddForm dom);

    public CardChargeAddEntity getCardChargeAdd(CardChargeAddSearch dom);

    public CardChargeAddEntity getCardChargeAddLast(CardChargeAddSearch dom);

    public ResultListDto<CardChargeAddEntity> getCardChargeAddList(CardChargeAddSearch dom);
}
