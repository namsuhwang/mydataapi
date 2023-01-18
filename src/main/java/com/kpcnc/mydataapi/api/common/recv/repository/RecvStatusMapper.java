package com.kpcnc.mydataapi.api.common.recv.repository;

import com.kpcnc.mydataapi.api.common.recv.models.RecvStatusSearch;
import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvStatusEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecvStatusMapper{
    String createRecvSeq(RecvStatusEntity dom);
    int insertRecvStatus(RecvStatusEntity dom);

    int updateRecvStatus(RecvStatusEntity dom);

    int deleteRecvStatus(RecvStatusEntity dom);

    RecvStatusEntity selectRecvStatus(RecvStatusSearch dom);

    Long selectRecvStatusListTotalCnt(RecvStatusSearch dom);

    List<RecvStatusEntity> selectRecvStatusList(RecvStatusSearch dom);
}
