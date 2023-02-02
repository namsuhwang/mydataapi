package com.abcc.mydataapi.api.base.itfn.controller;

import com.abcc.mydataapi.api.base.itfn.models.ItfnLoanHistIntSearch;
import com.abcc.mydataapi.api.base.itfn.models.entity.ItfnLoanHistIntEntity;
import com.abcc.mydataapi.api.base.itfn.models.form.ItfnLoanHistIntForm;
import com.abcc.mydataapi.api.base.itfn.service.ItfnLoanHistIntService;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
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
@RequestMapping(value = "/itfnLoanHistInt", produces="application/json;charset=UTF-8")
public class ItfnLoanHistIntController {
    @Autowired
    ItfnLoanHistIntService itfnLoanHistIntService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ItfnLoanHistIntEntity>> regItfnLoanHistInt(
        @RequestBody ItfnLoanHistIntForm dom
    ){
        itfnLoanHistIntService.regItfnLoanHistInt(dom);
        ItfnLoanHistIntEntity result = itfnLoanHistIntService.getItfnLoanHistInt(new ItfnLoanHistIntSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ItfnLoanHistIntEntity>> modItfnLoanHistInt(
        @RequestBody ItfnLoanHistIntForm dom
    ){
        itfnLoanHistIntService.modItfnLoanHistInt(dom);
        ItfnLoanHistIntEntity result = itfnLoanHistIntService.getItfnLoanHistInt(new ItfnLoanHistIntSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<ItfnLoanHistIntEntity>> getItfnLoanHistInt(
        @RequestBody ItfnLoanHistIntSearch dom
    ){
        ItfnLoanHistIntEntity result = itfnLoanHistIntService.getItfnLoanHistInt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<ItfnLoanHistIntEntity>>> getItfnLoanHistIntList(
        @RequestBody ItfnLoanHistIntSearch dom
    ){
        ResultListDto<ItfnLoanHistIntEntity> resultList = itfnLoanHistIntService.getItfnLoanHistIntList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
