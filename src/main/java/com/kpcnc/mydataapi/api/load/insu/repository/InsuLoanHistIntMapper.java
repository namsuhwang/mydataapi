package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuLoanHistIntSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuLoanHistIntEntity;
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
