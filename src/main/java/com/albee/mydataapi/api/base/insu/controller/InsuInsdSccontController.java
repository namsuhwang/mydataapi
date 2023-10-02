package com.albee.mydataapi.api.base.insu.controller;

import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdSccontEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuInsdSccontForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuInsdSccontSearch;
import com.albee.mydataapi.api.base.insu.service.InsuInsdSccontService;
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
@RequestMapping(value = "/insuInsdSccont", produces="application/json;charset=UTF-8")
public class InsuInsdSccontController {
    @Autowired
    InsuInsdSccontService insuInsdSccontService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuInsdSccontEntity>> regInsuInsdSccont(
        @RequestBody InsuInsdSccontForm dom
    ){
        insuInsdSccontService.regInsuInsdSccont(dom);
        InsuInsdSccontEntity result = insuInsdSccontService.getInsuInsdSccont(new InsuInsdSccontSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuInsdSccontEntity>> modInsuInsdSccont(
        @RequestBody InsuInsdSccontForm dom
    ){
        insuInsdSccontService.modInsuInsdSccont(dom);
        InsuInsdSccontEntity result = insuInsdSccontService.getInsuInsdSccont(new InsuInsdSccontSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuInsdSccontEntity>> getInsuInsdSccont(
        @RequestBody InsuInsdSccontSearch dom
    ){
        InsuInsdSccontEntity result = insuInsdSccontService.getInsuInsdSccont(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuInsdSccontEntity>>> getInsuInsdSccontList(
        @RequestBody InsuInsdSccontSearch dom
    ){
        ResultListDto<InsuInsdSccontEntity> resultList = insuInsdSccontService.getInsuInsdSccontList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
