package com.albee.mydataapi.api.base.bank.controller;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.bank.models.BankCustSearch;
import com.albee.mydataapi.api.base.bank.models.entity.BankCustEntity;
import com.albee.mydataapi.api.base.bank.models.form.BankCustForm;
import com.albee.mydataapi.api.base.bank.service.BankCustService;
import com.albee.mydataapi.common.models.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@RestController
@EnableWebMvc
@RequiredArgsConstructor
@RequestMapping(value = "/bankCust", produces="application/json;charset=UTF-8")
public class BankCustController {
    @Autowired
    BankCustService bankCustService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BankCustEntity>> regBankCust(
        @RequestBody BankCustForm dom
    ){
        bankCustService.regBankCust(dom);
        BankCustEntity result = bankCustService.getBankCust(new BankCustSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BankCustEntity>> modBankCust(
        @RequestBody BankCustForm dom
    ){
        bankCustService.modBankCust(dom);
        BankCustEntity result = bankCustService.getBankCust(new BankCustSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BankCustEntity>> getBankCust(
        @RequestBody BankCustSearch dom
    ){
        BankCustEntity result = bankCustService.getBankCust(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BankCustEntity>>> getBankCustList(
        @RequestBody BankCustSearch dom
    ){
        ResultListDto<BankCustEntity> resultList = bankCustService.getBankCustList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
