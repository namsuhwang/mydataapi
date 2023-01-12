package com.kpcnc.mydataapi.api.load.insu.controller;

import com.kpcnc.mydataapi.api.load.insu.models.InsuPaySearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuPayEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuPayForm;
import com.kpcnc.mydataapi.api.load.insu.service.InsuPayService;
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
@RequestMapping(value = "/insuPay", produces="application/json;charset=UTF-8")
public class InsuPayController {
    @Autowired
    InsuPayService insuPayService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuPayEntity>> regInsuPay(
        @RequestBody InsuPayForm dom
    ){
        InsuPayEntity result = insuPayService.regInsuPay(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuPayEntity>> modInsuPay(
        @RequestBody InsuPayForm dom
    ){
        InsuPayEntity result = insuPayService.modInsuPay(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuPayEntity>> getInsuPay(
        @RequestBody InsuPaySearch dom
    ){
        InsuPayEntity result = insuPayService.getInsuPay(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuPayEntity>>> getInsuPayList(
        @RequestBody InsuPaySearch dom
    ){
        ResultListDto<InsuPayEntity> resultList = insuPayService.getInsuPayList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
