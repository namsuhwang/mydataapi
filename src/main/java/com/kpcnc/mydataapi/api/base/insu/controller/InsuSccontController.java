package com.kpcnc.mydataapi.api.base.insu.controller;

import com.kpcnc.mydataapi.api.base.insu.models.InsuSccontSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuSccontEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuSccontForm;
import com.kpcnc.mydataapi.api.base.insu.service.InsuSccontService;
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
@RequestMapping(value = "/insuSccont", produces="application/json;charset=UTF-8")
public class InsuSccontController {
    @Autowired
    InsuSccontService insuSccontService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuSccontEntity>> regInsuSccont(
        @RequestBody InsuSccontForm dom
    ){
        InsuSccontEntity result = insuSccontService.regInsuSccont(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuSccontEntity>> modInsuSccont(
        @RequestBody InsuSccontForm dom
    ){
        InsuSccontEntity result = insuSccontService.modInsuSccont(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuSccontEntity>> getInsuSccont(
        @RequestBody InsuSccontSearch dom
    ){
        InsuSccontEntity result = insuSccontService.getInsuSccont(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuSccontEntity>>> getInsuSccontList(
        @RequestBody InsuSccontSearch dom
    ){
        ResultListDto<InsuSccontEntity> resultList = insuSccontService.getInsuSccontList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
