package com.albee.mydataapi.api.base.tele.controller;

import com.albee.mydataapi.api.base.tele.models.entity.TeleHistEntity;
import com.albee.mydataapi.api.base.tele.models.form.TeleHistForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.tele.models.TeleHistSearch;
import com.albee.mydataapi.api.base.tele.service.TeleHistService;
import com.albee.mydataapi.common.models.dto.ResponseDto;
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
@RequestMapping(value = "/teleHist", produces="application/json;charset=UTF-8")
public class TeleHistController {
    @Autowired
    TeleHistService teleHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<TeleHistEntity>> regTeleHist(
        @RequestBody TeleHistForm dom
    ){
        teleHistService.regTeleHist(dom);
        TeleHistEntity result = teleHistService.getTeleHist(new TeleHistSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<TeleHistEntity>> modTeleHist(
        @RequestBody TeleHistForm dom
    ){
        teleHistService.modTeleHist(dom);
        TeleHistEntity result = teleHistService.getTeleHist(new TeleHistSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<TeleHistEntity>> getTeleHist(
        @RequestBody TeleHistSearch dom
    ){
        TeleHistEntity result = teleHistService.getTeleHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<TeleHistEntity>>> getTeleHistList(
        @RequestBody TeleHistSearch dom
    ){
        ResultListDto<TeleHistEntity> resultList = teleHistService.getTeleHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
