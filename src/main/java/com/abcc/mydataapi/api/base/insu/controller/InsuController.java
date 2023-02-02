package com.abcc.mydataapi.api.base.insu.controller;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuSearch;
import com.abcc.mydataapi.api.base.insu.service.InsuService;
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
@RequestMapping(value = "/insu", produces="application/json;charset=UTF-8")
public class InsuController {
    @Autowired
    InsuService insuService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuEntity>> regInsu(
        @RequestBody InsuForm dom
    ){
        insuService.regInsu(dom);
        InsuEntity result = insuService.getInsu(new InsuSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuEntity>> modInsu(
        @RequestBody InsuForm dom
    ){
        insuService.modInsu(dom);
        InsuEntity result = insuService.getInsu(new InsuSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuEntity>> getInsu(
        @RequestBody InsuSearch dom
    ){
        InsuEntity result = insuService.getInsu(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuEntity>>> getInsuList(
        @RequestBody InsuSearch dom
    ){
        ResultListDto<InsuEntity> resultList = insuService.getInsuList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
