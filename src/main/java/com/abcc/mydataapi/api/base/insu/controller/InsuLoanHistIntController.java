package com.abcc.mydataapi.api.base.insu.controller;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuLoanHistIntEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuLoanHistIntForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuLoanHistIntSearch;
import com.abcc.mydataapi.api.base.insu.service.InsuLoanHistIntService;
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
@RequestMapping(value = "/insuLoanHistInt", produces="application/json;charset=UTF-8")
public class InsuLoanHistIntController {
    @Autowired
    InsuLoanHistIntService insuLoanHistIntService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuLoanHistIntEntity>> regInsuLoanHistInt(
        @RequestBody InsuLoanHistIntForm dom
    ){
        insuLoanHistIntService.regInsuLoanHistInt(dom);
        InsuLoanHistIntEntity result = insuLoanHistIntService.getInsuLoanHistInt(new InsuLoanHistIntSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuLoanHistIntEntity>> modInsuLoanHistInt(
        @RequestBody InsuLoanHistIntForm dom
    ){
        insuLoanHistIntService.modInsuLoanHistInt(dom);
        InsuLoanHistIntEntity result = insuLoanHistIntService.getInsuLoanHistInt(new InsuLoanHistIntSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuLoanHistIntEntity>> getInsuLoanHistInt(
        @RequestBody InsuLoanHistIntSearch dom
    ){
        InsuLoanHistIntEntity result = insuLoanHistIntService.getInsuLoanHistInt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuLoanHistIntEntity>>> getInsuLoanHistIntList(
        @RequestBody InsuLoanHistIntSearch dom
    ){
        ResultListDto<InsuLoanHistIntEntity> resultList = insuLoanHistIntService.getInsuLoanHistIntList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
