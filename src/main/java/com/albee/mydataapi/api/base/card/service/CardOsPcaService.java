package com.albee.mydataapi.api.base.card.service;

import com.albee.mydataapi.api.base.card.models.CardOsPcaSearch;
import com.albee.mydataapi.api.base.card.models.entity.CardOsPcaEntity;
import com.albee.mydataapi.api.base.card.models.form.CardOsPcaForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface CardOsPcaService{
    public void regCardOsPca(CardOsPcaForm dom);

    public void updCardOsPca(CardOsPcaForm dom);

    public void modCardOsPca(CardOsPcaForm dom);

    public void  delCardOsPca(CardOsPcaForm dom);

    public CardOsPcaEntity getCardOsPca(CardOsPcaSearch dom);

    public CardOsPcaEntity getCardOsPcaLast(CardOsPcaSearch dom);

    public ResultListDto<CardOsPcaEntity> getCardOsPcaList(CardOsPcaSearch dom);
}
