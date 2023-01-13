package com.kpcnc.mydataapi.api.base.card.controller;

import com.kpcnc.mydataapi.api.base.card.models.CardLoanStSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardLoanStEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardLoanStForm;
import com.kpcnc.mydataapi.api.base.card.service.CardLoanStService;
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

@Slf4j
@RestController
@EnableWebMvc
@RequiredArgsConstructor
@RequestMapping(value = "/cardLoanSt", produces="application/json;charset=UTF-8")
public class CardLoanStController {
    @Autowired
    CardLoanStService cardLoanStService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardLoanStEntity>> regCardLoanSt(
        @RequestBody CardLoanStForm dom
    ){
        CardLoanStEntity result = cardLoanStService.regCardLoanSt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardLoanStEntity>> modCardLoanSt(
        @RequestBody CardLoanStForm dom
    ){
        CardLoanStEntity result = cardLoanStService.modCardLoanSt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardLoanStEntity>> getCardLoanSt(
        @RequestBody CardLoanStSearch dom
    ){
        CardLoanStEntity result = cardLoanStService.getCardLoanSt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardLoanStEntity>>> getCardLoanStList(
        @RequestBody CardLoanStSearch dom
    ){
        ResultListDto<CardLoanStEntity> resultList = cardLoanStService.getCardLoanStList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
