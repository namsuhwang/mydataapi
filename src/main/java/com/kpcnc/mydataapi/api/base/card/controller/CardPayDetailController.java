package com.kpcnc.mydataapi.api.base.card.controller;

import com.kpcnc.mydataapi.api.base.card.models.CardPayDetailSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardPayDetailEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardPayDetailForm;
import com.kpcnc.mydataapi.api.base.card.service.CardPayDetailService;
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
@RequestMapping(value = "/cardPayDetail", produces="application/json;charset=UTF-8")
public class CardPayDetailController {
    @Autowired
    CardPayDetailService cardPayDetailService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardPayDetailEntity>> regCardPayDetail(
        @RequestBody CardPayDetailForm dom
    ){
        cardPayDetailService.regCardPayDetail(dom);
        CardPayDetailEntity result = cardPayDetailService.getCardPayDetail(new CardPayDetailSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardPayDetailEntity>> modCardPayDetail(
        @RequestBody CardPayDetailForm dom
    ){
        cardPayDetailService.modCardPayDetail(dom);
        CardPayDetailEntity result = cardPayDetailService.getCardPayDetail(new CardPayDetailSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardPayDetailEntity>> getCardPayDetail(
        @RequestBody CardPayDetailSearch dom
    ){
        CardPayDetailEntity result = cardPayDetailService.getCardPayDetail(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardPayDetailEntity>>> getCardPayDetailList(
        @RequestBody CardPayDetailSearch dom
    ){
        ResultListDto<CardPayDetailEntity> resultList = cardPayDetailService.getCardPayDetailList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
