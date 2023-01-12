package com.kpcnc.mydataapi.api.load.card.service;

import com.kpcnc.mydataapi.api.load.card.models.CardChargeSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardChargeEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardChargeForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface CardChargeService{
    public CardChargeEntity regCardCharge(CardChargeForm dom);

    public CardChargeEntity modCardCharge(CardChargeForm dom);

    public void  delCardCharge(CardChargeForm dom);

    public CardChargeEntity getCardCharge(CardChargeSearch dom);

    public ResultListDto<CardChargeEntity> getCardChargeList(CardChargeSearch dom);
}
