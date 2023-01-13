package com.kpcnc.mydataapi.api.base.card.service;

import com.kpcnc.mydataapi.api.base.card.models.CardDmPcaSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardDmPcaEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardDmPcaForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface CardDmPcaService{
    public CardDmPcaEntity regCardDmPca(CardDmPcaForm dom);

    public CardDmPcaEntity modCardDmPca(CardDmPcaForm dom);

    public void  delCardDmPca(CardDmPcaForm dom);

    public CardDmPcaEntity getCardDmPca(CardDmPcaSearch dom);

    public ResultListDto<CardDmPcaEntity> getCardDmPcaList(CardDmPcaSearch dom);
}
