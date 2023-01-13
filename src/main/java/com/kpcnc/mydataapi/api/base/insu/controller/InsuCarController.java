package com.kpcnc.mydataapi.api.base.insu.controller;

import com.kpcnc.mydataapi.api.base.insu.models.InsuCarSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuCarEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuCarForm;
import com.kpcnc.mydataapi.api.base.insu.service.InsuCarService;
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
@RequestMapping(value = "/insuCar", produces="application/json;charset=UTF-8")
public class InsuCarController {
    @Autowired
    InsuCarService insuCarService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuCarEntity>> regInsuCar(
        @RequestBody InsuCarForm dom
    ){
        InsuCarEntity result = insuCarService.regInsuCar(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuCarEntity>> modInsuCar(
        @RequestBody InsuCarForm dom
    ){
        InsuCarEntity result = insuCarService.modInsuCar(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuCarEntity>> getInsuCar(
        @RequestBody InsuCarSearch dom
    ){
        InsuCarEntity result = insuCarService.getInsuCar(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuCarEntity>>> getInsuCarList(
        @RequestBody InsuCarSearch dom
    ){
        ResultListDto<InsuCarEntity> resultList = insuCarService.getInsuCarList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
