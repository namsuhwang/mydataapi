package com.albee.mydataapi.api.common.recv.repository;

import com.albee.mydataapi.api.common.recv.models.RecvHistDetailSearch;
import com.albee.mydataapi.api.common.recv.models.entity.RecvHistDetailEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecvHistDetailMapper{
    long createRecvDetailSeq();

    int insertRecvHistDetail(RecvHistDetailEntity dom);

    int updateRecvHistDetail(RecvHistDetailEntity dom);

    int deleteRecvHistDetail(RecvHistDetailEntity dom);

    RecvHistDetailEntity selectRecvHistDetail(RecvHistDetailSearch dom);

    Long selectRecvHistDetailListTotalCnt(RecvHistDetailSearch dom);

    List<RecvHistDetailEntity> selectRecvHistDetailList(RecvHistDetailSearch dom);
}
