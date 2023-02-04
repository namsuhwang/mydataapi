package com.albee.mydataapi.api.test.mydataapidriver.controller;

import com.albee.mydataapi.api.test.mydataapidriver.models.dto.CallTestParam;
import com.albee.mydataapi.common.client.MydataapidriverFeignClient;
import com.albee.mydataapi.common.models.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Map;

@Slf4j
@RestController
@EnableWebMvc
@RequiredArgsConstructor
@RequestMapping(value = "/mydatagatewaytest", produces="application/json;charset=UTF-8")
public class MydataGatewayTestDriverController {
    @Autowired
    MydataapidriverFeignClient mydataapidriverFeignClient;

    @PostMapping("/test")
    public ResponseEntity<ResponseDto<Map<String, String>>> callTest (
        @RequestBody CallTestParam dom
    ){
        ResponseEntity<ResponseDto<Map<String, String>>> result = mydataapidriverFeignClient.callTest(dom);
        return result;
    }


}
