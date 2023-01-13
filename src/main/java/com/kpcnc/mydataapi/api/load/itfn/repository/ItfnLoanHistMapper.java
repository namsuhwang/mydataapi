package com.kpcnc.mydataapi.api.load.itfn.repository;

import com.kpcnc.mydataapi.api.load.itfn.models.ItfnLoanHistSearch;
import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnLoanHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItfnLoanHistMapper{
    int insertItfnLoanHist(ItfnLoanHistEntity dom);

    int updateItfnLoanHist(ItfnLoanHistEntity dom);

    int deleteItfnLoanHist(ItfnLoanHistEntity dom);

    ItfnLoanHistEntity selectItfnLoanHist(ItfnLoanHistSearch dom);

    Long selectItfnLoanHistListTotalCnt(ItfnLoanHistSearch dom);

    List<ItfnLoanHistEntity> selectItfnLoanHistList(ItfnLoanHistSearch dom);
}
