package com.kpcnc.mydataapi.api.load.itfn.repository;

import com.kpcnc.mydataapi.api.load.itfn.models.ItfnAccSearch;
import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnAccEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItfnAccMapper{
    int insertItfnAcc(ItfnAccEntity dom);

    int updateItfnAcc(ItfnAccEntity dom);

    int deleteItfnAcc(ItfnAccEntity dom);

    ItfnAccEntity selectItfnAcc(ItfnAccSearch dom);

    Long selectItfnAccListTotalCnt(ItfnAccSearch dom);

    List<ItfnAccEntity> selectItfnAccList(ItfnAccSearch dom);
}
