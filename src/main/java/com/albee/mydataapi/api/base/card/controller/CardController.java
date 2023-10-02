package com.albee.mydataapi.api.base.card.controller;

import com.albee.mydataapi.common.models.dto.ResponseDto;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.card.models.CardSearch;
import com.albee.mydataapi.api.base.card.models.entity.CardEntity;
import com.albee.mydataapi.api.base.card.models.form.CardForm;
import com.albee.mydataapi.api.base.card.service.CardService;
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
@RequestMapping(value = "/card", produces="application/json;charset=UTF-8")
public class CardController {
    @Autowired
    CardService cardService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardEntity>> regCard(
        @RequestBody CardForm dom
    ){
        CardEntity result = cardService.regCard(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardEntity>> modCard(
        @RequestBody CardForm dom
    ){
        CardEntity result = cardService.modCard(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardEntity>> getCard(
        @RequestBody CardSearch dom
    ){
        CardEntity result = cardService.getCard(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardEntity>>> getCardList(
        @RequestBody CardSearch dom
    ){
        ResultListDto<CardEntity> resultList = cardService.getCardList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
