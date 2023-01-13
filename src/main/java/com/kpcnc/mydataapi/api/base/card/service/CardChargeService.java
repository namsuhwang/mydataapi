package com.kpcnc.mydataapi.api.base.card.service;

import com.kpcnc.mydataapi.api.base.card.models.CardChargeSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardChargeEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardChargeForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface CardChargeService{
    public CardChargeEntity regCardCharge(CardChargeForm dom);

    public CardChargeEntity modCardCharge(CardChargeForm dom);

    public void  delCardCharge(CardChargeForm dom);

    public CardChargeEntity getCardCharge(CardChargeSearch dom);

    public ResultListDto<CardChargeEntity> getCardChargeList(CardChargeSearch dom);
}
