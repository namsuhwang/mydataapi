package com.kpcnc.mydataapi.api.load.bank.controller;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccForm;
import com.kpcnc.mydataapi.api.load.bank.service.BankAccService;
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
@RequestMapping(value = "/bankAcc", produces="application/json;charset=UTF-8")
public class BankAccController {
    @Autowired
    BankAccService bankAccService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BankAccEntity>> regBankAcc(
        @RequestBody BankAccForm dom
    ){
        BankAccEntity result = bankAccService.regBankAcc(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BankAccEntity>> modBankAcc(
        @RequestBody BankAccForm dom
    ){
        BankAccEntity result = bankAccService.modBankAcc(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BankAccEntity>> getBankAcc(
        @RequestBody BankAccSearch dom
    ){
        BankAccEntity result = bankAccService.getBankAcc(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BankAccEntity>>> getBankAccList(
        @RequestBody BankAccSearch dom
    ){
        ResultListDto<BankAccEntity> resultList = bankAccService.getBankAccList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
