package com.abcc.mydataapi.api.base.bank.controller;

import com.abcc.mydataapi.api.base.bank.models.form.BankAccLoanHistForm;
import com.abcc.mydataapi.api.base.bank.models.BankAccLoanHistSearch;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccLoanHistEntity;
import com.abcc.mydataapi.api.base.bank.service.BankAccLoanHistService;
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
@RequestMapping(value = "/bankAccLoanHist", produces="application/json;charset=UTF-8")
public class BankAccLoanHistController {
    @Autowired
    BankAccLoanHistService bankAccLoanHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BankAccLoanHistEntity>> regBankAccLoanHist(
        @RequestBody BankAccLoanHistForm dom
    ){
        BankAccLoanHistEntity result = bankAccLoanHistService.regBankAccLoanHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BankAccLoanHistEntity>> modBankAccLoanHist(
        @RequestBody BankAccLoanHistForm dom
    ){
        BankAccLoanHistEntity result = bankAccLoanHistService.modBankAccLoanHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BankAccLoanHistEntity>> getBankAccLoanHist(
        @RequestBody BankAccLoanHistSearch dom
    ){
        BankAccLoanHistEntity result = bankAccLoanHistService.getBankAccLoanHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BankAccLoanHistEntity>>> getBankAccLoanHistList(
        @RequestBody BankAccLoanHistSearch dom
    ){
        ResultListDto<BankAccLoanHistEntity> resultList = bankAccLoanHistService.getBankAccLoanHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
