package com.abcc.mydataapi.api.base.bank.controller;

import com.abcc.mydataapi.api.base.bank.models.BankAccEachProdSearch;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccEachProdEntity;
import com.abcc.mydataapi.api.base.bank.service.BankAccEachProdService;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccEachProdForm;
import com.abcc.mydataapi.common.models.dto.ResponseDto;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@RestController
@EnableWebMvc
@RequiredArgsConstructor
@RequestMapping(value = "/bankAccEachProd", produces="application/json;charset=UTF-8")
public class BankAccEachProdController {
    @Autowired
    BankAccEachProdService bankAccEachProdService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BankAccEachProdEntity>> regBankAccEachProd(
        @RequestBody BankAccEachProdForm dom
    ){
        BankAccEachProdEntity result = bankAccEachProdService.regBankAccEachProd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BankAccEachProdEntity>> modBankAccEachProd(
        @RequestBody BankAccEachProdForm dom
    ){
        BankAccEachProdEntity result = bankAccEachProdService.modBankAccEachProd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BankAccEachProdEntity>> getBankAccEachProd(
        @RequestBody BankAccEachProdSearch dom
    ){
        BankAccEachProdEntity result = bankAccEachProdService.getBankAccEachProd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BankAccEachProdEntity>>> getBankAccEachProdList(
        @RequestBody BankAccEachProdSearch dom
    ){
        ResultListDto<BankAccEachProdEntity> resultList = bankAccEachProdService.getBankAccEachProdList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
