package com.kpcnc.mydataapi.api.load.itfn.repository;

import com.kpcnc.mydataapi.api.load.itfn.models.ItfnLoanSearch;
import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnLoanEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItfnLoanMapper{
    int insertItfnLoan(ItfnLoanEntity dom);

    int updateItfnLoan(ItfnLoanEntity dom);

    int deleteItfnLoan(ItfnLoanEntity dom);

    ItfnLoanEntity selectItfnLoan(ItfnLoanSearch dom);

    Long selectItfnLoanListTotalCnt(ItfnLoanSearch dom);

    List<ItfnLoanEntity> selectItfnLoanList(ItfnLoanSearch dom);
}
