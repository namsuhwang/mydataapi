package com.albee.mydataapi.api.base.insu.repository;

import com.albee.mydataapi.api.base.insu.models.entity.InsuLoanBaseEntity;
import com.albee.mydataapi.api.base.insu.models.InsuLoanBaseSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuLoanBaseMapper{
    int insertInsuLoanBase(InsuLoanBaseEntity dom);

    int updateInsuLoanBase(InsuLoanBaseEntity dom);

    int deleteInsuLoanBase(InsuLoanBaseEntity dom);

    InsuLoanBaseEntity selectInsuLoanBase(InsuLoanBaseSearch dom);

    Long selectInsuLoanBaseListTotalCnt(InsuLoanBaseSearch dom);

    List<InsuLoanBaseEntity> selectInsuLoanBaseList(InsuLoanBaseSearch dom);
}
