package com.albee.mydataapi.api.base.tele.controller;

import com.albee.mydataapi.api.base.tele.models.entity.TelePayEntity;
import com.albee.mydataapi.api.base.tele.models.form.TelePayForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.tele.models.TelePaySearch;
import com.albee.mydataapi.api.base.tele.service.TelePayService;
import com.albee.mydataapi.common.models.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@RestController
@EnableWebMvc
@RequiredArgsConstructor
@RequestMapping(value = "/telePay", produces="application/json;charset=UTF-8")
public class TelePayController {
    @Autowired
    TelePayService telePayService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<TelePayEntity>> regTelePay(
        @RequestBody TelePayForm dom
    ){
        telePayService.regTelePay(dom);
        TelePayEntity result = telePayService.getTelePay(new TelePaySearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<TelePayEntity>> modTelePay(
        @RequestBody TelePayForm dom
    ){
        telePayService.modTelePay(dom);
        TelePayEntity result = telePayService.getTelePay(new TelePaySearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<TelePayEntity>> getTelePay(
        @RequestBody TelePaySearch dom
    ){
        TelePayEntity result = telePayService.getTelePay(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<TelePayEntity>>> getTelePayList(
        @RequestBody TelePaySearch dom
    ){
        ResultListDto<TelePayEntity> resultList = telePayService.getTelePayList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
