package com.abcc.mydataapi.api.base.insu.controller;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuCarHistEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuCarHistForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuCarHistSearch;
import com.abcc.mydataapi.api.base.insu.service.InsuCarHistService;
import com.abcc.mydataapi.common.models.dto.ResponseDto;
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
@RequestMapping(value = "/insuCarHist", produces="application/json;charset=UTF-8")
public class InsuCarHistController {
    @Autowired
    InsuCarHistService insuCarHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuCarHistEntity>> regInsuCarHist(
        @RequestBody InsuCarHistForm dom
    ){
        insuCarHistService.regInsuCarHist(dom);
        InsuCarHistEntity result = insuCarHistService.getInsuCarHist(new InsuCarHistSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuCarHistEntity>> modInsuCarHist(
        @RequestBody InsuCarHistForm dom
    ){
        insuCarHistService.modInsuCarHist(dom);
        InsuCarHistEntity result = insuCarHistService.getInsuCarHist(new InsuCarHistSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuCarHistEntity>> getInsuCarHist(
        @RequestBody InsuCarHistSearch dom
    ){
        InsuCarHistEntity result = insuCarHistService.getInsuCarHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuCarHistEntity>>> getInsuCarHistList(
        @RequestBody InsuCarHistSearch dom
    ){
        ResultListDto<InsuCarHistEntity> resultList = insuCarHistService.getInsuCarHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
