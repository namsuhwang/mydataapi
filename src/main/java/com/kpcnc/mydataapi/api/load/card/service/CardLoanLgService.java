package com.kpcnc.mydataapi.api.load.card.service;

import com.kpcnc.mydataapi.api.load.card.models.CardLoanLgSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardLoanLgEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardLoanLgForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface CardLoanLgService{
    public CardLoanLgEntity regCardLoanLg(CardLoanLgForm dom);

    public CardLoanLgEntity modCardLoanLg(CardLoanLgForm dom);

    public void  delCardLoanLg(CardLoanLgForm dom);

    public CardLoanLgEntity getCardLoanLg(CardLoanLgSearch dom);

    public ResultListDto<CardLoanLgEntity> getCardLoanLgList(CardLoanLgSearch dom);
}
