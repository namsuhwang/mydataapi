package com.kpcnc.mydataapi.api.base.card.service;

import com.kpcnc.mydataapi.api.base.card.models.CardLoanSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardLoanEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardLoanForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface CardLoanService{
    public CardLoanEntity regCardLoan(CardLoanForm dom);

    public CardLoanEntity modCardLoan(CardLoanForm dom);

    public void  delCardLoan(CardLoanForm dom);

    public CardLoanEntity getCardLoan(CardLoanSearch dom);

    public ResultListDto<CardLoanEntity> getCardLoanList(CardLoanSearch dom);
}
