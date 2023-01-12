package com.kpcnc.mydataapi.api.load.elec.controller;

import com.kpcnc.mydataapi.api.load.elec.models.ElecPayMethodSearch;
import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPayMethodEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecPayMethodForm;
import com.kpcnc.mydataapi.api.load.elec.service.ElecPayMethodService;
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
@RequestMapping(value = "/elecPayMethod", produces="application/json;charset=UTF-8")
public class ElecPayMethodController {
    @Autowired
    ElecPayMethodService elecPayMethodService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ElecPayMethodEntity>> regElecPayMethod(
        @RequestBody ElecPayMethodForm dom
    ){
        ElecPayMethodEntity result = elecPayMethodService.regElecPayMethod(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ElecPayMethodEntity>> modElecPayMethod(
        @RequestBody ElecPayMethodForm dom
    ){
        ElecPayMethodEntity result = elecPayMethodService.modElecPayMethod(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<ElecPayMethodEntity>> getElecPayMethod(
        @RequestBody ElecPayMethodSearch dom
    ){
        ElecPayMethodEntity result = elecPayMethodService.getElecPayMethod(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<ElecPayMethodEntity>>> getElecPayMethodList(
        @RequestBody ElecPayMethodSearch dom
    ){
        ResultListDto<ElecPayMethodEntity> resultList = elecPayMethodService.getElecPayMethodList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}