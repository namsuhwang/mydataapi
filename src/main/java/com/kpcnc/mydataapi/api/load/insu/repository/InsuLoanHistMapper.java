package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuLoanHistSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuLoanHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuLoanHistMapper{
    int insertInsuLoanHist(InsuLoanHistEntity dom);

    int updateInsuLoanHist(InsuLoanHistEntity dom);

    int deleteInsuLoanHist(InsuLoanHistEntity dom);

    InsuLoanHistEntity selectInsuLoanHist(InsuLoanHistSearch dom);

    Long selectInsuLoanHistListTotalCnt(InsuLoanHistSearch dom);

    List<InsuLoanHistEntity> selectInsuLoanHistList(InsuLoanHistSearch dom);
}
