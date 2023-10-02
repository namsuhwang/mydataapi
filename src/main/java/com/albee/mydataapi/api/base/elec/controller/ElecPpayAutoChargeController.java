package com.albee.mydataapi.api.base.elec.controller;

import com.albee.mydataapi.api.base.elec.models.entity.ElecPpayAutoChargeEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPpayAutoChargeForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.elec.models.ElecPpayAutoChargeSearch;
import com.albee.mydataapi.api.base.elec.service.ElecPpayAutoChargeService;
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
@RequestMapping(value = "/elecPpayAutoCharge", produces="application/json;charset=UTF-8")
public class ElecPpayAutoChargeController {
    @Autowired
    ElecPpayAutoChargeService elecPpayAutoChargeService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ElecPpayAutoChargeEntity>> regElecPpayAutoCharge(
        @RequestBody ElecPpayAutoChargeForm dom
    ){
        elecPpayAutoChargeService.regElecPpayAutoCharge(dom);
        ElecPpayAutoChargeEntity result = elecPpayAutoChargeService.getElecPpayAutoCharge(new ElecPpayAutoChargeSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ElecPpayAutoChargeEntity>> modElecPpayAutoCharge(
        @RequestBody ElecPpayAutoChargeForm dom
    ){
        elecPpayAutoChargeService.modElecPpayAutoCharge(dom);
        ElecPpayAutoChargeEntity result = elecPpayAutoChargeService.getElecPpayAutoCharge(new ElecPpayAutoChargeSearch(dom));
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
