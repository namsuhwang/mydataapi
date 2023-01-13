package com.kpcnc.mydataapi.api.base.insu.controller;

import com.kpcnc.mydataapi.api.base.insu.models.InsuMiHistSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuMiHistEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiHistForm;
import com.kpcnc.mydataapi.api.base.insu.service.InsuMiHistService;
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
@RequestMapping(value = "/insuMiHist", produces="application/json;charset=UTF-8")
public class InsuMiHistController {
    @Autowired
    InsuMiHistService insuMiHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuMiHistEntity>> regInsuMiHist(
        @RequestBody InsuMiHistForm dom
    ){
        InsuMiHistEntity result = insuMiHistService.regInsuMiHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuMiHistEntity>> modInsuMiHist(
        @RequestBody InsuMiHistForm dom
    ){
        InsuMiHistEntity result = insuMiHistService.modInsuMiHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuMiHistEntity>> getInsuMiHist(
        @RequestBody InsuMiHistSearch dom
    ){
        InsuMiHistEntity result = insuMiHistService.getInsuMiHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuMiHistEntity>>> getInsuMiHistList(
        @RequestBody InsuMiHistSearch dom
    ){
        ResultListDto<InsuMiHistEntity> resultList = insuMiHistService.getInsuMiHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
