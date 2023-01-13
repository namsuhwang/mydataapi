package com.kpcnc.mydataapi.api.load.p2p.repository;

import com.kpcnc.mydataapi.api.load.p2p.models.P2pLoanBaseSearch;
import com.kpcnc.mydataapi.api.load.p2p.models.entity.P2pLoanBaseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface P2pLoanBaseMapper{
    int insertP2pLoanBase(P2pLoanBaseEntity dom);

    int updateP2pLoanBase(P2pLoanBaseEntity dom);

    int deleteP2pLoanBase(P2pLoanBaseEntity dom);

    P2pLoanBaseEntity selectP2pLoanBase(P2pLoanBaseSearch dom);

    Long selectP2pLoanBaseListTotalCnt(P2pLoanBaseSearch dom);

    List<P2pLoanBaseEntity> selectP2pLoanBaseList(P2pLoanBaseSearch dom);
}
