package com.albee.mydataapi.api.base.ppay.controller;

import com.albee.mydataapi.api.base.ppay.models.entity.PpayBalEntity;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.ppay.models.PpayBalSearch;
import com.albee.mydataapi.api.base.ppay.models.form.PpayBalForm;
import com.albee.mydataapi.api.base.ppay.service.PpayBalService;
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
@RequestMapping(value = "/ppayBal", produces="application/json;charset=UTF-8")
public class PpayBalController {
    @Autowired
    PpayBalService ppayBalService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<PpayBalEntity>> regPpayBal(
        @RequestBody PpayBalForm dom
    ){
        PpayBalEntity result = ppayBalService.regPpayBal(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<PpayBalEntity>> modPpayBal(
        @RequestBody PpayBalForm dom
    ){
        PpayBalEntity result = ppayBalService.modPpayBal(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<PpayBalEntity>> getPpayBal(
        @RequestBody PpayBalSearch dom
    ){
        PpayBalEntity result = ppayBalService.getPpayBal(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<PpayBalEntity>>> getPpayBalList(
        @RequestBody PpayBalSearch dom
    ){
        ResultListDto<PpayBalEntity> resultList = ppayBalService.getPpayBalList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
