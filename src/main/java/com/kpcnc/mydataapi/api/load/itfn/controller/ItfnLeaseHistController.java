package com.kpcnc.mydataapi.api.load.itfn.controller;

import com.kpcnc.mydataapi.api.load.itfn.models.ItfnLeaseHistSearch;
import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnLeaseHistEntity;
import com.kpcnc.mydataapi.api.load.itfn.models.form.ItfnLeaseHistForm;
import com.kpcnc.mydataapi.api.load.itfn.service.ItfnLeaseHistService;
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
@RequestMapping(value = "/itfnLeaseHist", produces="application/json;charset=UTF-8")
public class ItfnLeaseHistController {
    @Autowired
    ItfnLeaseHistService itfnLeaseHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ItfnLeaseHistEntity>> regItfnLeaseHist(
        @RequestBody ItfnLeaseHistForm dom
    ){
        ItfnLeaseHistEntity result = itfnLeaseHistService.regItfnLeaseHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ItfnLeaseHistEntity>> modItfnLeaseHist(
        @RequestBody ItfnLeaseHistForm dom
    ){
        ItfnLeaseHistEntity result = itfnLeaseHistService.modItfnLeaseHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<ItfnLeaseHistEntity>> getItfnLeaseHist(
        @RequestBody ItfnLeaseHistSearch dom
    ){
        ItfnLeaseHistEntity result = itfnLeaseHistService.getItfnLeaseHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<ItfnLeaseHistEntity>>> getItfnLeaseHistList(
        @RequestBody ItfnLeaseHistSearch dom
    ){
        ResultListDto<ItfnLeaseHistEntity> resultList = itfnLeaseHistService.getItfnLeaseHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
