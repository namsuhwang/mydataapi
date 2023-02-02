package com.abcc.mydataapi.api.base.card.service;

import com.abcc.mydataapi.api.base.card.models.CardChargeSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardChargeEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardChargeForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface CardChargeService{
    public void regCardCharge(CardChargeForm dom);

    public void updCardCharge(CardChargeForm dom);

    public void modCardCharge(CardChargeForm dom);

    public void  delCardCharge(CardChargeForm dom);

    public CardChargeEntity getCardCharge(CardChargeSearch dom);

    public CardChargeEntity getCardChargeLast(CardChargeSearch dom);

    public ResultListDto<CardChargeEntity> getCardChargeList(CardChargeSearch dom);
}
