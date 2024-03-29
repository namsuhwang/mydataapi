package com.albee.mydataapi.api.base.p2p.repository;

import com.albee.mydataapi.api.base.p2p.models.entity.P2pLoanEntity;
import com.albee.mydataapi.api.base.p2p.models.P2pLoanSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface P2pLoanMapper{
    int insertP2pLoan(P2pLoanEntity dom);

    int updateP2pLoan(P2pLoanEntity dom);

    int deleteP2pLoan(P2pLoanEntity dom);

    int deleteAllP2pLoan(P2pLoanEntity dom);

    P2pLoanEntity selectP2pLoan(P2pLoanSearch dom);

    P2pLoanEntity selectP2pLoanLast(P2pLoanSearch dom);

    Long selectP2pLoanListTotalCnt(P2pLoanSearch dom);

    List<P2pLoanEntity> selectP2pLoanList(P2pLoanSearch dom);
}
