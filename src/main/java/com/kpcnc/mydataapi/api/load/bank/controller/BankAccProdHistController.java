package com.kpcnc.mydataapi.api.load.bank.controller;

import com.kpcnc.mydataapi.api.load.bank.models.BankAccProdHistSearch;
import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccProdHistEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccProdHistForm;
import com.kpcnc.mydataapi.api.load.bank.service.BankAccProdHistService;
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
@RequestMapping(value = "/bankAccProdHist", produces="application/json;charset=UTF-8")
public class BankAccProdHistController {
    @Autowired
    BankAccProdHistService bankAccProdHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BankAccProdHistEntity>> regBankAccProdHist(
        @RequestBody BankAccProdHistForm dom
    ){
        BankAccProdHistEntity result = bankAccProdHistService.regBankAccProdHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BankAccProdHistEntity>> modBankAccProdHist(
        @RequestBody BankAccProdHistForm dom
    ){
        BankAccProdHistEntity result = bankAccProdHistService.modBankAccProdHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BankAccProdHistEntity>> getBankAccProdHist(
        @RequestBody BankAccProdHistSearch dom
    ){
        BankAccProdHistEntity result = bankAccProdHistService.getBankAccProdHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BankAccProdHistEntity>>> getBankAccProdHistList(
        @RequestBody BankAccProdHistSearch dom
    ){
        ResultListDto<BankAccProdHistEntity> resultList = bankAccProdHistService.getBankAccProdHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
