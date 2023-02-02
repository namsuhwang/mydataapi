package com.albee.mydataapi.api.base.bank.controller;

import com.albee.mydataapi.api.base.bank.models.BankAccDepositAddSearch;
import com.albee.mydataapi.api.base.bank.models.entity.BankAccDepositAddEntity;
import com.albee.mydataapi.api.base.bank.service.BankAccDepositAddService;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.bank.models.form.BankAccDepositAddForm;
import com.albee.mydataapi.common.models.dto.ResponseDto;
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
@RequestMapping(value = "/bankAccDepositAdd", produces="application/json;charset=UTF-8")
public class BankAccDepositAddController {
    @Autowired
    BankAccDepositAddService bankAccDepositAddService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BankAccDepositAddEntity>> regBankAccDepositAdd(
        @RequestBody BankAccDepositAddForm dom
    ){
        bankAccDepositAddService.regBankAccDepositAdd(dom);
        BankAccDepositAddEntity result = bankAccDepositAddService.getBankAccDepositAdd(new BankAccDepositAddSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BankAccDepositAddEntity>> modBankAccDepositAdd(
        @RequestBody BankAccDepositAddForm dom
    ){
        bankAccDepositAddService.modBankAccDepositAdd(dom);
        BankAccDepositAddEntity result = bankAccDepositAddService.getBankAccDepositAdd(new BankAccDepositAddSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BankAccDepositAddEntity>> getBankAccDepositAdd(
        @RequestBody BankAccDepositAddSearch dom
    ){
        BankAccDepositAddEntity result = bankAccDepositAddService.getBankAccDepositAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BankAccDepositAddEntity>>> getBankAccDepositAddList(
        @RequestBody BankAccDepositAddSearch dom
    ){
        ResultListDto<BankAccDepositAddEntity> resultList = bankAccDepositAddService.getBankAccDepositAddList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
