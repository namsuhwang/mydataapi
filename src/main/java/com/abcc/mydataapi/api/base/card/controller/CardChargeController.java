package com.abcc.mydataapi.api.base.card.controller;

import com.abcc.mydataapi.common.models.dto.ResponseDto;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.card.models.CardChargeSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardChargeEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardChargeForm;
import com.abcc.mydataapi.api.base.card.service.CardChargeService;
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
@RequestMapping(value = "/cardCharge", produces="application/json;charset=UTF-8")
public class CardChargeController {
    @Autowired
    CardChargeService cardChargeService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardChargeEntity>> regCardCharge(
        @RequestBody CardChargeForm dom
    ){
        cardChargeService.regCardCharge(dom);
        CardChargeEntity result = cardChargeService.getCardCharge(new CardChargeSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardChargeEntity>> modCardCharge(
        @RequestBody CardChargeForm dom
    ){
        cardChargeService.modCardCharge(dom);
        CardChargeEntity result = cardChargeService.getCardCharge(new CardChargeSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardChargeEntity>> getCardCharge(
        @RequestBody CardChargeSearch dom
    ){
        CardChargeEntity result = cardChargeService.getCardCharge(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardChargeEntity>>> getCardChargeList(
        @RequestBody CardChargeSearch dom
    ){
        ResultListDto<CardChargeEntity> resultList = cardChargeService.getCardChargeList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
