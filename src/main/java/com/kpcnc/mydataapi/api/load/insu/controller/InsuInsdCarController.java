package com.kpcnc.mydataapi.api.load.insu.controller;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdCarSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdCarEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdCarForm;
import com.kpcnc.mydataapi.api.load.insu.service.InsuInsdCarService;
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
@RequestMapping(value = "/insuInsdCar", produces="application/json;charset=UTF-8")
public class InsuInsdCarController {
    @Autowired
    InsuInsdCarService insuInsdCarService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuInsdCarEntity>> regInsuInsdCar(
        @RequestBody InsuInsdCarForm dom
    ){
        InsuInsdCarEntity result = insuInsdCarService.regInsuInsdCar(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuInsdCarEntity>> modInsuInsdCar(
        @RequestBody InsuInsdCarForm dom
    ){
        InsuInsdCarEntity result = insuInsdCarService.modInsuInsdCar(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InsuInsdCarEntity>> getInsuInsdCar(
        @RequestBody InsuInsdCarSearch dom
    ){
        InsuInsdCarEntity result = insuInsdCarService.getInsuInsdCar(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InsuInsdCarEntity>>> getInsuInsdCarList(
        @RequestBody InsuInsdCarSearch dom
    ){
        ResultListDto<InsuInsdCarEntity> resultList = insuInsdCarService.getInsuInsdCarList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
