package com.kpcnc.mydataapi.api.base.gurt.controller;

import com.kpcnc.mydataapi.api.base.gurt.models.GurtInsdSearch;
import com.kpcnc.mydataapi.api.base.gurt.models.entity.GurtInsdEntity;
import com.kpcnc.mydataapi.api.base.gurt.models.form.GurtInsdForm;
import com.kpcnc.mydataapi.api.base.gurt.service.GurtInsdService;
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
@RequestMapping(value = "/gurtInsd", produces="application/json;charset=UTF-8")
public class GurtInsdController {
    @Autowired
    GurtInsdService gurtInsdService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<GurtInsdEntity>> regGurtInsd(
        @RequestBody GurtInsdForm dom
    ){
        GurtInsdEntity result = gurtInsdService.regGurtInsd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<GurtInsdEntity>> modGurtInsd(
        @RequestBody GurtInsdForm dom
    ){
        GurtInsdEntity result = gurtInsdService.modGurtInsd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<GurtInsdEntity>> getGurtInsd(
        @RequestBody GurtInsdSearch dom
    ){
        GurtInsdEntity result = gurtInsdService.getGurtInsd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<GurtInsdEntity>>> getGurtInsdList(
        @RequestBody GurtInsdSearch dom
    ){
        ResultListDto<GurtInsdEntity> resultList = gurtInsdService.getGurtInsdList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
