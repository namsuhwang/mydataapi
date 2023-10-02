package com.albee.mydataapi.api.base.card.controller;

import com.albee.mydataapi.common.models.dto.ResponseDto;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.card.models.CardOsPcaSearch;
import com.albee.mydataapi.api.base.card.models.entity.CardOsPcaEntity;
import com.albee.mydataapi.api.base.card.models.form.CardOsPcaForm;
import com.albee.mydataapi.api.base.card.service.CardOsPcaService;
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
@RequestMapping(value = "/cardOsPca", produces="application/json;charset=UTF-8")
public class CardOsPcaController {
    @Autowired
    CardOsPcaService cardOsPcaService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardOsPcaEntity>> regCardOsPca(
        @RequestBody CardOsPcaForm dom
    ){
        cardOsPcaService.regCardOsPca(dom);
        CardOsPcaEntity result = cardOsPcaService.getCardOsPca(new CardOsPcaSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardOsPcaEntity>> modCardOsPca(
        @RequestBody CardOsPcaForm dom
    ){
        cardOsPcaService.modCardOsPca(dom);
        CardOsPcaEntity result = cardOsPcaService.getCardOsPca(new CardOsPcaSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardOsPcaEntity>> getCardOsPca(
        @RequestBody CardOsPcaSearch dom
    ){
        CardOsPcaEntity result = cardOsPcaService.getCardOsPca(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardOsPcaEntity>>> getCardOsPcaList(
        @RequestBody CardOsPcaSearch dom
    ){
        ResultListDto<CardOsPcaEntity> resultList = cardOsPcaService.getCardOsPcaList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
