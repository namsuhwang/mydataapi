package com.kpcnc.mydataapi.api.load.elec.controller;

import com.kpcnc.mydataapi.api.load.elec.models.ElecPpayAccSearch;
import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPpayAccEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecPpayAccForm;
import com.kpcnc.mydataapi.api.load.elec.service.ElecPpayAccService;
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
@RequestMapping(value = "/elecPpayAcc", produces="application/json;charset=UTF-8")
public class ElecPpayAccController {
    @Autowired
    ElecPpayAccService elecPpayAccService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ElecPpayAccEntity>> regElecPpayAcc(
        @RequestBody ElecPpayAccForm dom
    ){
        ElecPpayAccEntity result = elecPpayAccService.regElecPpayAcc(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ElecPpayAccEntity>> modElecPpayAcc(
        @RequestBody ElecPpayAccForm dom
    ){
        ElecPpayAccEntity result = elecPpayAccService.modElecPpayAcc(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<ElecPpayAccEntity>> getElecPpayAcc(
        @RequestBody ElecPpayAccSearch dom
    ){
        ElecPpayAccEntity result = elecPpayAccService.getElecPpayAcc(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<ElecPpayAccEntity>>> getElecPpayAccList(
        @RequestBody ElecPpayAccSearch dom
    ){
        ResultListDto<ElecPpayAccEntity> resultList = elecPpayAccService.getElecPpayAccList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
