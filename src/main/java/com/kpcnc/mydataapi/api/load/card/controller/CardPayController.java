package com.kpcnc.mydataapi.api.load.card.controller;

import com.kpcnc.mydataapi.api.load.card.models.CardPaySearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardPayEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardPayForm;
import com.kpcnc.mydataapi.api.load.card.service.CardPayService;
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
