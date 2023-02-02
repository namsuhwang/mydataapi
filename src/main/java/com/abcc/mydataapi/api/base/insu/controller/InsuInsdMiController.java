package com.abcc.mydataapi.api.base.insu.controller;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuInsdMiEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuInsdMiForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuInsdMiSearch;
import com.abcc.mydataapi.api.base.insu.service.InsuInsdMiService;
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
@RequestMapping(value = "/insuInsdMi", produces="application/json;charset=UTF-8")
public class InsuInsdMiController {
    @Autowired
    InsuInsdMiService insuInsdMiService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuInsdMiEntity>> regInsuInsdMi(
        @RequestBody InsuInsdMiForm dom
    ){
        insuInsdMiService.regInsuInsdMi(dom);
        InsuInsdMiEntity result = insuInsdMiService.getInsuInsdMi(new InsuInsdMiSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuInsdMiEntity>> modInsuInsdMi(
        @RequestBody InsuInsdMiForm dom
    ){
        insuInsdMiService.modInsuInsdMi(dom);
        InsuInsdMiEntity result = insuInsdMiService.getInsuInsdMi(new InsuInsdMiSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuInsdMiEntity>> getInsuInsdMi(
        @RequestBody InsuInsdMiSearch dom
    ){
        InsuInsdMiEntity result = insuInsdMiService.getInsuInsdMi(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuInsdMiEntity>>> getInsuInsdMiList(
        @RequestBody InsuInsdMiSearch dom
    ){
        ResultListDto<InsuInsdMiEntity> resultList = insuInsdMiService.getInsuInsdMiList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
