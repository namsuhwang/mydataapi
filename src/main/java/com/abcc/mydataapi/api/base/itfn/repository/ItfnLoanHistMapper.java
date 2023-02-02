package com.abcc.mydataapi.api.base.itfn.repository;

import com.abcc.mydataapi.api.base.itfn.models.entity.ItfnLoanHistEntity;
import com.abcc.mydataapi.api.base.itfn.models.ItfnLoanHistSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItfnLoanHistMapper{
    int insertItfnLoanHist(ItfnLoanHistEntity dom);

    int updateItfnLoanHist(ItfnLoanHistEntity dom);

    int deleteItfnLoanHist(ItfnLoanHistEntity dom);

    ItfnLoanHistEntity selectItfnLoanHist(ItfnLoanHistSearch dom);

    ItfnLoanHistEntity selectItfnLoanHistLast(ItfnLoanHistSearch dom);

    Long selectItfnLoanHistListTotalCnt(ItfnLoanHistSearch dom);

    List<ItfnLoanHistEntity> selectItfnLoanHistList(ItfnLoanHistSearch dom);
}
