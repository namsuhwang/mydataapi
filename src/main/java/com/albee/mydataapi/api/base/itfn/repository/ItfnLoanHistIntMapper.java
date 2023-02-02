package com.albee.mydataapi.api.base.itfn.repository;

import com.albee.mydataapi.api.base.itfn.models.ItfnLoanHistIntSearch;
import com.albee.mydataapi.api.base.itfn.models.entity.ItfnLoanHistIntEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItfnLoanHistIntMapper{
    int insertItfnLoanHistInt(ItfnLoanHistIntEntity dom);

    int updateItfnLoanHistInt(ItfnLoanHistIntEntity dom);

    int deleteItfnLoanHistInt(ItfnLoanHistIntEntity dom);

    ItfnLoanHistIntEntity selectItfnLoanHistInt(ItfnLoanHistIntSearch dom);

    Long selectItfnLoanHistIntListTotalCnt(ItfnLoanHistIntSearch dom);

    List<ItfnLoanHistIntEntity> selectItfnLoanHistIntList(ItfnLoanHistIntSearch dom);
}
