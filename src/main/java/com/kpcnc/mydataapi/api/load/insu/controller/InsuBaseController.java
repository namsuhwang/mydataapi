package com.kpcnc.mydataapi.api.load.insu.controller;

import com.kpcnc.mydataapi.api.load.insu.models.InsuBaseSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuBaseEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuBaseForm;
import com.kpcnc.mydataapi.api.load.insu.service.InsuBaseService;
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
@RequestMapping(value = "/insuBase", produces="application/json;charset=UTF-8")
public class InsuBaseController {
    @Autowired
    InsuBaseService insuBaseService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuBaseEntity>> regInsuBase(
        @RequestBody InsuBaseForm dom
    ){
        InsuBaseEntity result = insuBaseService.regInsuBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuBaseEntity>> modInsuBase(
        @RequestBody InsuBaseForm dom
    ){
        InsuBaseEntity result = insuBaseService.modInsuBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuBaseEntity>> getInsuBase(
        @RequestBody InsuBaseSearch dom
    ){
        InsuBaseEntity result = insuBaseService.getInsuBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuBaseEntity>>> getInsuBaseList(
        @RequestBody InsuBaseSearch dom
    ){
        ResultListDto<InsuBaseEntity> resultList = insuBaseService.getInsuBaseList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
