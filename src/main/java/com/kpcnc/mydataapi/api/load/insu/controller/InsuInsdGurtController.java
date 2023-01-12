package com.kpcnc.mydataapi.api.load.insu.controller;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdGurtSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdGurtEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdGurtForm;
import com.kpcnc.mydataapi.api.load.insu.service.InsuInsdGurtService;
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
@RequestMapping(value = "/insuInsdGurt", produces="application/json;charset=UTF-8")
public class InsuInsdGurtController {
    @Autowired
    InsuInsdGurtService insuInsdGurtService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuInsdGurtEntity>> regInsuInsdGurt(
        @RequestBody InsuInsdGurtForm dom
    ){
        InsuInsdGurtEntity result = insuInsdGurtService.regInsuInsdGurt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuInsdGurtEntity>> modInsuInsdGurt(
        @RequestBody InsuInsdGurtForm dom
    ){
        InsuInsdGurtEntity result = insuInsdGurtService.modInsuInsdGurt(dom);
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
