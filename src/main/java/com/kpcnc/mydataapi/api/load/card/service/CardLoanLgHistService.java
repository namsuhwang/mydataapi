package com.kpcnc.mydataapi.api.load.card.service;

import com.kpcnc.mydataapi.api.load.card.models.CardLoanLgHistSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardLoanLgHistEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardLoanLgHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface CardLoanLgHistService{
    public CardLoanLgHistEntity regCardLoanLgHist(CardLoanLgHistForm dom);

    public CardLoanLgHistEntity modCardLoanLgHist(CardLoanLgHistForm dom);

    public void  delCardLoanLgHist(CardLoanLgHistForm dom);

    public CardLoanLgHistEntity getCardLoanLgHist(CardLoanLgHistSearch dom);

    public ResultListDto<CardLoanLgHistEntity> getCardLoanLgHistList(CardLoanLgHistSearch dom);
}
