package com.kpcnc.mydataapi.api.base.itfn.repository;

import com.kpcnc.mydataapi.api.base.itfn.models.ItfnLeaseSearch;
import com.kpcnc.mydataapi.api.base.itfn.models.entity.ItfnLeaseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItfnLeaseMapper{
    int insertItfnLease(ItfnLeaseEntity dom);

    int updateItfnLease(ItfnLeaseEntity dom);

    int deleteItfnLease(ItfnLeaseEntity dom);

    ItfnLeaseEntity selectItfnLease(ItfnLeaseSearch dom);

    Long selectItfnLeaseListTotalCnt(ItfnLeaseSearch dom);

    List<ItfnLeaseEntity> selectItfnLeaseList(ItfnLeaseSearch dom);
}
