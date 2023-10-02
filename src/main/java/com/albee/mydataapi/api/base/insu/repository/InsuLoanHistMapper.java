package com.albee.mydataapi.api.base.insu.repository;

import com.albee.mydataapi.api.base.insu.models.entity.InsuLoanHistEntity;
import com.albee.mydataapi.api.base.insu.models.InsuLoanHistSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuLoanHistMapper{
    int insertInsuLoanHist(InsuLoanHistEntity dom);

    int updateInsuLoanHist(InsuLoanHistEntity dom);

    int deleteInsuLoanHist(InsuLoanHistEntity dom);

    InsuLoanHistEntity selectInsuLoanHist(InsuLoanHistSearch dom);

    InsuLoanHistEntity selectInsuLoanHistLast(InsuLoanHistSearch dom);

    Long selectInsuLoanHistListTotalCnt(InsuLoanHistSearch dom);

    List<InsuLoanHistEntity> selectInsuLoanHistList(InsuLoanHistSearch dom);
}
