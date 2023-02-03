package com.albee.mydataapi.api.base.elec.controller;

import com.albee.mydataapi.api.base.elec.models.entity.ElecAccEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecAccForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.elec.models.ElecAccSearch;
import com.albee.mydataapi.api.base.elec.service.ElecAccService;
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
@RequestMapping(value = "/elecAcc", produces="application/json;charset=UTF-8")
public class ElecAccController {
    @Autowired
    ElecAccService elecAccService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ElecAccEntity>> regElecAcc(
        @RequestBody ElecAccForm dom
    ){
        elecAccService.regElecAcc(dom);
        ElecAccEntity result = elecAccService.getElecAcc(new ElecAccSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ElecAccEntity>> modElecAcc(
        @RequestBody ElecAccForm dom
    ){
        elecAccService.modElecAcc(dom);
        ElecAccEntity result = elecAccService.getElecAcc(new ElecAccSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<ElecAccEntity>> getElecAcc(
        @RequestBody ElecAccSearch dom
    ){
        ElecAccEntity result = elecAccService.getElecAcc(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<ElecAccEntity>>> getElecAccList(
        @RequestBody ElecAccSearch dom
    ){
        ResultListDto<ElecAccEntity> resultList = elecAccService.getElecAccList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
