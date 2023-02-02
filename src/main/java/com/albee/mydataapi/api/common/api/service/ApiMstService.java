package com.albee.mydataapi.api.common.api.service;

import com.albee.mydataapi.api.common.api.models.ApiMstSearch;
import com.albee.mydataapi.api.common.api.models.entity.ApiMstEntity;
import com.albee.mydataapi.api.common.api.models.form.ApiMstForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface ApiMstService{
    public ApiMstEntity regApiMst(ApiMstForm dom);

    public ApiMstEntity modApiMst(ApiMstForm dom);

    public void  delApiMst(ApiMstForm dom);

    public ApiMstEntity getApiMst(ApiMstSearch dom);

    public ResultListDto<ApiMstEntity> getApiMstList(ApiMstSearch dom);

    public List<ApiMstEntity> getApiListByScope(String scope);
}
