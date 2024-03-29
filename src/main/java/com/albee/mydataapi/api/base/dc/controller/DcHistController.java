package com.albee.mydataapi.api.base.dc.controller;

import com.albee.mydataapi.api.base.dc.models.entity.DcHistEntity;
import com.albee.mydataapi.api.base.dc.models.form.DcHistForm;
import com.albee.mydataapi.api.base.dc.service.DcHistService;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.dc.models.DcHistSearch;
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
@RequestMapping(value = "/dcHist", produces="application/json;charset=UTF-8")
public class DcHistController {
    @Autowired
    DcHistService dcHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<DcHistEntity>> regDcHist(
        @RequestBody DcHistForm dom
    ){
        DcHistEntity result = dcHistService.regDcHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<DcHistEntity>> modDcHist(
        @RequestBody DcHistForm dom
    ){
        DcHistEntity result = dcHistService.modDcHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<DcHistEntity>> getDcHist(
        @RequestBody DcHistSearch dom
    ){
        DcHistEntity result = dcHistService.getDcHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<DcHistEntity>>> getDcHistList(
        @RequestBody DcHistSearch dom
    ){
        ResultListDto<DcHistEntity> resultList = dcHistService.getDcHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
