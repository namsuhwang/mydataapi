package com.kpcnc.mydataapi.api.load.card.service;

import com.kpcnc.mydataapi.api.load.card.models.CardLoanSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardLoanEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardLoanForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface CardLoanService{
    public CardLoanEntity regCardLoan(CardLoanForm dom);

    public CardLoanEntity modCardLoan(CardLoanForm dom);

    public void  delCardLoan(CardLoanForm dom);

    public CardLoanEntity getCardLoan(CardLoanSearch dom);

    public ResultListDto<CardLoanEntity> getCardLoanList(CardLoanSearch dom);
}
