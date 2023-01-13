package com.kpcnc.mydataapi.api.base.insu.controller;

import com.kpcnc.mydataapi.api.base.insu.models.InsuSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuEntity;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuForm;
import com.kpcnc.mydataapi.api.base.insu.service.InsuService;
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
@RequestMapping(value = "/insu", produces="application/json;charset=UTF-8")
public class InsuController {
    @Autowired
    InsuService insuService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuEntity>> regInsu(
        @RequestBody InsuForm dom
    ){
        InsuEntity result = insuService.regInsu(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuEntity>> modInsu(
        @RequestBody InsuForm dom
    ){
        InsuEntity result = insuService.modInsu(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuEntity>> getInsu(
        @RequestBody InsuSearch dom
    ){
        InsuEntity result = insuService.getInsu(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuEntity>>> getInsuList(
        @RequestBody InsuSearch dom
    ){
        ResultListDto<InsuEntity> resultList = insuService.getInsuList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}