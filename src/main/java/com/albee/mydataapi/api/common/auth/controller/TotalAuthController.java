package com.albee.mydataapi.api.common.auth.controller;

import com.albee.mydataapi.api.common.auth.models.dto.TotalAuthRequest;
import com.albee.mydataapi.api.common.auth.models.dto.TotalAuthResponse;
import com.albee.mydataapi.api.common.trans.service.TransRequestService;
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

@Slf4j
@RestController
@EnableWebMvc
@RequiredArgsConstructor
@RequestMapping(value = "/common", produces="application/json;charset=UTF-8")
public class TotalAuthController {
    @Autowired
    TransRequestService transRequestService;

    @Autowired
    MydataapidriverFeignClient mydataapidriverFeignClient;

    /*
        통합인증-002
        *** 실제로는 전송요구-002 에서 내부적으로 통합인증-002를 호출하기 때문에 컨트롤러가 불필요하지만 테스트용으로 일단 생성

        마이데이터사업자는 고객이 선택한 정보제공자를 대상으로 통합인증을 요청(전자서명 전송)
        • 마이데이터 서버는 1개 이상의 정보제공자에게 해당 기관을 대상으로 하는 전자서명을 각각 전송
        • 요청메시지 내 auth_type, consent_type 항목 설정 방식
            - 공동인증서(인증서 본인확인) 기반 통합인증 : auth_type : 0, consent_type : 0
            - 사설인증서(전자서명인증사업자) 기반 통합인증 : auth_type : 1, consent_type : 1
     */
    @PostMapping("/total-auth-002")
    public ResponseEntity<ResponseDto<TotalAuthResponse>> totalAuth002(
        @RequestBody TotalAuthRequest dom
    ){
        ResponseEntity<TotalAuthResponse> result = mydataapidriverFeignClient.totalAuthRequest(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result.getBody()));
    }

}
