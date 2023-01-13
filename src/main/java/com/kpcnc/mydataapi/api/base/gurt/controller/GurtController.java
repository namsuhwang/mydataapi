package com.kpcnc.mydataapi.api.base.gurt.controller;

import com.kpcnc.mydataapi.api.base.gurt.models.GurtSearch;
import com.kpcnc.mydataapi.api.base.gurt.models.entity.GurtEntity;
import com.kpcnc.mydataapi.api.base.gurt.models.form.GurtForm;
import com.kpcnc.mydataapi.api.base.gurt.service.GurtService;
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
@RequestMapping(value = "/gurt", produces="application/json;charset=UTF-8")
public class GurtController {
    @Autowired
    GurtService gurtService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<GurtEntity>> regGurt(
        @RequestBody GurtForm dom
    ){
        GurtEntity result = gurtService.regGurt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<GurtEntity>> modGurt(
        @RequestBody GurtForm dom
    ){
        GurtEntity result = gurtService.modGurt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<GurtEntity>> getGurt(
        @RequestBody GurtSearch dom
    ){
        GurtEntity result = gurtService.getGurt(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<GurtEntity>>> getGurtList(
        @RequestBody GurtSearch dom
    ){
        ResultListDto<GurtEntity> resultList = gurtService.getGurtList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
