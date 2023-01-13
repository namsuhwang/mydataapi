package com.kpcnc.mydataapi.api.load.itfn.repository;

import com.kpcnc.mydataapi.api.load.itfn.models.ItfnLeaseHistSearch;
import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnLeaseHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItfnLeaseHistMapper{
    int insertItfnLeaseHist(ItfnLeaseHistEntity dom);

    int updateItfnLeaseHist(ItfnLeaseHistEntity dom);

    int deleteItfnLeaseHist(ItfnLeaseHistEntity dom);

    ItfnLeaseHistEntity selectItfnLeaseHist(ItfnLeaseHistSearch dom);

    Long selectItfnLeaseHistListTotalCnt(ItfnLeaseHistSearch dom);

    List<ItfnLeaseHistEntity> selectItfnLeaseHistList(ItfnLeaseHistSearch dom);
}
