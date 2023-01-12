package com.kpcnc.mydataapi.api.load.elec.controller;

import com.kpcnc.mydataapi.api.load.elec.models.ElecPpayHistSearch;
import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPpayHistEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecPpayHistForm;
import com.kpcnc.mydataapi.api.load.elec.service.ElecPpayHistService;
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
@RequestMapping(value = "/elecPpayHist", produces="application/json;charset=UTF-8")
public class ElecPpayHistController {
    @Autowired
    ElecPpayHistService elecPpayHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ElecPpayHistEntity>> regElecPpayHist(
        @RequestBody ElecPpayHistForm dom
    ){
        ElecPpayHistEntity result = elecPpayHistService.regElecPpayHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ElecPpayHistEntity>> modElecPpayHist(
        @RequestBody ElecPpayHistForm dom
    ){
        ElecPpayHistEntity result = elecPpayHistService.modElecPpayHist(dom);
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
