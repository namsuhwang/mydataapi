package com.albee.mydataapi.api.base.gurt.controller;

import com.albee.mydataapi.api.base.gurt.models.GurtBaseSearch;
import com.albee.mydataapi.api.base.gurt.models.entity.GurtBaseEntity;
import com.albee.mydataapi.api.base.gurt.models.form.GurtBaseForm;
import com.albee.mydataapi.api.base.gurt.service.GurtBaseService;
import com.albee.mydataapi.common.models.dto.ResultListDto;
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
@RequestMapping(value = "/gurtBase", produces="application/json;charset=UTF-8")
public class GurtBaseController {
    @Autowired
    GurtBaseService gurtBaseService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<GurtBaseEntity>> regGurtBase(
        @RequestBody GurtBaseForm dom
    ){
        GurtBaseEntity result = gurtBaseService.regGurtBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<GurtBaseEntity>> modGurtBase(
        @RequestBody GurtBaseForm dom
    ){
        GurtBaseEntity result = gurtBaseService.modGurtBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<GurtBaseEntity>> getGurtBase(
        @RequestBody GurtBaseSearch dom
    ){
        GurtBaseEntity result = gurtBaseService.getGurtBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<GurtBaseEntity>>> getGurtBaseList(
        @RequestBody GurtBaseSearch dom
    ){
        ResultListDto<GurtBaseEntity> resultList = gurtBaseService.getGurtBaseList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
