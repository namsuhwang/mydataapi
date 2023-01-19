package com.kpcnc.mydataapi.api.common.gateway.service;


import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallRequestInfoDto;
import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallResponseInfoDto;

public interface CallMyDataGatewayService {
    // public ApiCallResponseInfoDto callMyDataApi(ApiCallRequestInfoDto dom, String className);

    public <T> ApiCallResponseInfoDto callMyDataApi(ApiCallRequestInfoDto reqInfo, T classType);

    public <T, D>  ApiCallResponseInfoDto callRepeatMyDataApi(ApiCallRequestInfoDto reqInfo, T classTypeT, D classTypeD);

    // public ApiCallResponseInfoDto callCycleMyDataApi(ApiCallRequestInfoDto reqInfo, String className);

}
