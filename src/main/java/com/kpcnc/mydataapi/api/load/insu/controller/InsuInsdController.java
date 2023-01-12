package com.kpcnc.mydataapi.api.load.insu.controller;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdForm;
import com.kpcnc.mydataapi.api.load.insu.service.InsuInsdService;
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
@RequestMapping(value = "/insuInsd", produces="application/json;charset=UTF-8")
public class InsuInsdController {
    @Autowired
    InsuInsdService insuInsdService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuInsdEntity>> regInsuInsd(
        @RequestBody InsuInsdForm dom
    ){
        InsuInsdEntity result = insuInsdService.regInsuInsd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuInsdEntity>> modInsuInsd(
        @RequestBody InsuInsdForm dom
    ){
        InsuInsdEntity result = insuInsdService.modInsuInsd(dom);
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
