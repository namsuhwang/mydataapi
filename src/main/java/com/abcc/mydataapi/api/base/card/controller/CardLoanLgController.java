package com.abcc.mydataapi.api.base.card.controller;

import com.abcc.mydataapi.common.models.dto.ResponseDto;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.card.models.CardLoanLgSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardLoanLgEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardLoanLgForm;
import com.abcc.mydataapi.api.base.card.service.CardLoanLgService;
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
@RequestMapping(value = "/cardLoanLg", produces="application/json;charset=UTF-8")
public class CardLoanLgController {
    @Autowired
    CardLoanLgService cardLoanLgService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardLoanLgEntity>> regCardLoanLg(
        @RequestBody CardLoanLgForm dom
    ){
        cardLoanLgService.regCardLoanLg(dom);
        CardLoanLgEntity result = cardLoanLgService.getCardLoanLg(new CardLoanLgSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardLoanLgEntity>> modCardLoanLg(
        @RequestBody CardLoanLgForm dom
    ){
        cardLoanLgService.modCardLoanLg(dom);
        CardLoanLgEntity result = cardLoanLgService.getCardLoanLg(new CardLoanLgSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardLoanLgEntity>> getCardLoanLg(
        @RequestBody CardLoanLgSearch dom
    ){
        CardLoanLgEntity result = cardLoanLgService.getCardLoanLg(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardLoanLgEntity>>> getCardLoanLgList(
        @RequestBody CardLoanLgSearch dom
    ){
        ResultListDto<CardLoanLgEntity> resultList = cardLoanLgService.getCardLoanLgList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
