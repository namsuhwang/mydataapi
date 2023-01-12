package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuLoanAddSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuLoanAddEntity;
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
