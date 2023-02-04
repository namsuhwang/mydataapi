package com.albee.mydataapi.common.client;

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

}
