package com.kpcnc.mydataapi.api.base.insu.controller;

import com.kpcnc.mydataapi.api.base.insu.models.InsuGurtSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuGurtEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuGurtForm;
import com.kpcnc.mydataapi.api.base.insu.service.InsuGurtService;
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

@Slf4j
@RestController
@EnableWebMvc
@RequiredArgsConstructor
@RequestMapping(value = "/insuGurt", produces="application/json;charset=UTF-8")
public class InsuGurtController {
    @Autowired
    InsuGurtService insuGurtService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuGurtEntity>> regInsuGurt(
        @RequestBody InsuGurtForm dom
    ){
        InsuGurtEntity result = insuGurtService.regInsuGurt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuGurtEntity>> modInsuGurt(
        @RequestBody InsuGurtForm dom
    ){
        InsuGurtEntity result = insuGurtService.modInsuGurt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuGurtEntity>> getInsuGurt(
        @RequestBody InsuGurtSearch dom
    ){
        InsuGurtEntity result = insuGurtService.getInsuGurt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuGurtEntity>>> getInsuGurtList(
        @RequestBody InsuGurtSearch dom
    ){
        ResultListDto<InsuGurtEntity> resultList = insuGurtService.getInsuGurtList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
