package com.albee.mydataapi.api.base.insu.controller;

import com.albee.mydataapi.api.base.insu.models.entity.InsuGurtEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuGurtForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuGurtSearch;
import com.albee.mydataapi.api.base.insu.service.InsuGurtService;
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
@RequestMapping(value = "/insuGurt", produces="application/json;charset=UTF-8")
public class InsuGurtController {
    @Autowired
    InsuGurtService insuGurtService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuGurtEntity>> regInsuGurt(
        @RequestBody InsuGurtForm dom
    ){
        insuGurtService.regInsuGurt(dom);
        InsuGurtEntity result = insuGurtService.getInsuGurt(new InsuGurtSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuGurtEntity>> modInsuGurt(
        @RequestBody InsuGurtForm dom
    ){
        insuGurtService.modInsuGurt(dom);
        InsuGurtEntity result = insuGurtService.getInsuGurt(new InsuGurtSearch(dom));
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
