package com.kpcnc.mydataapi.api.load.elec.controller;

import com.kpcnc.mydataapi.api.load.elec.models.ElecPpaySearch;
import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPpayEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecPpayForm;
import com.kpcnc.mydataapi.api.load.elec.service.ElecPpayService;
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

import java.util.List;

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
