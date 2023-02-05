package com.albee.mydataapi.api.common.trans.controller;

import com.albee.mydataapi.api.common.trans.models.dto.CustJoinCheck;
import com.albee.mydataapi.api.common.trans.models.dto.TransRequestSpec;
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
@RequestMapping(value = "/trans-request", produces="application/json;charset=UTF-8")
public class TransRequestController {
    @Autowired
    TransRequestService transRequestService;

    // 전송요구-001
    // 마이데이터회원 가입 여부 응답
    @PostMapping("/001")
    public ResponseEntity<ResponseDto<HashMap<String, Object>>> transRequest001(
        @RequestBody CustJoinCheck dom
    ){
        CustJoinCheck result = transRequestService.transRequest001(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result.getCustJoinCheckResult()));
    }

    // 전송요구-002
    // 전송요구서 전송
    @PostMapping("/002")
    public ResponseEntity<ResponseDto> transRequest002(
            @RequestBody TransRequestSpec dom
    ){
        Boolean result = transRequestService.transRequest002(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS"));
    }

}
