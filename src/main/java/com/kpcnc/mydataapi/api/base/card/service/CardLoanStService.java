package com.kpcnc.mydataapi.api.base.card.service;

import com.kpcnc.mydataapi.api.base.card.models.CardLoanStSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardLoanStEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardLoanStForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface CardLoanStService{
    public void regCardLoanSt(CardLoanStForm dom);

    public void updCardLoanSt(CardLoanStForm dom);

    public void modCardLoanSt(CardLoanStForm dom);

    public void  delCardLoanSt(CardLoanStForm dom);

    public void  allDelCardLoanSt(CardLoanStForm dom);

    public CardLoanStEntity getCardLoanSt(CardLoanStSearch dom);

    public ResultListDto<CardLoanStEntity> getCardLoanStList(CardLoanStSearch dom);
}
