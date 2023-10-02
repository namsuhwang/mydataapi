package com.albee.mydataapi.api.base.card.controller;

import com.albee.mydataapi.common.models.dto.ResponseDto;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.card.models.CardLoanSearch;
import com.albee.mydataapi.api.base.card.models.entity.CardLoanEntity;
import com.albee.mydataapi.api.base.card.models.form.CardLoanForm;
import com.albee.mydataapi.api.base.card.service.CardLoanService;
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
@RequestMapping(value = "/cardLoan", produces="application/json;charset=UTF-8")
public class CardLoanController {
    @Autowired
    CardLoanService cardLoanService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardLoanEntity>> regCardLoan(
        @RequestBody CardLoanForm dom
    ){
        CardLoanEntity result = cardLoanService.regCardLoan(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardLoanEntity>> modCardLoan(
        @RequestBody CardLoanForm dom
    ){
        CardLoanEntity result = cardLoanService.modCardLoan(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardLoanEntity>> getCardLoan(
        @RequestBody CardLoanSearch dom
    ){
        CardLoanEntity result = cardLoanService.getCardLoan(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardLoanEntity>>> getCardLoanList(
        @RequestBody CardLoanSearch dom
    ){
        ResultListDto<CardLoanEntity> resultList = cardLoanService.getCardLoanList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
