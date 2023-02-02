package com.albee.mydataapi.api.base.gurt.controller;

import com.albee.mydataapi.api.base.gurt.models.GurtHistSearch;
import com.albee.mydataapi.api.base.gurt.models.entity.GurtHistEntity;
import com.albee.mydataapi.api.base.gurt.models.form.GurtHistForm;
import com.albee.mydataapi.api.base.gurt.service.GurtHistService;
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
@RequestMapping(value = "/gurtHist", produces="application/json;charset=UTF-8")
public class GurtHistController {
    @Autowired
    GurtHistService gurtHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<GurtHistEntity>> regGurtHist(
        @RequestBody GurtHistForm dom
    ){
        GurtHistEntity result = gurtHistService.regGurtHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<GurtHistEntity>> modGurtHist(
        @RequestBody GurtHistForm dom
    ){
        GurtHistEntity result = gurtHistService.modGurtHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<GurtHistEntity>> getGurtHist(
        @RequestBody GurtHistSearch dom
    ){
        GurtHistEntity result = gurtHistService.getGurtHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<GurtHistEntity>>> getGurtHistList(
        @RequestBody GurtHistSearch dom
    ){
        ResultListDto<GurtHistEntity> resultList = gurtHistService.getGurtHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
