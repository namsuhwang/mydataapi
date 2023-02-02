package com.abcc.mydataapi.api.base.insu.controller;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuPayEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuPayForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuPaySearch;
import com.abcc.mydataapi.api.base.insu.service.InsuPayService;
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
@RequestMapping(value = "/insuPay", produces="application/json;charset=UTF-8")
public class InsuPayController {
    @Autowired
    InsuPayService insuPayService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuPayEntity>> regInsuPay(
        @RequestBody InsuPayForm dom
    ){
        insuPayService.regInsuPay(dom);
        InsuPayEntity result = insuPayService.getInsuPay(new InsuPaySearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuPayEntity>> modInsuPay(
        @RequestBody InsuPayForm dom
    ){
        insuPayService.modInsuPay(dom);
        InsuPayEntity result = insuPayService.getInsuPay(new InsuPaySearch(dom));
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
