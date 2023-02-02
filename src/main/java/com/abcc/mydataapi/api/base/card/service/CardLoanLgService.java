package com.abcc.mydataapi.api.base.card.service;

import com.abcc.mydataapi.api.base.card.models.CardLoanLgSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardLoanLgEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardLoanLgForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface CardLoanLgService{
    public void regCardLoanLg(CardLoanLgForm dom);

    public void updCardLoanLg(CardLoanLgForm dom);

    public void modCardLoanLg(CardLoanLgForm dom);

    public void  delCardLoanLg(CardLoanLgForm dom);

    public void  allDelCardLoanLg(CardLoanLgForm dom);

    public CardLoanLgEntity getCardLoanLg(CardLoanLgSearch dom);

    public ResultListDto<CardLoanLgEntity> getCardLoanLgList(CardLoanLgSearch dom);
}
