package com.abcc.mydataapi.api.base.itfn.repository;

import com.abcc.mydataapi.api.base.itfn.models.entity.ItfnAccEntity;
import com.abcc.mydataapi.api.base.itfn.models.ItfnAccSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItfnAccMapper{
    int insertItfnAcc(ItfnAccEntity dom);

    int updateItfnAcc(ItfnAccEntity dom);

    int deleteItfnAcc(ItfnAccEntity dom);

    int deleteAllItfnAcc(ItfnAccEntity dom);

    ItfnAccEntity selectItfnAcc(ItfnAccSearch dom);

    Long selectItfnAccListTotalCnt(ItfnAccSearch dom);

    List<ItfnAccEntity> selectItfnAccList(ItfnAccSearch dom);
}
