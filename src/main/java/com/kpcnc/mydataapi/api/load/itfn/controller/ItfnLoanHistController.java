package com.kpcnc.mydataapi.api.load.itfn.controller;

import com.kpcnc.mydataapi.api.load.itfn.models.ItfnLoanHistSearch;
import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnLoanHistEntity;
import com.kpcnc.mydataapi.api.load.itfn.models.form.ItfnLoanHistForm;
import com.kpcnc.mydataapi.api.load.itfn.service.ItfnLoanHistService;
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
@RequestMapping(value = "/itfnLoanHist", produces="application/json;charset=UTF-8")
public class ItfnLoanHistController {
    @Autowired
    ItfnLoanHistService itfnLoanHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ItfnLoanHistEntity>> regItfnLoanHist(
        @RequestBody ItfnLoanHistForm dom
    ){
        ItfnLoanHistEntity result = itfnLoanHistService.regItfnLoanHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ItfnLoanHistEntity>> modItfnLoanHist(
        @RequestBody ItfnLoanHistForm dom
    ){
        ItfnLoanHistEntity result = itfnLoanHistService.modItfnLoanHist(dom);
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
