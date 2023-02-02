package com.abcc.mydataapi.api.base.itfn.repository;

import com.abcc.mydataapi.api.base.itfn.models.entity.ItfnLoanAddEntity;
import com.abcc.mydataapi.api.base.itfn.models.ItfnLoanAddSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItfnLoanAddMapper{
    int insertItfnLoanAdd(ItfnLoanAddEntity dom);

    int updateItfnLoanAdd(ItfnLoanAddEntity dom);

    int deleteItfnLoanAdd(ItfnLoanAddEntity dom);

    ItfnLoanAddEntity selectItfnLoanAdd(ItfnLoanAddSearch dom);

    Long selectItfnLoanAddListTotalCnt(ItfnLoanAddSearch dom);

    List<ItfnLoanAddEntity> selectItfnLoanAddList(ItfnLoanAddSearch dom);
}
