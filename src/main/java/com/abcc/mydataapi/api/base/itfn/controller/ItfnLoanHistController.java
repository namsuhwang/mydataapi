package com.abcc.mydataapi.api.base.itfn.controller;

import com.abcc.mydataapi.api.base.itfn.models.entity.ItfnLoanHistEntity;
import com.abcc.mydataapi.api.base.itfn.models.form.ItfnLoanHistForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.itfn.models.ItfnLoanHistSearch;
import com.abcc.mydataapi.api.base.itfn.service.ItfnLoanHistService;
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
@RequestMapping(value = "/itfnLoanHist", produces="application/json;charset=UTF-8")
public class ItfnLoanHistController {
    @Autowired
    ItfnLoanHistService itfnLoanHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ItfnLoanHistEntity>> regItfnLoanHist(
        @RequestBody ItfnLoanHistForm dom
    ){
        itfnLoanHistService.regItfnLoanHist(dom);
        ItfnLoanHistEntity result = itfnLoanHistService.getItfnLoanHist(new ItfnLoanHistSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ItfnLoanHistEntity>> modItfnLoanHist(
        @RequestBody ItfnLoanHistForm dom
    ){
        itfnLoanHistService.modItfnLoanHist(dom);
        ItfnLoanHistEntity result = itfnLoanHistService.getItfnLoanHist(new ItfnLoanHistSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<ItfnLoanHistEntity>> getItfnLoanHist(
        @RequestBody ItfnLoanHistSearch dom
    ){
        ItfnLoanHistEntity result = itfnLoanHistService.getItfnLoanHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<ItfnLoanHistEntity>>> getItfnLoanHistList(
        @RequestBody ItfnLoanHistSearch dom
    ){
        ResultListDto<ItfnLoanHistEntity> resultList = itfnLoanHistService.getItfnLoanHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
