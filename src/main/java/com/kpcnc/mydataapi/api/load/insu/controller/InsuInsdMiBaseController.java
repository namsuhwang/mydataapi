package com.kpcnc.mydataapi.api.load.insu.controller;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdMiBaseSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdMiBaseEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdMiBaseForm;
import com.kpcnc.mydataapi.api.load.insu.service.InsuInsdMiBaseService;
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
@RequestMapping(value = "/insuInsdMiBase", produces="application/json;charset=UTF-8")
public class InsuInsdMiBaseController {
    @Autowired
    InsuInsdMiBaseService insuInsdMiBaseService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuInsdMiBaseEntity>> regInsuInsdMiBase(
        @RequestBody InsuInsdMiBaseForm dom
    ){
        InsuInsdMiBaseEntity result = insuInsdMiBaseService.regInsuInsdMiBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuInsdMiBaseEntity>> modInsuInsdMiBase(
        @RequestBody InsuInsdMiBaseForm dom
    ){
        InsuInsdMiBaseEntity result = insuInsdMiBaseService.modInsuInsdMiBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuInsdMiBaseEntity>> getInsuInsdMiBase(
        @RequestBody InsuInsdMiBaseSearch dom
    ){
        InsuInsdMiBaseEntity result = insuInsdMiBaseService.getInsuInsdMiBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuInsdMiBaseEntity>>> getInsuInsdMiBaseList(
        @RequestBody InsuInsdMiBaseSearch dom
    ){
        ResultListDto<InsuInsdMiBaseEntity> resultList = insuInsdMiBaseService.getInsuInsdMiBaseList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
