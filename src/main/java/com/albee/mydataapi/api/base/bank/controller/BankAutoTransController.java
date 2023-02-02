package com.albee.mydataapi.api.base.bank.controller;

import com.albee.mydataapi.api.base.bank.models.BankAutoTransSearch;
import com.albee.mydataapi.api.base.bank.models.entity.BankAutoTransEntity;
import com.albee.mydataapi.api.base.bank.models.form.BankAutoTransForm;
import com.albee.mydataapi.api.base.bank.service.BankAutoTransService;
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
@RequestMapping(value = "/bankAutoTrans", produces="application/json;charset=UTF-8")
public class BankAutoTransController {
    @Autowired
    BankAutoTransService bankAutoTransService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BankAutoTransEntity>> regBankAutoTrans(
        @RequestBody BankAutoTransForm dom
    ){
        bankAutoTransService.regBankAutoTrans(dom);
        BankAutoTransEntity result = bankAutoTransService.getBankAutoTransLast(new BankAutoTransSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BankAutoTransEntity>> modBankAutoTrans(
        @RequestBody BankAutoTransForm dom
    ){
        bankAutoTransService.modBankAutoTrans(dom);
        BankAutoTransEntity result = bankAutoTransService.getBankAutoTransLast(new BankAutoTransSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BankAutoTransEntity>> getBankAutoTrans(
        @RequestBody BankAutoTransSearch dom
    ){
        BankAutoTransEntity result = bankAutoTransService.getBankAutoTrans(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BankAutoTransEntity>>> getBankAutoTransList(
        @RequestBody BankAutoTransSearch dom
    ){
        ResultListDto<BankAutoTransEntity> resultList = bankAutoTransService.getBankAutoTransList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
