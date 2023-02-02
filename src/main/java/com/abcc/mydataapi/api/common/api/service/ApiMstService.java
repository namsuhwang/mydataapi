package com.abcc.mydataapi.api.common.api.service;

import com.abcc.mydataapi.api.common.api.models.ApiMstSearch;
import com.abcc.mydataapi.api.common.api.models.entity.ApiMstEntity;
import com.abcc.mydataapi.api.common.api.models.form.ApiMstForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface ApiMstService{
    public ApiMstEntity regApiMst(ApiMstForm dom);

    public ApiMstEntity modApiMst(ApiMstForm dom);

    public void  delApiMst(ApiMstForm dom);

    public ApiMstEntity getApiMst(ApiMstSearch dom);

    public ResultListDto<ApiMstEntity> getApiMstList(ApiMstSearch dom);

    public List<ApiMstEntity> getApiListByScope(String scope);
}
