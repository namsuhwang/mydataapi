package com.albee.mydataapi.api.base.insu.controller;

import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdCarEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuInsdCarForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuInsdCarSearch;
import com.albee.mydataapi.api.base.insu.service.InsuInsdCarService;
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
@RequestMapping(value = "/insuInsdCar", produces="application/json;charset=UTF-8")
public class InsuInsdCarController {
    @Autowired
    InsuInsdCarService insuInsdCarService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InsuInsdCarEntity>> regInsuInsdCar(
        @RequestBody InsuInsdCarForm dom
    ){
        insuInsdCarService.regInsuInsdCar(dom);
        InsuInsdCarEntity result = insuInsdCarService.getInsuInsdCar(new InsuInsdCarSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InsuInsdCarEntity>> modInsuInsdCar(
        @RequestBody InsuInsdCarForm dom
    ){
        insuInsdCarService.modInsuInsdCar(dom);
        InsuInsdCarEntity result = insuInsdCarService.getInsuInsdCar(new InsuInsdCarSearch(dom));
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
