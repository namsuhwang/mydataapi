package com.albee.mydataapi.api.common.gateway.service;


import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallResDto;

public interface CallMyDataGatewayService {
    // public ApiCallResponseInfoDto callMyDataApi(ApiCallRequestInfoDto dom, String className);

    public <T> ApiCallResDto callMyDataApi(ApiCallReqDto reqInfo, T classType);

    public <T, D> ApiCallResDto callRepeatMyDataApi(ApiCallReqDto reqInfo, T classTypeT, D classTypeD);

//    public <T, D, C> ApiCallResDto callRepeat2MyDataApi(ApiCallReqDto reqInfo, T classTypeT, D classTypeD, C classTypeC);

    // public ApiCallResponseInfoDto callCycleMyDataApi(ApiCallRequestInfoDto reqInfo, String className);

}
