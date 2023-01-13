package com.kpcnc.mydataapi.api.load.tele.controller;

import com.kpcnc.mydataapi.api.load.tele.models.TelePaySearch;
import com.kpcnc.mydataapi.api.load.tele.models.entity.TelePayEntity;
import com.kpcnc.mydataapi.api.load.tele.models.form.TelePayForm;
import com.kpcnc.mydataapi.api.load.tele.service.TelePayService;
import com.kpcnc.mydataapi.common.models.dto.ResponseDto;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

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
        TelePayEntity result = telePayService.regTelePay(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<TelePayEntity>> modTelePay(
        @RequestBody TelePayForm dom
    ){
        TelePayEntity result = telePayService.modTelePay(dom);
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
