package com.albee.mydataapi.api.base.insu.controller;

import com.albee.mydataapi.api.base.insu.models.entity.InsuMiBaseEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuMiBaseForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuMiBaseSearch;
import com.albee.mydataapi.api.base.insu.service.InsuMiBaseService;
import com.albee.mydataapi.common.models.dto.ResponseDto;
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
@RequestMapping(value = "/insuMiBase", produces="application/json;charset=UTF-8")
public class InsuMiBaseController {
    @Autowired
    InsuMiBaseService insuMiBaseService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuMiBaseEntity>> regInsuMiBase(
        @RequestBody InsuMiBaseForm dom
    ){
        insuMiBaseService.regInsuMiBase(dom);
        InsuMiBaseEntity result = insuMiBaseService.getInsuMiBase(new InsuMiBaseSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuMiBaseEntity>> modInsuMiBase(
        @RequestBody InsuMiBaseForm dom
    ){
        insuMiBaseService.modInsuMiBase(dom);
        InsuMiBaseEntity result = insuMiBaseService.getInsuMiBase(new InsuMiBaseSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuMiBaseEntity>> getInsuMiBase(
        @RequestBody InsuMiBaseSearch dom
    ){
        InsuMiBaseEntity result = insuMiBaseService.getInsuMiBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuMiBaseEntity>>> getInsuMiBaseList(
        @RequestBody InsuMiBaseSearch dom
    ){
        ResultListDto<InsuMiBaseEntity> resultList = insuMiBaseService.getInsuMiBaseList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
