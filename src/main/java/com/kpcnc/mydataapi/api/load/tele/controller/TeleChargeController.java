package com.kpcnc.mydataapi.api.load.tele.controller;

import com.kpcnc.mydataapi.api.load.tele.models.TeleChargeSearch;
import com.kpcnc.mydataapi.api.load.tele.models.entity.TeleChargeEntity;
import com.kpcnc.mydataapi.api.load.tele.models.form.TeleChargeForm;
import com.kpcnc.mydataapi.api.load.tele.service.TeleChargeService;
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
@RequestMapping(value = "/teleCharge", produces="application/json;charset=UTF-8")
public class TeleChargeController {
    @Autowired
    TeleChargeService teleChargeService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<TeleChargeEntity>> regTeleCharge(
        @RequestBody TeleChargeForm dom
    ){
        TeleChargeEntity result = teleChargeService.regTeleCharge(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<TeleChargeEntity>> modTeleCharge(
        @RequestBody TeleChargeForm dom
    ){
        TeleChargeEntity result = teleChargeService.modTeleCharge(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<TeleChargeEntity>> getTeleCharge(
        @RequestBody TeleChargeSearch dom
    ){
        TeleChargeEntity result = teleChargeService.getTeleCharge(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<TeleChargeEntity>>> getTeleChargeList(
        @RequestBody TeleChargeSearch dom
    ){
        ResultListDto<TeleChargeEntity> resultList = teleChargeService.getTeleChargeList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
