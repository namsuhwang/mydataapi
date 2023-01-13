package com.kpcnc.mydataapi.api.base.itfn.repository;

import com.kpcnc.mydataapi.api.base.itfn.models.ItfnLeaseHistSearch;
import com.kpcnc.mydataapi.api.base.itfn.models.entity.ItfnLeaseHistEntity;
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
