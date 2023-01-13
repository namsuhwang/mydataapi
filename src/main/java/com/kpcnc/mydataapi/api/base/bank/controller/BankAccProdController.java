package com.kpcnc.mydataapi.api.base.bank.controller;

import com.kpcnc.mydataapi.api.base.bank.models.BankAccProdSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccProdEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccProdForm;
import com.kpcnc.mydataapi.api.base.bank.service.BankAccProdService;
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
@RequestMapping(value = "/bankAccProd", produces="application/json;charset=UTF-8")
public class BankAccProdController {
    @Autowired
    BankAccProdService bankAccProdService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BankAccProdEntity>> regBankAccProd(
        @RequestBody BankAccProdForm dom
    ){
        BankAccProdEntity result = bankAccProdService.regBankAccProd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BankAccProdEntity>> modBankAccProd(
        @RequestBody BankAccProdForm dom
    ){
        BankAccProdEntity result = bankAccProdService.modBankAccProd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BankAccProdEntity>> getBankAccProd(
        @RequestBody BankAccProdSearch dom
    ){
        BankAccProdEntity result = bankAccProdService.getBankAccProd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BankAccProdEntity>>> getBankAccProdList(
        @RequestBody BankAccProdSearch dom
    ){
        ResultListDto<BankAccProdEntity> resultList = bankAccProdService.getBankAccProdList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
