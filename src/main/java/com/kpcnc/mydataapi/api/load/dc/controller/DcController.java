package com.kpcnc.mydataapi.api.load.dc.controller;

import com.kpcnc.mydataapi.api.load.dc.models.DcSearch;
import com.kpcnc.mydataapi.api.load.dc.models.entity.DcEntity;
import com.kpcnc.mydataapi.api.load.dc.models.form.DcForm;
import com.kpcnc.mydataapi.api.load.dc.service.DcService;
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
@RequestMapping(value = "/dc", produces="application/json;charset=UTF-8")
public class DcController {
    @Autowired
    DcService dcService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<DcEntity>> regDc(
        @RequestBody DcForm dom
    ){
        DcEntity result = dcService.regDc(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<DcEntity>> modDc(
        @RequestBody DcForm dom
    ){
        DcEntity result = dcService.modDc(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<DcEntity>> getDc(
        @RequestBody DcSearch dom
    ){
        DcEntity result = dcService.getDc(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<DcEntity>>> getDcList(
        @RequestBody DcSearch dom
    ){
        ResultListDto<DcEntity> resultList = dcService.getDcList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
