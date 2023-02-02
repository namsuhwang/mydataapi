package com.abcc.mydataapi.api.base.insu.controller;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuInsdSearch;
import com.abcc.mydataapi.api.base.insu.models.entity.InsuInsdEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuInsdForm;
import com.abcc.mydataapi.api.base.insu.service.InsuInsdService;
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
@RequestMapping(value = "/insuInsd", produces="application/json;charset=UTF-8")
public class InsuInsdController {
    @Autowired
    InsuInsdService insuInsdService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuInsdEntity>> regInsuInsd(
        @RequestBody InsuInsdForm dom
    ){
        insuInsdService.regInsuInsd(dom);
        InsuInsdEntity result = insuInsdService.getInsuInsd(new InsuInsdSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuInsdEntity>> modInsuInsd(
        @RequestBody InsuInsdForm dom
    ){
        insuInsdService.modInsuInsd(dom);
        InsuInsdEntity result = insuInsdService.getInsuInsd(new InsuInsdSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuInsdEntity>> getInsuInsd(
        @RequestBody InsuInsdSearch dom
    ){
        InsuInsdEntity result = insuInsdService.getInsuInsd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuInsdEntity>>> getInsuInsdList(
        @RequestBody InsuInsdSearch dom
    ){
        ResultListDto<InsuInsdEntity> resultList = insuInsdService.getInsuInsdList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
