package com.kpcnc.mydataapi.api.base.insu.controller;

import com.kpcnc.mydataapi.api.base.insu.models.InsuLoanAddSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuLoanAddEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuLoanAddForm;
import com.kpcnc.mydataapi.api.base.insu.service.InsuLoanAddService;
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
@RequestMapping(value = "/insuLoanAdd", produces="application/json;charset=UTF-8")
public class InsuLoanAddController {
    @Autowired
    InsuLoanAddService insuLoanAddService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuLoanAddEntity>> regInsuLoanAdd(
        @RequestBody InsuLoanAddForm dom
    ){
        insuLoanAddService.regInsuLoanAdd(dom);
        InsuLoanAddEntity result = insuLoanAddService.getInsuLoanAdd(new InsuLoanAddSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuLoanAddEntity>> modInsuLoanAdd(
        @RequestBody InsuLoanAddForm dom
    ){
        insuLoanAddService.modInsuLoanAdd(dom);
        InsuLoanAddEntity result = insuLoanAddService.getInsuLoanAdd(new InsuLoanAddSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuLoanAddEntity>> getInsuLoanAdd(
        @RequestBody InsuLoanAddSearch dom
    ){
        InsuLoanAddEntity result = insuLoanAddService.getInsuLoanAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuLoanAddEntity>>> getInsuLoanAddList(
        @RequestBody InsuLoanAddSearch dom
    ){
        ResultListDto<InsuLoanAddEntity> resultList = insuLoanAddService.getInsuLoanAddList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
