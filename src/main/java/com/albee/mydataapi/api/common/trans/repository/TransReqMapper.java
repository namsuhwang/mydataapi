package com.albee.mydataapi.api.common.trans.repository;

import com.albee.mydataapi.api.common.trans.models.TransReqSearch;
import com.albee.mydataapi.api.common.trans.models.entity.TransReqEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TransReqMapper{
    int insertTransReq(TransReqEntity dom);

    int updateTransReq(TransReqEntity dom);

    int deleteTransReq(TransReqEntity dom);

    TransReqEntity selectTransReq(TransReqSearch dom);

    Long selectTransReqListTotalCnt(TransReqSearch dom);

    List<TransReqEntity> selectTransReqList(TransReqSearch dom);
}
