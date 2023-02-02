package com.abcc.mydataapi.api.base.card.controller;

import com.abcc.mydataapi.common.models.dto.ResponseDto;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.card.models.CardAprOsHistSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardAprOsHistEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardAprOsHistForm;
import com.abcc.mydataapi.api.base.card.service.CardAprOsHistService;
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
@RequestMapping(value = "/cardAprOsHist", produces="application/json;charset=UTF-8")
public class CardAprOsHistController {
    @Autowired
    CardAprOsHistService cardAprOsHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardAprOsHistEntity>> regCardAprOsHist(
        @RequestBody CardAprOsHistForm dom
    ){
        cardAprOsHistService.regCardAprOsHist(dom);
        CardAprOsHistEntity result = cardAprOsHistService.getCardAprOsHistLast(new CardAprOsHistSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardAprOsHistEntity>> modCardAprOsHist(
        @RequestBody CardAprOsHistForm dom
    ){
        cardAprOsHistService.modCardAprOsHist(dom);
        CardAprOsHistEntity result = cardAprOsHistService.getCardAprOsHistLast(new CardAprOsHistSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardAprOsHistEntity>> getCardAprOsHist(
        @RequestBody CardAprOsHistSearch dom
    ){
        CardAprOsHistEntity result = cardAprOsHistService.getCardAprOsHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardAprOsHistEntity>>> getCardAprOsHistList(
        @RequestBody CardAprOsHistSearch dom
    ){
        ResultListDto<CardAprOsHistEntity> resultList = cardAprOsHistService.getCardAprOsHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
