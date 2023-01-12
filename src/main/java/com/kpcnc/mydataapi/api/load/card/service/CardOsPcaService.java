package com.kpcnc.mydataapi.api.load.card.service;

import com.kpcnc.mydataapi.api.load.card.models.CardOsPcaSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardOsPcaEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardOsPcaForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface CardOsPcaService{
    public CardOsPcaEntity regCardOsPca(CardOsPcaForm dom);

    public CardOsPcaEntity modCardOsPca(CardOsPcaForm dom);

    public void  delCardOsPca(CardOsPcaForm dom);

    public CardOsPcaEntity getCardOsPca(CardOsPcaSearch dom);

    public ResultListDto<CardOsPcaEntity> getCardOsPcaList(CardOsPcaSearch dom);
}
