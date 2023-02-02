package com.albee.mydataapi.api.base.itfn.repository;

import com.albee.mydataapi.api.base.itfn.models.entity.ItfnLoanEntity;
import com.albee.mydataapi.api.base.itfn.models.ItfnLoanSearch;
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
