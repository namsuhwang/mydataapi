package com.albee.mydataapi.api.base.insu.controller;

import com.albee.mydataapi.api.base.insu.models.entity.InsuBaseInsdEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuBaseInsdForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuBaseInsdSearch;
import com.albee.mydataapi.api.base.insu.service.InsuBaseInsdService;
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
@RequestMapping(value = "/insuBaseInsd", produces="application/json;charset=UTF-8")
public class InsuBaseInsdController {
    @Autowired
    InsuBaseInsdService insuBaseInsdService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuBaseInsdEntity>> regInsuBaseInsd(
        @RequestBody InsuBaseInsdForm dom
    ){
        insuBaseInsdService.regInsuBaseInsd(dom);
        InsuBaseInsdEntity result = insuBaseInsdService.getInsuBaseInsd(new InsuBaseInsdSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuBaseInsdEntity>> modInsuBaseInsd(
        @RequestBody InsuBaseInsdForm dom
    ){
        insuBaseInsdService.modInsuBaseInsd(dom);
        InsuBaseInsdEntity result = insuBaseInsdService.getInsuBaseInsd(new InsuBaseInsdSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuBaseInsdEntity>> getInsuBaseInsd(
        @RequestBody InsuBaseInsdSearch dom
    ){
        InsuBaseInsdEntity result = insuBaseInsdService.getInsuBaseInsd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuBaseInsdEntity>>> getInsuBaseInsdList(
        @RequestBody InsuBaseInsdSearch dom
    ){
        ResultListDto<InsuBaseInsdEntity> resultList = insuBaseInsdService.getInsuBaseInsdList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
