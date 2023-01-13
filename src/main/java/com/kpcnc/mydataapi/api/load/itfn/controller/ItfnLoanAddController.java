package com.kpcnc.mydataapi.api.load.itfn.controller;

import com.kpcnc.mydataapi.api.load.itfn.models.ItfnLoanAddSearch;
import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnLoanAddEntity;
import com.kpcnc.mydataapi.api.load.itfn.models.form.ItfnLoanAddForm;
import com.kpcnc.mydataapi.api.load.itfn.service.ItfnLoanAddService;
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
@RequestMapping(value = "/itfnLoanAdd", produces="application/json;charset=UTF-8")
public class ItfnLoanAddController {
    @Autowired
    ItfnLoanAddService itfnLoanAddService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ItfnLoanAddEntity>> regItfnLoanAdd(
        @RequestBody ItfnLoanAddForm dom
    ){
        ItfnLoanAddEntity result = itfnLoanAddService.regItfnLoanAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ItfnLoanAddEntity>> modItfnLoanAdd(
        @RequestBody ItfnLoanAddForm dom
    ){
        ItfnLoanAddEntity result = itfnLoanAddService.modItfnLoanAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<ItfnLoanAddEntity>> getItfnLoanAdd(
        @RequestBody ItfnLoanAddSearch dom
    ){
        ItfnLoanAddEntity result = itfnLoanAddService.getItfnLoanAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<ItfnLoanAddEntity>>> getItfnLoanAddList(
        @RequestBody ItfnLoanAddSearch dom
    ){
        ResultListDto<ItfnLoanAddEntity> resultList = itfnLoanAddService.getItfnLoanAddList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
