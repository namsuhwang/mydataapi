package com.kpcnc.mydataapi.api.base.card.service;

import com.kpcnc.mydataapi.api.base.card.models.CardDmPcaSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardDmPcaEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardDmPcaForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface CardDmPcaService{
    public void regCardDmPca(CardDmPcaForm dom);

    public void updCardDmPca(CardDmPcaForm dom);

    public void modCardDmPca(CardDmPcaForm dom);

    public void  delCardDmPca(CardDmPcaForm dom);

    public CardDmPcaEntity getCardDmPca(CardDmPcaSearch dom);

    public CardDmPcaEntity getCardDmPcaLast(CardDmPcaSearch dom);

    public ResultListDto<CardDmPcaEntity> getCardDmPcaList(CardDmPcaSearch dom);
}
