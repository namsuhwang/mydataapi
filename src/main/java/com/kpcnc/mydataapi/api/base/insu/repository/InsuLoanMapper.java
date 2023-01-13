package com.kpcnc.mydataapi.api.base.insu.repository;

import com.kpcnc.mydataapi.api.base.insu.models.InsuLoanSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuLoanEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuLoanMapper{
    int insertInsuLoan(InsuLoanEntity dom);

    int updateInsuLoan(InsuLoanEntity dom);

    int deleteInsuLoan(InsuLoanEntity dom);

    InsuLoanEntity selectInsuLoan(InsuLoanSearch dom);

    Long selectInsuLoanListTotalCnt(InsuLoanSearch dom);

    List<InsuLoanEntity> selectInsuLoanList(InsuLoanSearch dom);
}
