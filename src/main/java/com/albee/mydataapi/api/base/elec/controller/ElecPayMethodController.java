package com.albee.mydataapi.api.base.elec.controller;

import com.albee.mydataapi.api.base.elec.models.entity.ElecPayMethodEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPayMethodForm;
import com.albee.mydataapi.api.base.elec.service.ElecPayMethodService;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.elec.models.ElecPayMethodSearch;
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
@RequestMapping(value = "/elecPayMethod", produces="application/json;charset=UTF-8")
public class ElecPayMethodController {
    @Autowired
    ElecPayMethodService elecPayMethodService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ElecPayMethodEntity>> regElecPayMethod(
        @RequestBody ElecPayMethodForm dom
    ){
        elecPayMethodService.regElecPayMethod(dom);
        ElecPayMethodEntity result = elecPayMethodService.getElecPayMethod(new ElecPayMethodSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ElecPayMethodEntity>> modElecPayMethod(
        @RequestBody ElecPayMethodForm dom
    ){
        elecPayMethodService.modElecPayMethod(dom);
        ElecPayMethodEntity result = elecPayMethodService.getElecPayMethod(new ElecPayMethodSearch(dom));
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