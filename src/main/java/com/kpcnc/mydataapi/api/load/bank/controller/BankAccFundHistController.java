package com.kpcnc.mydataapi.api.load.bank.controller;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccFundHistSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccFundHistEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccFundHistForm;
import com.kpcnc.mydataapi.api.load.bank.service.BankAccFundHistService;
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
@RequestMapping(value = "/bankAccFundHist", produces="application/json;charset=UTF-8")
public class BankAccFundHistController {
    @Autowired
    BankAccFundHistService bankAccFundHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BankAccFundHistEntity>> regBankAccFundHist(
        @RequestBody BankAccFundHistForm dom
    ){
        BankAccFundHistEntity result = bankAccFundHistService.regBankAccFundHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BankAccFundHistEntity>> modBankAccFundHist(
        @RequestBody BankAccFundHistForm dom
    ){
        BankAccFundHistEntity result = bankAccFundHistService.modBankAccFundHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BankAccFundHistEntity>> getBankAccFundHist(
        @RequestBody BankAccFundHistSearch dom
    ){
        BankAccFundHistEntity result = bankAccFundHistService.getBankAccFundHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BankAccFundHistEntity>>> getBankAccFundHistList(
        @RequestBody BankAccFundHistSearch dom
    ){
        ResultListDto<BankAccFundHistEntity> resultList = bankAccFundHistService.getBankAccFundHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
