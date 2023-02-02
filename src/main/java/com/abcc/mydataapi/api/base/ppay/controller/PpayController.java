package com.abcc.mydataapi.api.base.ppay.controller;

import com.abcc.mydataapi.api.base.ppay.models.entity.PpayEntity;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.ppay.models.PpaySearch;
import com.abcc.mydataapi.api.base.ppay.models.form.PpayForm;
import com.abcc.mydataapi.api.base.ppay.service.PpayService;
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
@RequestMapping(value = "/ppay", produces="application/json;charset=UTF-8")
public class PpayController {
    @Autowired
    PpayService ppayService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<PpayEntity>> regPpay(
        @RequestBody PpayForm dom
    ){
        PpayEntity result = ppayService.regPpay(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<PpayEntity>> modPpay(
        @RequestBody PpayForm dom
    ){
        PpayEntity result = ppayService.modPpay(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<PpayEntity>> getPpay(
        @RequestBody PpaySearch dom
    ){
        PpayEntity result = ppayService.getPpay(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<PpayEntity>>> getPpayList(
        @RequestBody PpaySearch dom
    ){
        ResultListDto<PpayEntity> resultList = ppayService.getPpayList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
