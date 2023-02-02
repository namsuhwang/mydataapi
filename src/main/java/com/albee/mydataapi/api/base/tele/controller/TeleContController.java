package com.albee.mydataapi.api.base.tele.controller;

import com.albee.mydataapi.api.base.tele.models.entity.TeleContEntity;
import com.albee.mydataapi.api.base.tele.models.form.TeleContForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.tele.models.TeleContSearch;
import com.albee.mydataapi.api.base.tele.service.TeleContService;
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
@RequestMapping(value = "/teleCont", produces="application/json;charset=UTF-8")
public class TeleContController {
    @Autowired
    TeleContService teleContService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<TeleContEntity>> regTeleCont(
        @RequestBody TeleContForm dom
    ){
        TeleContEntity result = teleContService.regTeleCont(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<TeleContEntity>> modTeleCont(
        @RequestBody TeleContForm dom
    ){
        TeleContEntity result = teleContService.modTeleCont(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<TeleContEntity>> getTeleCont(
        @RequestBody TeleContSearch dom
    ){
        TeleContEntity result = teleContService.getTeleCont(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<TeleContEntity>>> getTeleContList(
        @RequestBody TeleContSearch dom
    ){
        ResultListDto<TeleContEntity> resultList = teleContService.getTeleContList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
