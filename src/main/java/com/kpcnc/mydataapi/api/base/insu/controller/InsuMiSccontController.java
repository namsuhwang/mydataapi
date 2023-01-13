package com.kpcnc.mydataapi.api.base.insu.controller;

import com.kpcnc.mydataapi.api.base.insu.models.InsuMiSccontSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuMiSccontEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiSccontForm;
import com.kpcnc.mydataapi.api.base.insu.service.InsuMiSccontService;
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
@RequestMapping(value = "/insuMiSccont", produces="application/json;charset=UTF-8")
public class InsuMiSccontController {
    @Autowired
    InsuMiSccontService insuMiSccontService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuMiSccontEntity>> regInsuMiSccont(
        @RequestBody InsuMiSccontForm dom
    ){
        InsuMiSccontEntity result = insuMiSccontService.regInsuMiSccont(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuMiSccontEntity>> modInsuMiSccont(
        @RequestBody InsuMiSccontForm dom
    ){
        InsuMiSccontEntity result = insuMiSccontService.modInsuMiSccont(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuMiSccontEntity>> getInsuMiSccont(
        @RequestBody InsuMiSccontSearch dom
    ){
        InsuMiSccontEntity result = insuMiSccontService.getInsuMiSccont(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuMiSccontEntity>>> getInsuMiSccontList(
        @RequestBody InsuMiSccontSearch dom
    ){
        ResultListDto<InsuMiSccontEntity> resultList = insuMiSccontService.getInsuMiSccontList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
