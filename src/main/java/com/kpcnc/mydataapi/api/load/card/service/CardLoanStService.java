package com.kpcnc.mydataapi.api.load.card.service;

import com.kpcnc.mydataapi.api.load.card.models.CardLoanStSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardLoanStEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardLoanStForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface CardLoanStService{
    public CardLoanStEntity regCardLoanSt(CardLoanStForm dom);

    public CardLoanStEntity modCardLoanSt(CardLoanStForm dom);

    public void  delCardLoanSt(CardLoanStForm dom);

    public CardLoanStEntity getCardLoanSt(CardLoanStSearch dom);

    public ResultListDto<CardLoanStEntity> getCardLoanStList(CardLoanStSearch dom);
}
