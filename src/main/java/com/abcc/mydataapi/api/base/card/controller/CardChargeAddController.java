package com.abcc.mydataapi.api.base.card.controller;

import com.abcc.mydataapi.common.models.dto.ResponseDto;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.card.models.CardChargeAddSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardChargeAddEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardChargeAddForm;
import com.abcc.mydataapi.api.base.card.service.CardChargeAddService;
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
@RequestMapping(value = "/cardChargeAdd", produces="application/json;charset=UTF-8")
public class CardChargeAddController {
    @Autowired
    CardChargeAddService cardChargeAddService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardChargeAddEntity>> regCardChargeAdd(
        @RequestBody CardChargeAddForm dom
    ){
        cardChargeAddService.regCardChargeAdd(dom);
        CardChargeAddEntity result = cardChargeAddService.getCardChargeAdd(new CardChargeAddSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardChargeAddEntity>> modCardChargeAdd(
        @RequestBody CardChargeAddForm dom
    ){
        cardChargeAddService.modCardChargeAdd(dom);
        CardChargeAddEntity result = cardChargeAddService.getCardChargeAdd(new CardChargeAddSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardChargeAddEntity>> getCardChargeAdd(
        @RequestBody CardChargeAddSearch dom
    ){
        CardChargeAddEntity result = cardChargeAddService.getCardChargeAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardChargeAddEntity>>> getCardChargeAddList(
        @RequestBody CardChargeAddSearch dom
    ){
        ResultListDto<CardChargeAddEntity> resultList = cardChargeAddService.getCardChargeAddList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
