package com.abcc.mydataapi.api.base.insu.controller;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuMiBasePpEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuMiBasePpForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuMiBasePpSearch;
import com.abcc.mydataapi.api.base.insu.service.InsuMiBasePpService;
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
@RequestMapping(value = "/insuMiBasePp", produces="application/json;charset=UTF-8")
public class InsuMiBasePpController {
    @Autowired
    InsuMiBasePpService insuMiBasePpService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuMiBasePpEntity>> regInsuMiBasePp(
        @RequestBody InsuMiBasePpForm dom
    ){
        insuMiBasePpService.regInsuMiBasePp(dom);
        InsuMiBasePpEntity result = insuMiBasePpService.getInsuMiBasePp(new InsuMiBasePpSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuMiBasePpEntity>> modInsuMiBasePp(
        @RequestBody InsuMiBasePpForm dom
    ){
        insuMiBasePpService.modInsuMiBasePp(dom);
        InsuMiBasePpEntity result = insuMiBasePpService.getInsuMiBasePp(new InsuMiBasePpSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuMiBasePpEntity>> getInsuMiBasePp(
        @RequestBody InsuMiBasePpSearch dom
    ){
        InsuMiBasePpEntity result = insuMiBasePpService.getInsuMiBasePp(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuMiBasePpEntity>>> getInsuMiBasePpList(
        @RequestBody InsuMiBasePpSearch dom
    ){
        ResultListDto<InsuMiBasePpEntity> resultList = insuMiBasePpService.getInsuMiBasePpList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
