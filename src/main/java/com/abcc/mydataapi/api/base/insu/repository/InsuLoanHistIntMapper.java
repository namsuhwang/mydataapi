package com.abcc.mydataapi.api.base.insu.repository;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuLoanHistIntEntity;
import com.abcc.mydataapi.api.base.insu.models.InsuLoanHistIntSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuLoanHistIntMapper{
    int insertInsuLoanHistInt(InsuLoanHistIntEntity dom);

    int updateInsuLoanHistInt(InsuLoanHistIntEntity dom);

    int deleteInsuLoanHistInt(InsuLoanHistIntEntity dom);

    InsuLoanHistIntEntity selectInsuLoanHistInt(InsuLoanHistIntSearch dom);

    Long selectInsuLoanHistIntListTotalCnt(InsuLoanHistIntSearch dom);

    List<InsuLoanHistIntEntity> selectInsuLoanHistIntList(InsuLoanHistIntSearch dom);
}
