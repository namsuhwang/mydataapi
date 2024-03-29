package com.albee.mydataapi.api.base.p2p.repository;

import com.albee.mydataapi.api.base.p2p.models.entity.P2pLoanHistEntity;
import com.albee.mydataapi.api.base.p2p.models.P2pLoanHistSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface P2pLoanHistMapper{
    int insertP2pLoanHist(P2pLoanHistEntity dom);

    int updateP2pLoanHist(P2pLoanHistEntity dom);

    int deleteP2pLoanHist(P2pLoanHistEntity dom);

    P2pLoanHistEntity selectP2pLoanHist(P2pLoanHistSearch dom);

    P2pLoanHistEntity selectP2pLoanHistLast(P2pLoanHistSearch dom);

    Long selectP2pLoanHistListTotalCnt(P2pLoanHistSearch dom);

    List<P2pLoanHistEntity> selectP2pLoanHistList(P2pLoanHistSearch dom);
}
