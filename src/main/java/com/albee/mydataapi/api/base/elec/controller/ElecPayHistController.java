package com.albee.mydataapi.api.base.elec.controller;

import com.albee.mydataapi.api.base.elec.models.ElecPayHistSearch;
import com.albee.mydataapi.api.base.elec.models.entity.ElecPayHistEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPayHistForm;
import com.albee.mydataapi.api.base.elec.service.ElecPayHistService;
import com.albee.mydataapi.common.models.dto.ResponseDto;
import com.albee.mydataapi.common.models.dto.ResultListDto;
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
@RequestMapping(value = "/elecPayHist", produces="application/json;charset=UTF-8")
public class ElecPayHistController {
    @Autowired
    ElecPayHistService elecPayHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ElecPayHistEntity>> regElecPayHist(
        @RequestBody ElecPayHistForm dom
    ){
        elecPayHistService.regElecPayHist(dom);
        ElecPayHistEntity result = elecPayHistService.getElecPayHistLast(new ElecPayHistSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ElecPayHistEntity>> modElecPayHist(
        @RequestBody ElecPayHistForm dom
    ){
        elecPayHistService.modElecPayHist(dom);
        ElecPayHistEntity result = elecPayHistService.getElecPayHistLast(new ElecPayHistSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<ElecPayHistEntity>> getElecPayHist(
        @RequestBody ElecPayHistSearch dom
    ){
        ElecPayHistEntity result = elecPayHistService.getElecPayHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<ElecPayHistEntity>>> getElecPayHistList(
        @RequestBody ElecPayHistSearch dom
    ){
        ResultListDto<ElecPayHistEntity> resultList = elecPayHistService.getElecPayHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
