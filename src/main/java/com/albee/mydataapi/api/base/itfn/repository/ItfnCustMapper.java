package com.albee.mydataapi.api.base.itfn.repository;

import com.albee.mydataapi.api.base.itfn.models.ItfnCustSearch;
import com.albee.mydataapi.api.base.itfn.models.entity.ItfnCustEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItfnCustMapper{
    int insertItfnCust(ItfnCustEntity dom);

    int updateItfnCust(ItfnCustEntity dom);

    int deleteItfnCust(ItfnCustEntity dom);

    ItfnCustEntity selectItfnCust(ItfnCustSearch dom);

    Long selectItfnCustListTotalCnt(ItfnCustSearch dom);

    List<ItfnCustEntity> selectItfnCustList(ItfnCustSearch dom);
}
