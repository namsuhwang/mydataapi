package com.abcc.mydataapi.api.base.insu.controller;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuMiPayEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuMiPayForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuMiPaySearch;
import com.abcc.mydataapi.api.base.insu.service.InsuMiPayService;
import com.abcc.mydataapi.common.models.dto.ResponseDto;
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
@RequestMapping(value = "/insuMiPay", produces="application/json;charset=UTF-8")
public class InsuMiPayController {
    @Autowired
    InsuMiPayService insuMiPayService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuMiPayEntity>> regInsuMiPay(
        @RequestBody InsuMiPayForm dom
    ){
        InsuMiPayEntity result = insuMiPayService.regInsuMiPay(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuMiPayEntity>> modInsuMiPay(
        @RequestBody InsuMiPayForm dom
    ){
        InsuMiPayEntity result = insuMiPayService.modInsuMiPay(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuMiPayEntity>> getInsuMiPay(
        @RequestBody InsuMiPaySearch dom
    ){
        InsuMiPayEntity result = insuMiPayService.getInsuMiPay(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuMiPayEntity>>> getInsuMiPayList(
        @RequestBody InsuMiPaySearch dom
    ){
        ResultListDto<InsuMiPayEntity> resultList = insuMiPayService.getInsuMiPayList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
