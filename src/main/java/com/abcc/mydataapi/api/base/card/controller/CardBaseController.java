package com.abcc.mydataapi.api.base.card.controller;

import com.abcc.mydataapi.common.models.dto.ResponseDto;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.card.models.CardBaseSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardBaseEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardBaseForm;
import com.abcc.mydataapi.api.base.card.service.CardBaseService;
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
@RequestMapping(value = "/cardBase", produces="application/json;charset=UTF-8")
public class CardBaseController {
    @Autowired
    CardBaseService cardBaseService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardBaseEntity>> regCardBase(
        @RequestBody CardBaseForm dom
    ){
        CardBaseEntity result = cardBaseService.regCardBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardBaseEntity>> modCardBase(
        @RequestBody CardBaseForm dom
    ){
        CardBaseEntity result = cardBaseService.modCardBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardBaseEntity>> getCardBase(
        @RequestBody CardBaseSearch dom
    ){
        CardBaseEntity result = cardBaseService.getCardBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardBaseEntity>>> getCardBaseList(
        @RequestBody CardBaseSearch dom
    ){
        ResultListDto<CardBaseEntity> resultList = cardBaseService.getCardBaseList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
