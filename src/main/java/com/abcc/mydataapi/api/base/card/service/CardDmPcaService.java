package com.abcc.mydataapi.api.base.card.service;

import com.abcc.mydataapi.api.base.card.models.CardDmPcaSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardDmPcaEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardDmPcaForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface CardDmPcaService{
    public void regCardDmPca(CardDmPcaForm dom);

    public void updCardDmPca(CardDmPcaForm dom);

    public void modCardDmPca(CardDmPcaForm dom);

    public void  delCardDmPca(CardDmPcaForm dom);

    public CardDmPcaEntity getCardDmPca(CardDmPcaSearch dom);

    public CardDmPcaEntity getCardDmPcaLast(CardDmPcaSearch dom);

    public ResultListDto<CardDmPcaEntity> getCardDmPcaList(CardDmPcaSearch dom);
}
