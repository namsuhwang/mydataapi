package com.kpcnc.mydataapi.api.load.card.controller;

import com.kpcnc.mydataapi.api.load.card.models.CardPayDetailSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardPayDetailEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardPayDetailForm;
import com.kpcnc.mydataapi.api.load.card.service.CardPayDetailService;
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
@RequestMapping(value = "/cardPayDetail", produces="application/json;charset=UTF-8")
public class CardPayDetailController {
    @Autowired
    CardPayDetailService cardPayDetailService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardPayDetailEntity>> regCardPayDetail(
        @RequestBody CardPayDetailForm dom
    ){
        CardPayDetailEntity result = cardPayDetailService.regCardPayDetail(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardPayDetailEntity>> modCardPayDetail(
        @RequestBody CardPayDetailForm dom
    ){
        CardPayDetailEntity result = cardPayDetailService.modCardPayDetail(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardPayDetailEntity>> getCardPayDetail(
        @RequestBody CardPayDetailSearch dom
    ){
        CardPayDetailEntity result = cardPayDetailService.getCardPayDetail(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardPayDetailEntity>>> getCardPayDetailList(
        @RequestBody CardPayDetailSearch dom
    ){
        ResultListDto<CardPayDetailEntity> resultList = cardPayDetailService.getCardPayDetailList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
