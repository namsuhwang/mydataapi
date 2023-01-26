package com.kpcnc.mydataapi.api.base.dc.controller;

import com.kpcnc.mydataapi.api.base.dc.models.DcAddSearch;
import com.kpcnc.mydataapi.api.base.dc.models.entity.DcAddEntity;
import com.kpcnc.mydataapi.api.base.dc.models.form.DcAddForm;
import com.kpcnc.mydataapi.api.base.dc.service.DcAddService;
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

@Slf4j
@RestController
@EnableWebMvc
@RequiredArgsConstructor
@RequestMapping(value = "/dcAdd", produces="application/json;charset=UTF-8")
public class DcAddController {
    @Autowired
    DcAddService dcAddService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<DcAddEntity>> regDcAdd(
        @RequestBody DcAddForm dom
    ){
        dcAddService.regDcAdd(dom);
        DcAddEntity result = dcAddService.getDcAdd(new DcAddSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<DcAddEntity>> modDcAdd(
        @RequestBody DcAddForm dom
    ){
        dcAddService.modDcAdd(dom);
        DcAddEntity result = dcAddService.getDcAdd(new DcAddSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<DcAddEntity>> getDcAdd(
        @RequestBody DcAddSearch dom
    ){
        DcAddEntity result = dcAddService.getDcAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<DcAddEntity>>> getDcAddList(
        @RequestBody DcAddSearch dom
    ){
        ResultListDto<DcAddEntity> resultList = dcAddService.getDcAddList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
