package com.albee.mydataapi.api.base.ppay.controller;

import com.albee.mydataapi.api.base.ppay.models.entity.PpayHistEntity;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.ppay.models.PpayHistSearch;
import com.albee.mydataapi.api.base.ppay.models.form.PpayHistForm;
import com.albee.mydataapi.api.base.ppay.service.PpayHistService;
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
@RequestMapping(value = "/ppayHist", produces="application/json;charset=UTF-8")
public class PpayHistController {
    @Autowired
    PpayHistService ppayHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<PpayHistEntity>> regPpayHist(
        @RequestBody PpayHistForm dom
    ){
        PpayHistEntity result = ppayHistService.regPpayHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<PpayHistEntity>> modPpayHist(
        @RequestBody PpayHistForm dom
    ){
        PpayHistEntity result = ppayHistService.modPpayHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<PpayHistEntity>> getPpayHist(
        @RequestBody PpayHistSearch dom
    ){
        PpayHistEntity result = ppayHistService.getPpayHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<PpayHistEntity>>> getPpayHistList(
        @RequestBody PpayHistSearch dom
    ){
        ResultListDto<PpayHistEntity> resultList = ppayHistService.getPpayHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
