package com.albee.mydataapi.api.base.insu.controller;

import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdGurtEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuInsdGurtForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuInsdGurtSearch;
import com.albee.mydataapi.api.base.insu.service.InsuInsdGurtService;
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
@RequestMapping(value = "/insuInsdGurt", produces="application/json;charset=UTF-8")
public class InsuInsdGurtController {
    @Autowired
    InsuInsdGurtService insuInsdGurtService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuInsdGurtEntity>> regInsuInsdGurt(
        @RequestBody InsuInsdGurtForm dom
    ){
        insuInsdGurtService.regInsuInsdGurt(dom);
        InsuInsdGurtEntity result = insuInsdGurtService.getInsuInsdGurt(new InsuInsdGurtSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuInsdGurtEntity>> modInsuInsdGurt(
        @RequestBody InsuInsdGurtForm dom
    ){
        insuInsdGurtService.modInsuInsdGurt(dom);
        InsuInsdGurtEntity result = insuInsdGurtService.getInsuInsdGurt(new InsuInsdGurtSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuInsdGurtEntity>> getInsuInsdGurt(
        @RequestBody InsuInsdGurtSearch dom
    ){
        InsuInsdGurtEntity result = insuInsdGurtService.getInsuInsdGurt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuInsdGurtEntity>>> getInsuInsdGurtList(
        @RequestBody InsuInsdGurtSearch dom
    ){
        ResultListDto<InsuInsdGurtEntity> resultList = insuInsdGurtService.getInsuInsdGurtList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
