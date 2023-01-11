package com.kpcnc.mydataapi.api.common.api.repository;

import com.kpcnc.mydataapi.api.common.api.models.ApiMstSearch;
import com.kpcnc.mydataapi.api.common.api.models.entity.ApiMstEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ApiMstMapper{
    int insertApiMst(ApiMstEntity dom);

    int updateApiMst(ApiMstEntity dom);

    int deleteApiMst(ApiMstEntity dom);

    ApiMstEntity selectApiMst(ApiMstSearch dom);

    Long selectApiMstListTotalCnt(ApiMstSearch dom);

    List<ApiMstEntity> selectApiMstList(ApiMstSearch dom);
}
