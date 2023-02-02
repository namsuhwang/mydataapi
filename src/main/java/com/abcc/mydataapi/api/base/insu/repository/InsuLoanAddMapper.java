package com.abcc.mydataapi.api.base.insu.repository;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuLoanAddEntity;
import com.abcc.mydataapi.api.base.insu.models.InsuLoanAddSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuLoanAddMapper{
    int insertInsuLoanAdd(InsuLoanAddEntity dom);

    int updateInsuLoanAdd(InsuLoanAddEntity dom);

    int deleteInsuLoanAdd(InsuLoanAddEntity dom);

    InsuLoanAddEntity selectInsuLoanAdd(InsuLoanAddSearch dom);

    Long selectInsuLoanAddListTotalCnt(InsuLoanAddSearch dom);

    List<InsuLoanAddEntity> selectInsuLoanAddList(InsuLoanAddSearch dom);
}
