package com.albee.mydataapi.api.base.insu.controller;

import com.albee.mydataapi.api.base.insu.models.entity.InsuLoanHistEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuLoanHistForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuLoanHistSearch;
import com.albee.mydataapi.api.base.insu.service.InsuLoanHistService;
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
@RequestMapping(value = "/insuLoanHist", produces="application/json;charset=UTF-8")
public class InsuLoanHistController {
    @Autowired
    InsuLoanHistService insuLoanHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuLoanHistEntity>> regInsuLoanHist(
        @RequestBody InsuLoanHistForm dom
    ){
        insuLoanHistService.regInsuLoanHist(dom);
        InsuLoanHistEntity result = insuLoanHistService.getInsuLoanHist(new InsuLoanHistSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuLoanHistEntity>> modInsuLoanHist(
        @RequestBody InsuLoanHistForm dom
    ){
        insuLoanHistService.modInsuLoanHist(dom);
        InsuLoanHistEntity result = insuLoanHistService.getInsuLoanHist(new InsuLoanHistSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuLoanHistEntity>> getInsuLoanHist(
        @RequestBody InsuLoanHistSearch dom
    ){
        InsuLoanHistEntity result = insuLoanHistService.getInsuLoanHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuLoanHistEntity>>> getInsuLoanHistList(
        @RequestBody InsuLoanHistSearch dom
    ){
        ResultListDto<InsuLoanHistEntity> resultList = insuLoanHistService.getInsuLoanHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
