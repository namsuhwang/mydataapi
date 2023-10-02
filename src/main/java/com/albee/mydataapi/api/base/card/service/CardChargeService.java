package com.albee.mydataapi.api.base.card.service;

import com.albee.mydataapi.api.base.card.models.CardChargeSearch;
import com.albee.mydataapi.api.base.card.models.entity.CardChargeEntity;
import com.albee.mydataapi.api.base.card.models.form.CardChargeForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface CardChargeService{
    public void regCardCharge(CardChargeForm dom);

    public void updCardCharge(CardChargeForm dom);

    public void modCardCharge(CardChargeForm dom);

    public void  delCardCharge(CardChargeForm dom);

    public CardChargeEntity getCardCharge(CardChargeSearch dom);

    public CardChargeEntity getCardChargeLast(CardChargeSearch dom);

    public ResultListDto<CardChargeEntity> getCardChargeList(CardChargeSearch dom);
}
