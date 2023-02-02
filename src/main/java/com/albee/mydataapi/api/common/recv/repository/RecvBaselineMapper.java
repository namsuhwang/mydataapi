package com.albee.mydataapi.api.common.recv.repository;

import com.albee.mydataapi.api.common.recv.models.RecvBaselineSearch;
import com.albee.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecvBaselineMapper{
    int insertRecvBaseline(RecvBaselineEntity dom);

    int updateRecvBaseline(RecvBaselineEntity dom);

    int deleteRecvBaseline(RecvBaselineEntity dom);

    RecvBaselineEntity selectRecvBaseline(RecvBaselineSearch dom);

    Long selectRecvBaselineListTotalCnt(RecvBaselineSearch dom);

    List<RecvBaselineEntity> selectRecvBaselineList(RecvBaselineSearch dom);
}
