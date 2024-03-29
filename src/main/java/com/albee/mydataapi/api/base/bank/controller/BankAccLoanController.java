package com.albee.mydataapi.api.base.bank.controller;

import com.albee.mydataapi.api.base.bank.models.BankAccLoanSearch;
import com.albee.mydataapi.api.base.bank.models.entity.BankAccLoanEntity;
import com.albee.mydataapi.api.base.bank.service.BankAccLoanService;
import com.albee.mydataapi.api.base.bank.models.form.BankAccLoanForm;
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
@RequestMapping(value = "/bankAccLoan", produces="application/json;charset=UTF-8")
public class BankAccLoanController {
    @Autowired
    BankAccLoanService bankAccLoanService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BankAccLoanEntity>> regBankAccLoan(
        @RequestBody BankAccLoanForm dom
    ){
        BankAccLoanEntity result = bankAccLoanService.regBankAccLoan(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BankAccLoanEntity>> modBankAccLoan(
        @RequestBody BankAccLoanForm dom
    ){
        BankAccLoanEntity result = bankAccLoanService.modBankAccLoan(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BankAccLoanEntity>> getBankAccLoan(
        @RequestBody BankAccLoanSearch dom
    ){
        BankAccLoanEntity result = bankAccLoanService.getBankAccLoan(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BankAccLoanEntity>>> getBankAccLoanList(
        @RequestBody BankAccLoanSearch dom
    ){
        ResultListDto<BankAccLoanEntity> resultList = bankAccLoanService.getBankAccLoanList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
