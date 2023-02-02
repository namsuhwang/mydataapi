package com.abcc.mydataapi.api.base.card.service;

import com.abcc.mydataapi.api.base.card.models.CardLoanSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardLoanEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardLoanForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface CardLoanService{
    public CardLoanEntity regCardLoan(CardLoanForm dom);

    public CardLoanEntity modCardLoan(CardLoanForm dom);

    public void  delCardLoan(CardLoanForm dom);

    public CardLoanEntity getCardLoan(CardLoanSearch dom);

    public ResultListDto<CardLoanEntity> getCardLoanList(CardLoanSearch dom);
}
