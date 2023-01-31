package com.kpcnc.mydataapi.api.base.card.controller;

import com.kpcnc.mydataapi.api.base.card.models.CardRvSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardRvEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardRvForm;
import com.kpcnc.mydataapi.api.base.card.service.CardRvService;
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
@RequestMapping(value = "/cardRv", produces="application/json;charset=UTF-8")
public class CardRvController {
    @Autowired
    CardRvService cardRvService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardRvEntity>> regCardRv(
        @RequestBody CardRvForm dom
    ){
        cardRvService.regCardRv(dom);
        CardRvEntity result = cardRvService.getCardRv(new CardRvSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardRvEntity>> modCardRv(
        @RequestBody CardRvForm dom
    ){
        cardRvService.modCardRv(dom);
        CardRvEntity result = cardRvService.getCardRv(new CardRvSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardRvEntity>> getCardRv(
        @RequestBody CardRvSearch dom
    ){
        CardRvEntity result = cardRvService.getCardRv(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardRvEntity>>> getCardRvList(
        @RequestBody CardRvSearch dom
    ){
        ResultListDto<CardRvEntity> resultList = cardRvService.getCardRvList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
