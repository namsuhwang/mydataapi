package com.kpcnc.mydataapi.api.load.card.controller;

import com.kpcnc.mydataapi.api.load.card.models.CardOsPcaSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardOsPcaEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardOsPcaForm;
import com.kpcnc.mydataapi.api.load.card.service.CardOsPcaService;
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

import java.util.List;

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
        CardOsPcaEntity result = cardOsPcaService.regCardOsPca(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardOsPcaEntity>> modCardOsPca(
        @RequestBody CardOsPcaForm dom
    ){
        CardOsPcaEntity result = cardOsPcaService.modCardOsPca(dom);
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
