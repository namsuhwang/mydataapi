package com.abcc.mydataapi.api.base.insu.controller;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuLoanBaseEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuLoanBaseForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuLoanBaseSearch;
import com.abcc.mydataapi.api.base.insu.service.InsuLoanBaseService;
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
@RequestMapping(value = "/insuLoanBase", produces="application/json;charset=UTF-8")
public class InsuLoanBaseController {
    @Autowired
    InsuLoanBaseService insuLoanBaseService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuLoanBaseEntity>> regInsuLoanBase(
        @RequestBody InsuLoanBaseForm dom
    ){
        insuLoanBaseService.regInsuLoanBase(dom);
        InsuLoanBaseEntity result = insuLoanBaseService.getInsuLoanBase(new InsuLoanBaseSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuLoanBaseEntity>> modInsuLoanBase(
        @RequestBody InsuLoanBaseForm dom
    ){
        insuLoanBaseService.modInsuLoanBase(dom);
        InsuLoanBaseEntity result = insuLoanBaseService.getInsuLoanBase(new InsuLoanBaseSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuLoanBaseEntity>> getInsuLoanBase(
        @RequestBody InsuLoanBaseSearch dom
    ){
        InsuLoanBaseEntity result = insuLoanBaseService.getInsuLoanBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuLoanBaseEntity>>> getInsuLoanBaseList(
        @RequestBody InsuLoanBaseSearch dom
    ){
        ResultListDto<InsuLoanBaseEntity> resultList = insuLoanBaseService.getInsuLoanBaseList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
