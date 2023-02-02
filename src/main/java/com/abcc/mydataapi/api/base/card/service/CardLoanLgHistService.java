package com.abcc.mydataapi.api.base.card.service;

import com.abcc.mydataapi.api.base.card.models.CardLoanLgHistSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardLoanLgHistEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardLoanLgHistForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface CardLoanLgHistService{
    public CardLoanLgHistEntity regCardLoanLgHist(CardLoanLgHistForm dom);

    public CardLoanLgHistEntity modCardLoanLgHist(CardLoanLgHistForm dom);

    public void  delCardLoanLgHist(CardLoanLgHistForm dom);

    public CardLoanLgHistEntity getCardLoanLgHist(CardLoanLgHistSearch dom);

    public CardLoanLgHistEntity getCardLoanLgHistLast(CardLoanLgHistSearch dom);

    public ResultListDto<CardLoanLgHistEntity> getCardLoanLgHistList(CardLoanLgHistSearch dom);
}
