package com.kpcnc.mydataapi.api.base.bank.controller;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccDepositHistSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccDepositHistEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccDepositHistForm;
import com.kpcnc.mydataapi.api.base.bank.service.BankAccDepositHistService;
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
@RequestMapping(value = "/bankAccDepositHist", produces="application/json;charset=UTF-8")
public class BankAccDepositHistController {
    @Autowired
    BankAccDepositHistService bankAccDepositHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BankAccDepositHistEntity>> regBankAccDepositHist(
        @RequestBody BankAccDepositHistForm dom
    ){
        BankAccDepositHistEntity result = bankAccDepositHistService.regBankAccDepositHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BankAccDepositHistEntity>> modBankAccDepositHist(
        @RequestBody BankAccDepositHistForm dom
    ){
        BankAccDepositHistEntity result = bankAccDepositHistService.modBankAccDepositHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BankAccDepositHistEntity>> getBankAccDepositHist(
        @RequestBody BankAccDepositHistSearch dom
    ){
        BankAccDepositHistEntity result = bankAccDepositHistService.getBankAccDepositHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BankAccDepositHistEntity>>> getBankAccDepositHistList(
        @RequestBody BankAccDepositHistSearch dom
    ){
        ResultListDto<BankAccDepositHistEntity> resultList = bankAccDepositHistService.getBankAccDepositHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
