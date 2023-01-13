package com.kpcnc.mydataapi.api.base.card.controller;

import com.kpcnc.mydataapi.api.base.card.models.CardAprDmHistSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardAprDmHistEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardAprDmHistForm;
import com.kpcnc.mydataapi.api.base.card.service.CardAprDmHistService;
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
@RequestMapping(value = "/cardAprDmHist", produces="application/json;charset=UTF-8")
public class CardAprDmHistController {
    @Autowired
    CardAprDmHistService cardAprDmHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardAprDmHistEntity>> regCardAprDmHist(
        @RequestBody CardAprDmHistForm dom
    ){
        CardAprDmHistEntity result = cardAprDmHistService.regCardAprDmHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardAprDmHistEntity>> modCardAprDmHist(
        @RequestBody CardAprDmHistForm dom
    ){
        CardAprDmHistEntity result = cardAprDmHistService.modCardAprDmHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardAprDmHistEntity>> getCardAprDmHist(
        @RequestBody CardAprDmHistSearch dom
    ){
        CardAprDmHistEntity result = cardAprDmHistService.getCardAprDmHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardAprDmHistEntity>>> getCardAprDmHistList(
        @RequestBody CardAprDmHistSearch dom
    ){
        ResultListDto<CardAprDmHistEntity> resultList = cardAprDmHistService.getCardAprDmHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
