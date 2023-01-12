package com.kpcnc.mydataapi.api.load.card.service;

import com.kpcnc.mydataapi.api.load.card.models.CardRvSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardRvEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardRvForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface CardRvService{
    public CardRvEntity regCardRv(CardRvForm dom);

    public CardRvEntity modCardRv(CardRvForm dom);

    public void  delCardRv(CardRvForm dom);

    public CardRvEntity getCardRv(CardRvSearch dom);

    public ResultListDto<CardRvEntity> getCardRvList(CardRvSearch dom);
}
