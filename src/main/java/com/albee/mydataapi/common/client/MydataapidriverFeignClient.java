package com.albee.mydataapi.common.client;

import com.albee.mydataapi.api.common.gateway.models.res.ResRootDto;
import com.albee.mydataapi.api.common.auth.models.dto.TotalAuthRequest;
import com.albee.mydataapi.api.common.auth.models.dto.TotalAuthResponse;
import com.albee.mydataapi.api.common.trans.models.dto.TransRequestProcResult;
import com.albee.mydataapi.api.test.mydataapidriver.models.dto.CallTestParam;
import com.albee.mydataapi.common.models.dto.ResponseDto;
import com.albee.mydataapi.config.MydataapidriverFeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "MydataapidriverFeignClient", url = "${feign.mydatagateway.url}", configuration = MydataapidriverFeignClientConfig.class)
public interface MydataapidriverFeignClient {

    @PostMapping(value = "", produces = "application/json", consumes = "application/json")
    ResponseEntity<ResponseDto<Map<String, String>>> callTest(@RequestBody CallTestParam dom);

    // 통합인증-002. 마이데이터사업자는 고객이 선택한 정보제공자를 대상으로 통합인증을 요청(전자서명 전송)
    @PostMapping(value = "/common/toal-auth-002", produces = "application/json", consumes = "application/json")
    ResponseEntity<TotalAuthResponse> totalAuthRequest(@RequestBody TotalAuthRequest dom);

    // 전송요구-003. 전송요구등록/철회 처리 결과를 종합포털(또는 거점기관)에 전달함
    @PostMapping(value = "/common/trans-request-003", produces = "application/json", consumes = "application/json")
    ResponseEntity<ResRootDto> replyTransRequestProcResult(@RequestBody TransRequestProcResult dom);

}
