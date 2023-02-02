package com.albee.mydataapi.api.base.elec.controller;

import com.albee.mydataapi.api.base.elec.models.ElecPpaySearch;
import com.albee.mydataapi.api.base.elec.models.entity.ElecPpayEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPpayForm;
import com.albee.mydataapi.api.base.elec.service.ElecPpayService;
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
@RequestMapping(value = "/elecPpay", produces="application/json;charset=UTF-8")
public class ElecPpayController {
    @Autowired
    ElecPpayService elecPpayService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ElecPpayEntity>> regElecPpay(
        @RequestBody ElecPpayForm dom
    ){
        ElecPpayEntity result = elecPpayService.regElecPpay(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ElecPpayEntity>> modElecPpay(
        @RequestBody ElecPpayForm dom
    ){
        ElecPpayEntity result = elecPpayService.modElecPpay(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<ElecPpayEntity>> getElecPpay(
        @RequestBody ElecPpaySearch dom
    ){
        ElecPpayEntity result = elecPpayService.getElecPpay(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<ElecPpayEntity>>> getElecPpayList(
        @RequestBody ElecPpaySearch dom
    ){
        ResultListDto<ElecPpayEntity> resultList = elecPpayService.getElecPpayList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
