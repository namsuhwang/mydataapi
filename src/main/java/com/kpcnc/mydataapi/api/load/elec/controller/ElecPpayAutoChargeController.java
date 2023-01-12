package com.kpcnc.mydataapi.api.load.elec.controller;

import com.kpcnc.mydataapi.api.ElecPpayAutoChargeSearch;
import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPpayAutoChargeEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecPpayAutoChargeForm;
import com.kpcnc.mydataapi.api.load.elec.service.ElecPpayAutoChargeService;
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
@RequestMapping(value = "/elecPpayAutoCharge", produces="application/json;charset=UTF-8")
public class ElecPpayAutoChargeController {
    @Autowired
    ElecPpayAutoChargeService elecPpayAutoChargeService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ElecPpayAutoChargeEntity>> regElecPpayAutoCharge(
        @RequestBody ElecPpayAutoChargeForm dom
    ){
        ElecPpayAutoChargeEntity result = elecPpayAutoChargeService.regElecPpayAutoCharge(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ElecPpayAutoChargeEntity>> modElecPpayAutoCharge(
        @RequestBody ElecPpayAutoChargeForm dom
    ){
        ElecPpayAutoChargeEntity result = elecPpayAutoChargeService.modElecPpayAutoCharge(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<ElecPpayAutoChargeEntity>> getElecPpayAutoCharge(
        @RequestBody ElecPpayAutoChargeSearch dom
    ){
        ElecPpayAutoChargeEntity result = elecPpayAutoChargeService.getElecPpayAutoCharge(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<ElecPpayAutoChargeEntity>>> getElecPpayAutoChargeList(
        @RequestBody ElecPpayAutoChargeSearch dom
    ){
        ResultListDto<ElecPpayAutoChargeEntity> resultList = elecPpayAutoChargeService.getElecPpayAutoChargeList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
