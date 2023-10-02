package com.albee.mydataapi.api.base.card.service;

import com.albee.mydataapi.api.base.card.models.CardRvSearch;
import com.albee.mydataapi.api.base.card.models.entity.CardRvEntity;
import com.albee.mydataapi.api.base.card.models.form.CardRvForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface CardRvService{
    public void regCardRv(CardRvForm dom);

    public void updCardRv(CardRvForm dom);

    public void modCardRv(CardRvForm dom);

    public void  delCardRv(CardRvForm dom);

    public void  allDelCardRv(CardRvForm dom);

    public CardRvEntity getCardRv(CardRvSearch dom);

    public ResultListDto<CardRvEntity> getCardRvList(CardRvSearch dom);
}
