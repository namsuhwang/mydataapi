package com.kpcnc.mydataapi.api.common.gateway.service;


import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallRequestInfoDto;
import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallResponseInfoDto;

public interface CallMyDataGatewayService {
    public ApiCallResponseInfoDto callMyDataApi(ApiCallRequestInfoDto dom);

}
