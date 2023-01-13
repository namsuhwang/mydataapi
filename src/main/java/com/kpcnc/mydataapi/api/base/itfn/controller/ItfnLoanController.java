package com.kpcnc.mydataapi.api.base.itfn.controller;

import com.kpcnc.mydataapi.api.base.itfn.models.ItfnLoanSearch;
import com.kpcnc.mydataapi.api.base.itfn.models.entity.ItfnLoanEntity;
import com.kpcnc.mydataapi.api.base.itfn.models.form.ItfnLoanForm;
import com.kpcnc.mydataapi.api.base.itfn.service.ItfnLoanService;
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
@RequestMapping(value = "/itfnLoan", produces="application/json;charset=UTF-8")
public class ItfnLoanController {
    @Autowired
    ItfnLoanService itfnLoanService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ItfnLoanEntity>> regItfnLoan(
        @RequestBody ItfnLoanForm dom
    ){
        ItfnLoanEntity result = itfnLoanService.regItfnLoan(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ItfnLoanEntity>> modItfnLoan(
        @RequestBody ItfnLoanForm dom
    ){
        ItfnLoanEntity result = itfnLoanService.modItfnLoan(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<ItfnLoanEntity>> getItfnLoan(
        @RequestBody ItfnLoanSearch dom
    ){
        ItfnLoanEntity result = itfnLoanService.getItfnLoan(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<ItfnLoanEntity>>> getItfnLoanList(
        @RequestBody ItfnLoanSearch dom
    ){
        ResultListDto<ItfnLoanEntity> resultList = itfnLoanService.getItfnLoanList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
