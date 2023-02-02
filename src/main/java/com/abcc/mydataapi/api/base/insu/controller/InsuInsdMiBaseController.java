package com.abcc.mydataapi.api.base.insu.controller;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuInsdMiBaseEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuInsdMiBaseForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuInsdMiBaseSearch;
import com.abcc.mydataapi.api.base.insu.service.InsuInsdMiBaseService;
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
@RequestMapping(value = "/insuInsdMiBase", produces="application/json;charset=UTF-8")
public class InsuInsdMiBaseController {
    @Autowired
    InsuInsdMiBaseService insuInsdMiBaseService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuInsdMiBaseEntity>> regInsuInsdMiBase(
        @RequestBody InsuInsdMiBaseForm dom
    ){
        insuInsdMiBaseService.regInsuInsdMiBase(dom);
        InsuInsdMiBaseEntity result = insuInsdMiBaseService.getInsuInsdMiBase(new InsuInsdMiBaseSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuInsdMiBaseEntity>> modInsuInsdMiBase(
        @RequestBody InsuInsdMiBaseForm dom
    ){
        insuInsdMiBaseService.modInsuInsdMiBase(dom);
        InsuInsdMiBaseEntity result = insuInsdMiBaseService.getInsuInsdMiBase(new InsuInsdMiBaseSearch(dom));
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
