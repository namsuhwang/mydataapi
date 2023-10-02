package com.albee.mydataapi.api.base.bank.controller;

import com.albee.mydataapi.api.base.bank.models.BankAccLoanHistIntSearch;
import com.albee.mydataapi.api.base.bank.models.entity.BankAccLoanHistIntEntity;
import com.albee.mydataapi.api.base.bank.service.BankAccLoanHistIntService;
import com.albee.mydataapi.api.base.bank.models.form.BankAccLoanHistIntForm;
import com.albee.mydataapi.common.models.dto.ResponseDto;
import com.albee.mydataapi.common.models.dto.ResultListDto;
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
@RequestMapping(value = "/bankAccLoanHistInt", produces="application/json;charset=UTF-8")
public class BankAccLoanHistIntController {
    @Autowired
    BankAccLoanHistIntService bankAccLoanHistIntService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BankAccLoanHistIntEntity>> regBankAccLoanHistInt(
        @RequestBody BankAccLoanHistIntForm dom
    ){
        BankAccLoanHistIntEntity result = bankAccLoanHistIntService.regBankAccLoanHistInt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BankAccLoanHistIntEntity>> modBankAccLoanHistInt(
        @RequestBody BankAccLoanHistIntForm dom
    ){
        BankAccLoanHistIntEntity result = bankAccLoanHistIntService.modBankAccLoanHistInt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BankAccLoanHistIntEntity>> getBankAccLoanHistInt(
        @RequestBody BankAccLoanHistIntSearch dom
    ){
        BankAccLoanHistIntEntity result = bankAccLoanHistIntService.getBankAccLoanHistInt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BankAccLoanHistIntEntity>>> getBankAccLoanHistIntList(
        @RequestBody BankAccLoanHistIntSearch dom
    ){
        ResultListDto<BankAccLoanHistIntEntity> resultList = bankAccLoanHistIntService.getBankAccLoanHistIntList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
