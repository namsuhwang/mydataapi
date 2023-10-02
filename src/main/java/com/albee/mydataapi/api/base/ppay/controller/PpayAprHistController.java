package com.albee.mydataapi.api.base.ppay.controller;

import com.albee.mydataapi.api.base.ppay.models.entity.PpayAprHistEntity;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.ppay.models.PpayAprHistSearch;
import com.albee.mydataapi.api.base.ppay.models.form.PpayAprHistForm;
import com.albee.mydataapi.api.base.ppay.service.PpayAprHistService;
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
@RequestMapping(value = "/ppayAprHist", produces="application/json;charset=UTF-8")
public class PpayAprHistController {
    @Autowired
    PpayAprHistService ppayAprHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<PpayAprHistEntity>> regPpayAprHist(
        @RequestBody PpayAprHistForm dom
    ){
        PpayAprHistEntity result = ppayAprHistService.regPpayAprHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<PpayAprHistEntity>> modPpayAprHist(
        @RequestBody PpayAprHistForm dom
    ){
        PpayAprHistEntity result = ppayAprHistService.modPpayAprHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<PpayAprHistEntity>> getPpayAprHist(
        @RequestBody PpayAprHistSearch dom
    ){
        PpayAprHistEntity result = ppayAprHistService.getPpayAprHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<PpayAprHistEntity>>> getPpayAprHistList(
        @RequestBody PpayAprHistSearch dom
    ){
        ResultListDto<PpayAprHistEntity> resultList = ppayAprHistService.getPpayAprHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
