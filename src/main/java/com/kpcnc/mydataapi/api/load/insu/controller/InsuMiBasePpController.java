package com.kpcnc.mydataapi.api.load.insu.controller;

import com.kpcnc.mydataapi.api.InsuMiBasePpEntity;
import com.kpcnc.mydataapi.api.load.insu.models.InsuMiBasePpSearch;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuMiBasePpForm;
import com.kpcnc.mydataapi.api.load.insu.service.InsuMiBasePpService;
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
@RequestMapping(value = "/insuMiBasePp", produces="application/json;charset=UTF-8")
public class InsuMiBasePpController {
    @Autowired
    InsuMiBasePpService insuMiBasePpService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuMiBasePpEntity>> regInsuMiBasePp(
        @RequestBody InsuMiBasePpForm dom
    ){
        InsuMiBasePpEntity result = insuMiBasePpService.regInsuMiBasePp(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuMiBasePpEntity>> modInsuMiBasePp(
        @RequestBody InsuMiBasePpForm dom
    ){
        InsuMiBasePpEntity result = insuMiBasePpService.modInsuMiBasePp(dom);
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
