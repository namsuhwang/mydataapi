package com.kpcnc.mydataapi.api.load.card.controller;

import com.kpcnc.mydataapi.api.load.card.models.CardAprOsHistSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardAprOsHistEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardAprOsHistForm;
import com.kpcnc.mydataapi.api.load.card.service.CardAprOsHistService;
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
@RequestMapping(value = "/cardAprOsHist", produces="application/json;charset=UTF-8")
public class CardAprOsHistController {
    @Autowired
    CardAprOsHistService cardAprOsHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardAprOsHistEntity>> regCardAprOsHist(
        @RequestBody CardAprOsHistForm dom
    ){
        CardAprOsHistEntity result = cardAprOsHistService.regCardAprOsHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardAprOsHistEntity>> modCardAprOsHist(
        @RequestBody CardAprOsHistForm dom
    ){
        CardAprOsHistEntity result = cardAprOsHistService.modCardAprOsHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardAprOsHistEntity>> getCardAprOsHist(
        @RequestBody CardAprOsHistSearch dom
    ){
        CardAprOsHistEntity result = cardAprOsHistService.getCardAprOsHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardAprOsHistEntity>>> getCardAprOsHistList(
        @RequestBody CardAprOsHistSearch dom
    ){
        ResultListDto<CardAprOsHistEntity> resultList = cardAprOsHistService.getCardAprOsHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
