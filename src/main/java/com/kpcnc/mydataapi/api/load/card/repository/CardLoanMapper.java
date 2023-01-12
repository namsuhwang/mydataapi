package com.kpcnc.mydataapi.api.load.card.repository;

import com.kpcnc.mydataapi.api.load.card.models.CardLoanSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardLoanEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardLoanMapper{
    int insertCardLoan(CardLoanEntity dom);

    int updateCardLoan(CardLoanEntity dom);

    int deleteCardLoan(CardLoanEntity dom);

    CardLoanEntity selectCardLoan(CardLoanSearch dom);

    Long selectCardLoanListTotalCnt(CardLoanSearch dom);

    List<CardLoanEntity> selectCardLoanList(CardLoanSearch dom);
}
