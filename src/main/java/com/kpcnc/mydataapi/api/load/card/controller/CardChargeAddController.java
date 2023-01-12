package com.kpcnc.mydataapi.api.load.card.controller;

import com.kpcnc.mydataapi.api.load.card.models.CardChargeAddSearch;
import com.kpcnc.mydataapi.api.load.card.models.entity.CardChargeAddEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardChargeAddForm;
import com.kpcnc.mydataapi.api.load.card.service.CardChargeAddService;
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
@RequestMapping(value = "/cardChargeAdd", produces="application/json;charset=UTF-8")
public class CardChargeAddController {
    @Autowired
    CardChargeAddService cardChargeAddService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<CardChargeAddEntity>> regCardChargeAdd(
        @RequestBody CardChargeAddForm dom
    ){
        CardChargeAddEntity result = cardChargeAddService.regCardChargeAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<CardChargeAddEntity>> modCardChargeAdd(
        @RequestBody CardChargeAddForm dom
    ){
        CardChargeAddEntity result = cardChargeAddService.modCardChargeAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<CardChargeAddEntity>> getCardChargeAdd(
        @RequestBody CardChargeAddSearch dom
    ){
        CardChargeAddEntity result = cardChargeAddService.getCardChargeAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<CardChargeAddEntity>>> getCardChargeAddList(
        @RequestBody CardChargeAddSearch dom
    ){
        ResultListDto<CardChargeAddEntity> resultList = cardChargeAddService.getCardChargeAddList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
