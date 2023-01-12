package com.kpcnc.mydataapi.api.load.bank.controller;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccDepositAddSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccDepositAddEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccDepositAddForm;
import com.kpcnc.mydataapi.api.load.bank.service.BankAccDepositAddService;
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

import java.util.List;

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
        BankAccDepositAddEntity result = bankAccDepositAddService.regBankAccDepositAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BankAccDepositAddEntity>> modBankAccDepositAdd(
        @RequestBody BankAccDepositAddForm dom
    ){
        BankAccDepositAddEntity result = bankAccDepositAddService.modBankAccDepositAdd(dom);
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
