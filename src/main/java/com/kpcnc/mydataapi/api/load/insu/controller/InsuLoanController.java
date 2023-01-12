package com.kpcnc.mydataapi.api.load.insu.controller;

import com.kpcnc.mydataapi.api.load.insu.models.InsuLoanSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuLoanEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuLoanForm;
import com.kpcnc.mydataapi.api.load.insu.service.InsuLoanService;
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
@RequestMapping(value = "/insuLoan", produces="application/json;charset=UTF-8")
public class InsuLoanController {
    @Autowired
    InsuLoanService insuLoanService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuLoanEntity>> regInsuLoan(
        @RequestBody InsuLoanForm dom
    ){
        InsuLoanEntity result = insuLoanService.regInsuLoan(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuLoanEntity>> modInsuLoan(
        @RequestBody InsuLoanForm dom
    ){
        InsuLoanEntity result = insuLoanService.modInsuLoan(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuLoanEntity>> getInsuLoan(
        @RequestBody InsuLoanSearch dom
    ){
        InsuLoanEntity result = insuLoanService.getInsuLoan(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuLoanEntity>>> getInsuLoanList(
        @RequestBody InsuLoanSearch dom
    ){
        ResultListDto<InsuLoanEntity> resultList = insuLoanService.getInsuLoanList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
