package com.abcc.mydataapi.api.base.bank.controller;

import com.abcc.mydataapi.api.base.bank.models.BankAccFundSearch;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccFundEntity;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccFundForm;
import com.abcc.mydataapi.api.base.bank.service.BankAccFundService;
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
@RequestMapping(value = "/bankAccFund", produces="application/json;charset=UTF-8")
public class BankAccFundController {
    @Autowired
    BankAccFundService bankAccFundService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BankAccFundEntity>> regBankAccFund(
        @RequestBody BankAccFundForm dom
    ){
        BankAccFundEntity result = bankAccFundService.regBankAccFund(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BankAccFundEntity>> modBankAccFund(
        @RequestBody BankAccFundForm dom
    ){
        BankAccFundEntity result = bankAccFundService.modBankAccFund(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BankAccFundEntity>> getBankAccFund(
        @RequestBody BankAccFundSearch dom
    ){
        BankAccFundEntity result = bankAccFundService.getBankAccFund(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BankAccFundEntity>>> getBankAccFundList(
        @RequestBody BankAccFundSearch dom
    ){
        ResultListDto<BankAccFundEntity> resultList = bankAccFundService.getBankAccFundList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
