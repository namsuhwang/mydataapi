package com.abcc.mydataapi.api.base.card.controller;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.card.models.CardPtSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardPtEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardPtForm;
import com.abcc.mydataapi.api.base.card.service.CardPtService;
import com.abcc.mydataapi.common.models.dto.ResponseDto;
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
@RequestMapping(value = "/cardPt", produces="application/json;charset=UTF-8")
public class CardPtController {
    @Autowired
    CardPtService cardPtService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardPtEntity>> regCardPt(
        @RequestBody CardPtForm dom
    ){
        CardPtEntity result = cardPtService.regCardPt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardPtEntity>> modCardPt(
        @RequestBody CardPtForm dom
    ){
        CardPtEntity result = cardPtService.modCardPt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardPtEntity>> getCardPt(
        @RequestBody CardPtSearch dom
    ){
        CardPtEntity result = cardPtService.getCardPt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardPtEntity>>> getCardPtList(
        @RequestBody CardPtSearch dom
    ){
        ResultListDto<CardPtEntity> resultList = cardPtService.getCardPtList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
