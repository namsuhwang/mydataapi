package com.abcc.mydataapi.api.base.bank.controller;

import com.abcc.mydataapi.api.base.bank.models.BankAccLoanAddSearch;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccLoanAddEntity;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccLoanAddForm;
import com.abcc.mydataapi.api.base.bank.service.BankAccLoanAddService;
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
@RequestMapping(value = "/bankAccLoanAdd", produces="application/json;charset=UTF-8")
public class BankAccLoanAddController {
    @Autowired
    BankAccLoanAddService bankAccLoanAddService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BankAccLoanAddEntity>> regBankAccLoanAdd(
        @RequestBody BankAccLoanAddForm dom
    ){
        BankAccLoanAddEntity result = bankAccLoanAddService.regBankAccLoanAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BankAccLoanAddEntity>> modBankAccLoanAdd(
        @RequestBody BankAccLoanAddForm dom
    ){
        BankAccLoanAddEntity result = bankAccLoanAddService.modBankAccLoanAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BankAccLoanAddEntity>> getBankAccLoanAdd(
        @RequestBody BankAccLoanAddSearch dom
    ){
        BankAccLoanAddEntity result = bankAccLoanAddService.getBankAccLoanAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BankAccLoanAddEntity>>> getBankAccLoanAddList(
        @RequestBody BankAccLoanAddSearch dom
    ){
        ResultListDto<BankAccLoanAddEntity> resultList = bankAccLoanAddService.getBankAccLoanAddList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
