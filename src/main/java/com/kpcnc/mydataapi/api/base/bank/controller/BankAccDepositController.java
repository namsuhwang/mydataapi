package com.kpcnc.mydataapi.api.base.bank.controller;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccDepositSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccDepositEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccDepositForm;
import com.kpcnc.mydataapi.api.base.bank.service.BankAccDepositService;
import com.kpcnc.mydataapi.common.models.dto.ResponseDto;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;
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
@RequestMapping(value = "/bankAccDeposit", produces="application/json;charset=UTF-8")
public class BankAccDepositController {
    @Autowired
    BankAccDepositService bankAccDepositService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BankAccDepositEntity>> regBankAccDeposit(
        @RequestBody BankAccDepositForm dom
    ){
        bankAccDepositService.regBankAccDeposit(dom);
        BankAccDepositEntity result = bankAccDepositService.getBankAccDeposit(new BankAccDepositSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BankAccDepositEntity>> modBankAccDeposit(
        @RequestBody BankAccDepositForm dom
    ){
        bankAccDepositService.modBankAccDeposit(dom);
        BankAccDepositEntity result = bankAccDepositService.getBankAccDeposit(new BankAccDepositSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BankAccDepositEntity>> getBankAccDeposit(
        @RequestBody BankAccDepositSearch dom
    ){
        BankAccDepositEntity result = bankAccDepositService.getBankAccDeposit(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BankAccDepositEntity>>> getBankAccDepositList(
        @RequestBody BankAccDepositSearch dom
    ){
        ResultListDto<BankAccDepositEntity> resultList = bankAccDepositService.getBankAccDepositList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
