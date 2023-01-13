package com.kpcnc.mydataapi.api.base.insu.controller;

import com.kpcnc.mydataapi.api.base.insu.models.InsuInsdMiBasePpSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdMiBasePpEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuInsdMiBasePpForm;
import com.kpcnc.mydataapi.api.base.insu.service.InsuInsdMiBasePpService;
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
@RequestMapping(value = "/insuInsdMiBasePp", produces="application/json;charset=UTF-8")
public class InsuInsdMiBasePpController {
    @Autowired
    InsuInsdMiBasePpService insuInsdMiBasePpService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuInsdMiBasePpEntity>> regInsuInsdMiBasePp(
        @RequestBody InsuInsdMiBasePpForm dom
    ){
        InsuInsdMiBasePpEntity result = insuInsdMiBasePpService.regInsuInsdMiBasePp(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuInsdMiBasePpEntity>> modInsuInsdMiBasePp(
        @RequestBody InsuInsdMiBasePpForm dom
    ){
        InsuInsdMiBasePpEntity result = insuInsdMiBasePpService.modInsuInsdMiBasePp(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuInsdMiBasePpEntity>> getInsuInsdMiBasePp(
        @RequestBody InsuInsdMiBasePpSearch dom
    ){
        InsuInsdMiBasePpEntity result = insuInsdMiBasePpService.getInsuInsdMiBasePp(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuInsdMiBasePpEntity>>> getInsuInsdMiBasePpList(
        @RequestBody InsuInsdMiBasePpSearch dom
    ){
        ResultListDto<InsuInsdMiBasePpEntity> resultList = insuInsdMiBasePpService.getInsuInsdMiBasePpList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
