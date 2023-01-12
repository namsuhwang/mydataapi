package com.kpcnc.mydataapi.api.load.card.controller;

import com.kpcnc.mydataapi.api.load.card.models.CardLoanLgHistSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardLoanLgHistEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardLoanLgHistForm;
import com.kpcnc.mydataapi.api.load.card.service.CardLoanLgHistService;
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
@RequestMapping(value = "/cardLoanLgHist", produces="application/json;charset=UTF-8")
public class CardLoanLgHistController {
    @Autowired
    CardLoanLgHistService cardLoanLgHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardLoanLgHistEntity>> regCardLoanLgHist(
        @RequestBody CardLoanLgHistForm dom
    ){
        CardLoanLgHistEntity result = cardLoanLgHistService.regCardLoanLgHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardLoanLgHistEntity>> modCardLoanLgHist(
        @RequestBody CardLoanLgHistForm dom
    ){
        CardLoanLgHistEntity result = cardLoanLgHistService.modCardLoanLgHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardLoanLgHistEntity>> getCardLoanLgHist(
        @RequestBody CardLoanLgHistSearch dom
    ){
        CardLoanLgHistEntity result = cardLoanLgHistService.getCardLoanLgHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardLoanLgHistEntity>>> getCardLoanLgHistList(
        @RequestBody CardLoanLgHistSearch dom
    ){
        ResultListDto<CardLoanLgHistEntity> resultList = cardLoanLgHistService.getCardLoanLgHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
