package com.kpcnc.mydataapi.api.base.insu.controller;

import com.kpcnc.mydataapi.api.base.insu.models.InsuInsdBaseSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdBaseEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuInsdBaseForm;
import com.kpcnc.mydataapi.api.base.insu.service.InsuInsdBaseService;
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
@RequestMapping(value = "/insuInsdBase", produces="application/json;charset=UTF-8")
public class InsuInsdBaseController {
    @Autowired
    InsuInsdBaseService insuInsdBaseService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuInsdBaseEntity>> regInsuInsdBase(
        @RequestBody InsuInsdBaseForm dom
    ){
        InsuInsdBaseEntity result = insuInsdBaseService.regInsuInsdBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuInsdBaseEntity>> modInsuInsdBase(
        @RequestBody InsuInsdBaseForm dom
    ){
        InsuInsdBaseEntity result = insuInsdBaseService.modInsuInsdBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuInsdBaseEntity>> getInsuInsdBase(
        @RequestBody InsuInsdBaseSearch dom
    ){
        InsuInsdBaseEntity result = insuInsdBaseService.getInsuInsdBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuInsdBaseEntity>>> getInsuInsdBaseList(
        @RequestBody InsuInsdBaseSearch dom
    ){
        ResultListDto<InsuInsdBaseEntity> resultList = insuInsdBaseService.getInsuInsdBaseList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
