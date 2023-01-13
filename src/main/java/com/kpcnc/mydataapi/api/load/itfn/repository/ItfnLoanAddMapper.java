package com.kpcnc.mydataapi.api.load.itfn.repository;

import com.kpcnc.mydataapi.api.load.itfn.models.ItfnLoanAddSearch;
import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnLoanAddEntity;
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
