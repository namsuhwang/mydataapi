package com.abcc.mydataapi.api.base.card.controller;

import com.abcc.mydataapi.common.models.dto.ResponseDto;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.card.models.CardPaySearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardPayEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardPayForm;
import com.abcc.mydataapi.api.base.card.service.CardPayService;
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
@RequestMapping(value = "/cardPay", produces="application/json;charset=UTF-8")
public class CardPayController {
    @Autowired
    CardPayService cardPayService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardPayEntity>> regCardPay(
        @RequestBody CardPayForm dom
    ){
        CardPayEntity result = cardPayService.regCardPay(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardPayEntity>> modCardPay(
        @RequestBody CardPayForm dom
    ){
        CardPayEntity result = cardPayService.modCardPay(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardPayEntity>> getCardPay(
        @RequestBody CardPaySearch dom
    ){
        CardPayEntity result = cardPayService.getCardPay(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardPayEntity>>> getCardPayList(
        @RequestBody CardPaySearch dom
    ){
        ResultListDto<CardPayEntity> resultList = cardPayService.getCardPayList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
