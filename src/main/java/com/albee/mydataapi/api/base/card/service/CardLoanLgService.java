package com.albee.mydataapi.api.base.card.service;

import com.albee.mydataapi.api.base.card.models.CardLoanLgSearch;
import com.albee.mydataapi.api.base.card.models.entity.CardLoanLgEntity;
import com.albee.mydataapi.api.base.card.models.form.CardLoanLgForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface CardLoanLgService{
    public void regCardLoanLg(CardLoanLgForm dom);

    public void updCardLoanLg(CardLoanLgForm dom);

    public void modCardLoanLg(CardLoanLgForm dom);

    public void  delCardLoanLg(CardLoanLgForm dom);

    public void  allDelCardLoanLg(CardLoanLgForm dom);

    public CardLoanLgEntity getCardLoanLg(CardLoanLgSearch dom);

    public ResultListDto<CardLoanLgEntity> getCardLoanLgList(CardLoanLgSearch dom);
}
