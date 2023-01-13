package com.kpcnc.mydataapi.api.base.insu.controller;

import com.kpcnc.mydataapi.api.base.insu.models.InsuHistSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuHistEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuHistForm;
import com.kpcnc.mydataapi.api.base.insu.service.InsuHistService;
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
@RequestMapping(value = "/insuHist", produces="application/json;charset=UTF-8")
public class InsuHistController {
    @Autowired
    InsuHistService insuHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuHistEntity>> regInsuHist(
        @RequestBody InsuHistForm dom
    ){
        InsuHistEntity result = insuHistService.regInsuHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuHistEntity>> modInsuHist(
        @RequestBody InsuHistForm dom
    ){
        InsuHistEntity result = insuHistService.modInsuHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuHistEntity>> getInsuHist(
        @RequestBody InsuHistSearch dom
    ){
        InsuHistEntity result = insuHistService.getInsuHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuHistEntity>>> getInsuHistList(
        @RequestBody InsuHistSearch dom
    ){
        ResultListDto<InsuHistEntity> resultList = insuHistService.getInsuHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
