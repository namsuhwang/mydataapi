package com.albee.mydataapi.api.base.bank.controller;

import com.albee.mydataapi.api.base.bank.models.BankAccFundAddSearch;
import com.albee.mydataapi.api.base.bank.models.entity.BankAccFundAddEntity;
import com.albee.mydataapi.api.base.bank.models.form.BankAccFundAddForm;
import com.albee.mydataapi.api.base.bank.service.BankAccFundAddService;
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
@RequestMapping(value = "/bankAccFundAdd", produces="application/json;charset=UTF-8")
public class BankAccFundAddController {
    @Autowired
    BankAccFundAddService bankAccFundAddService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BankAccFundAddEntity>> regBankAccFundAdd(
        @RequestBody BankAccFundAddForm dom
    ){
        BankAccFundAddEntity result = bankAccFundAddService.regBankAccFundAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BankAccFundAddEntity>> modBankAccFundAdd(
        @RequestBody BankAccFundAddForm dom
    ){
        BankAccFundAddEntity result = bankAccFundAddService.modBankAccFundAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BankAccFundAddEntity>> getBankAccFundAdd(
        @RequestBody BankAccFundAddSearch dom
    ){
        BankAccFundAddEntity result = bankAccFundAddService.getBankAccFundAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BankAccFundAddEntity>>> getBankAccFundAddList(
        @RequestBody BankAccFundAddSearch dom
    ){
        ResultListDto<BankAccFundAddEntity> resultList = bankAccFundAddService.getBankAccFundAddList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
