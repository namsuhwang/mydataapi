package com.abcc.mydataapi.api.base.p2p.repository;

import com.abcc.mydataapi.api.base.p2p.models.entity.P2pLoanAddEntity;
import com.abcc.mydataapi.api.base.p2p.models.P2pLoanAddSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface P2pLoanAddMapper{
    int insertP2pLoanAdd(P2pLoanAddEntity dom);

    int updateP2pLoanAdd(P2pLoanAddEntity dom);

    int deleteP2pLoanAdd(P2pLoanAddEntity dom);

    P2pLoanAddEntity selectP2pLoanAdd(P2pLoanAddSearch dom);

    Long selectP2pLoanAddListTotalCnt(P2pLoanAddSearch dom);

    List<P2pLoanAddEntity> selectP2pLoanAddList(P2pLoanAddSearch dom);
}
