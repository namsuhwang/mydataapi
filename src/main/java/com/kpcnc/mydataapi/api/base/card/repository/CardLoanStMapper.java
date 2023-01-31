package com.kpcnc.mydataapi.api.base.card.repository;

import com.kpcnc.mydataapi.api.base.card.models.CardLoanStSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardLoanStEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardLoanStMapper{
    int insertCardLoanSt(CardLoanStEntity dom);

    int updateCardLoanSt(CardLoanStEntity dom);

    int deleteCardLoanSt(CardLoanStEntity dom);

    int deleteAllCardLoanSt(CardLoanStEntity dom);

    CardLoanStEntity selectCardLoanSt(CardLoanStSearch dom);

    Long selectCardLoanStListTotalCnt(CardLoanStSearch dom);

    List<CardLoanStEntity> selectCardLoanStList(CardLoanStSearch dom);
}
