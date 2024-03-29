package com.albee.mydataapi.api.base.insu.repository;

import com.albee.mydataapi.api.base.insu.models.entity.InsuLoanEntity;
import com.albee.mydataapi.api.base.insu.models.InsuLoanSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuLoanMapper{
    int insertInsuLoan(InsuLoanEntity dom);

    int updateInsuLoan(InsuLoanEntity dom);

    int deleteInsuLoan(InsuLoanEntity dom);

    int deleteAllInsuLoan(InsuLoanEntity dom);

    InsuLoanEntity selectInsuLoan(InsuLoanSearch dom);

    Long selectInsuLoanListTotalCnt(InsuLoanSearch dom);

    List<InsuLoanEntity> selectInsuLoanList(InsuLoanSearch dom);
}
