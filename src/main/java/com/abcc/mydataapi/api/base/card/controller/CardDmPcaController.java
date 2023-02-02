package com.abcc.mydataapi.api.base.card.controller;

import com.abcc.mydataapi.common.models.dto.ResponseDto;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.card.models.CardDmPcaSearch;
import com.abcc.mydataapi.api.base.card.models.entity.CardDmPcaEntity;
import com.abcc.mydataapi.api.base.card.models.form.CardDmPcaForm;
import com.abcc.mydataapi.api.base.card.service.CardDmPcaService;
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
@RequestMapping(value = "/cardDmPca", produces="application/json;charset=UTF-8")
public class CardDmPcaController {
    @Autowired
    CardDmPcaService cardDmPcaService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardDmPcaEntity>> regCardDmPca(
        @RequestBody CardDmPcaForm dom
    ){
        cardDmPcaService.regCardDmPca(dom);
        CardDmPcaEntity result = cardDmPcaService.getCardDmPcaLast(new CardDmPcaSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardDmPcaEntity>> modCardDmPca(
        @RequestBody CardDmPcaForm dom
    ){
        cardDmPcaService.modCardDmPca(dom);
        CardDmPcaEntity result = cardDmPcaService.getCardDmPcaLast(new CardDmPcaSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardDmPcaEntity>> getCardDmPca(
        @RequestBody CardDmPcaSearch dom
    ){
        CardDmPcaEntity result = cardDmPcaService.getCardDmPca(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardDmPcaEntity>>> getCardDmPcaList(
        @RequestBody CardDmPcaSearch dom
    ){
        ResultListDto<CardDmPcaEntity> resultList = cardDmPcaService.getCardDmPcaList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
