package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuLoanBaseSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuLoanBaseEntity;
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
