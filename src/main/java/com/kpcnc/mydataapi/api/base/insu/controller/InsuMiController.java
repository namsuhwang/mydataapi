package com.kpcnc.mydataapi.api.base.insu.controller;

import com.kpcnc.mydataapi.api.base.insu.models.InsuMiSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuMiEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiForm;
import com.kpcnc.mydataapi.api.base.insu.service.InsuMiService;
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
@RequestMapping(value = "/insuMi", produces="application/json;charset=UTF-8")
public class InsuMiController {
    @Autowired
    InsuMiService insuMiService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuMiEntity>> regInsuMi(
        @RequestBody InsuMiForm dom
    ){
        insuMiService.regInsuMi(dom);
        InsuMiEntity result = insuMiService.getInsuMi(new InsuMiSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuMiEntity>> modInsuMi(
        @RequestBody InsuMiForm dom
    ){
        insuMiService.modInsuMi(dom);
        InsuMiEntity result = insuMiService.getInsuMi(new InsuMiSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuMiEntity>> getInsuMi(
        @RequestBody InsuMiSearch dom
    ){
        InsuMiEntity result = insuMiService.getInsuMi(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuMiEntity>>> getInsuMiList(
        @RequestBody InsuMiSearch dom
    ){
        ResultListDto<InsuMiEntity> resultList = insuMiService.getInsuMiList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
