package com.abcc.mydataapi.api.base.insu.controller;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuBaseEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuBaseForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuBaseSearch;
import com.abcc.mydataapi.api.base.insu.service.InsuBaseService;
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
@RequestMapping(value = "/insuBase", produces="application/json;charset=UTF-8")
public class InsuBaseController {
    @Autowired
    InsuBaseService insuBaseService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuBaseEntity>> regInsuBase(
        @RequestBody InsuBaseForm dom
    ){
        insuBaseService.regInsuBase(dom);
        InsuBaseEntity result = insuBaseService.getInsuBase(new InsuBaseSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuBaseEntity>> modInsuBase(
        @RequestBody InsuBaseForm dom
    ){
        insuBaseService.modInsuBase(dom);
        InsuBaseEntity result = insuBaseService.getInsuBase(new InsuBaseSearch(dom));
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
