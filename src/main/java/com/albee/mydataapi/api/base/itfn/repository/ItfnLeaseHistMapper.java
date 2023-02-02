package com.albee.mydataapi.api.base.itfn.repository;

import com.albee.mydataapi.api.base.itfn.models.entity.ItfnLeaseHistEntity;
import com.albee.mydataapi.api.base.itfn.models.ItfnLeaseHistSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItfnLeaseHistMapper{
    int insertItfnLeaseHist(ItfnLeaseHistEntity dom);

    int updateItfnLeaseHist(ItfnLeaseHistEntity dom);

    int deleteItfnLeaseHist(ItfnLeaseHistEntity dom);

    ItfnLeaseHistEntity selectItfnLeaseHist(ItfnLeaseHistSearch dom);

    ItfnLeaseHistEntity selectItfnLeaseHistLast(ItfnLeaseHistSearch dom);

    Long selectItfnLeaseHistListTotalCnt(ItfnLeaseHistSearch dom);

    List<ItfnLeaseHistEntity> selectItfnLeaseHistList(ItfnLeaseHistSearch dom);
}
