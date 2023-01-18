package com.kpcnc.mydataapi.api.base.bank.controller;

import com.kpcnc.mydataapi.api.base.bank.models.BankCustSearch;
import com.kpcnc.mydataapi.api.base.bank.models.entity.BankCustEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankCustForm;
import com.kpcnc.mydataapi.api.base.bank.service.BankCustService;
import com.kpcnc.mydataapi.common.models.dto.ResponseDto;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

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
