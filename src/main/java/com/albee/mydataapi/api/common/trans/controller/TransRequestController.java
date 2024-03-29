package com.albee.mydataapi.api.common.trans.controller;

import com.albee.mydataapi.api.common.gateway.models.res.ResRootDto;
import com.albee.mydataapi.api.common.trans.models.dto.CustJoinCheck;
import com.albee.mydataapi.api.common.trans.models.dto.TransRequestRetry;
import com.albee.mydataapi.api.common.trans.models.dto.TransRequestSpec;
import com.albee.mydataapi.api.common.trans.models.dto.TransRequestWithdraw;
import com.albee.mydataapi.api.common.trans.service.TransRequestService;
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

import java.util.HashMap;

@Slf4j
@RestController
@EnableWebMvc
@RequiredArgsConstructor
@RequestMapping(value = "/common", produces="application/json;charset=UTF-8")
public class TransRequestController {
    @Autowired
    TransRequestService transRequestService;

    // 전송요구-001
    // 마이데이터회원 가입 여부 응답
    @PostMapping("/trans-request-001")
    public ResponseEntity<ResponseDto<HashMap<String, Object>>> transRequest001(
        @RequestBody CustJoinCheck dom
    ){
        CustJoinCheck result = transRequestService.transRequest001(dom);
        if(result.getIsJoin()){
            return ResponseEntity.ok().body(new ResponseDto<>("00000", "SUCCESS", result.getCustJoinCheckResult()));
        }else{
            return ResponseEntity.ok().body(new ResponseDto<>("40403", "고객미존재", result.getCustJoinCheckResult()));
        }
    }

    // 전송요구-002
    // 전송요구서 전송
    @PostMapping("/trans-request-002")
    public ResponseEntity<ResponseDto> transRequest002(
            @RequestBody TransRequestSpec dom
    ){
        Boolean result = transRequestService.transRequest002(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS"));
    }

    /*
    // 전송요구-003
    // 전송요구 또는 철회 결과 전송
    @PostMapping("/trans-request-003")
    public ResponseEntity<ResponseDto> transRequest003(
            @RequestBody TransRequestSpec dom
    ){
        ResRootDto result = transRequestService.transRequest003(dom.getTransReqForm().getEntity());
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS"));
    }
    */

    // 전송요구-004
    // 전송요구 철회 요청
    @PostMapping("/trans-request-004")
    public ResponseEntity<ResponseDto> transRequest004(
            @RequestBody TransRequestWithdraw dom
    ){
        Boolean result = transRequestService.transRequest004(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS"));
    }

    // 전송요구-005
    // 전송요구 또는 철회 결과 재전송 요청
    @PostMapping("/trans-request-005")
    public ResponseEntity<ResponseDto> transRequest005(
            @RequestBody TransRequestRetry dom
    ){
        ResponseDto result = transRequestService.transRequest005(dom);
        return ResponseEntity.ok().body(result);
    }

}
