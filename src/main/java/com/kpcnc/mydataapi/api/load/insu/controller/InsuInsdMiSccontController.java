package com.kpcnc.mydataapi.api.load.insu.controller;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdMiSccontSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdMiSccontEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdMiSccontForm;
import com.kpcnc.mydataapi.api.load.insu.service.InsuInsdMiSccontService;
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
@RequestMapping(value = "/insuInsdMiSccont", produces="application/json;charset=UTF-8")
public class InsuInsdMiSccontController {
    @Autowired
    InsuInsdMiSccontService insuInsdMiSccontService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuInsdMiSccontEntity>> regInsuInsdMiSccont(
        @RequestBody InsuInsdMiSccontForm dom
    ){
        InsuInsdMiSccontEntity result = insuInsdMiSccontService.regInsuInsdMiSccont(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuInsdMiSccontEntity>> modInsuInsdMiSccont(
        @RequestBody InsuInsdMiSccontForm dom
    ){
        InsuInsdMiSccontEntity result = insuInsdMiSccontService.modInsuInsdMiSccont(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuInsdMiSccontEntity>> getInsuInsdMiSccont(
        @RequestBody InsuInsdMiSccontSearch dom
    ){
        InsuInsdMiSccontEntity result = insuInsdMiSccontService.getInsuInsdMiSccont(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuInsdMiSccontEntity>>> getInsuInsdMiSccontList(
        @RequestBody InsuInsdMiSccontSearch dom
    ){
        ResultListDto<InsuInsdMiSccontEntity> resultList = insuInsdMiSccontService.getInsuInsdMiSccontList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
