package com.albee.mydataapi.api.base.elec.controller;

import com.albee.mydataapi.api.base.elec.models.entity.ElecPpayHistEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPpayHistForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.elec.models.ElecPpayHistSearch;
import com.albee.mydataapi.api.base.elec.service.ElecPpayHistService;
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
@RequestMapping(value = "/elecPpayHist", produces="application/json;charset=UTF-8")
public class ElecPpayHistController {
    @Autowired
    ElecPpayHistService elecPpayHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ElecPpayHistEntity>> regElecPpayHist(
        @RequestBody ElecPpayHistForm dom
    ){
        elecPpayHistService.regElecPpayHist(dom);
        ElecPpayHistEntity result = elecPpayHistService.getElecPpayHist(new ElecPpayHistSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ElecPpayHistEntity>> modElecPpayHist(
        @RequestBody ElecPpayHistForm dom
    ){
        elecPpayHistService.modElecPpayHist(dom);
        ElecPpayHistEntity result = elecPpayHistService.getElecPpayHist(new ElecPpayHistSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<ElecPpayHistEntity>> getElecPpayHist(
        @RequestBody ElecPpayHistSearch dom
    ){
        ElecPpayHistEntity result = elecPpayHistService.getElecPpayHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<ElecPpayHistEntity>>> getElecPpayHistList(
        @RequestBody ElecPpayHistSearch dom
    ){
        ResultListDto<ElecPpayHistEntity> resultList = elecPpayHistService.getElecPpayHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
