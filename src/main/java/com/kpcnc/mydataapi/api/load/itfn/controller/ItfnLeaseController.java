package com.kpcnc.mydataapi.api.load.itfn.controller;

import com.kpcnc.mydataapi.api.load.itfn.models.ItfnLeaseSearch;
import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnLeaseEntity;
import com.kpcnc.mydataapi.api.load.itfn.models.form.ItfnLeaseForm;
import com.kpcnc.mydataapi.api.load.itfn.service.ItfnLeaseService;
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
@RequestMapping(value = "/itfnLease", produces="application/json;charset=UTF-8")
public class ItfnLeaseController {
    @Autowired
    ItfnLeaseService itfnLeaseService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ItfnLeaseEntity>> regItfnLease(
        @RequestBody ItfnLeaseForm dom
    ){
        ItfnLeaseEntity result = itfnLeaseService.regItfnLease(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ItfnLeaseEntity>> modItfnLease(
        @RequestBody ItfnLeaseForm dom
    ){
        ItfnLeaseEntity result = itfnLeaseService.modItfnLease(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<ItfnLeaseEntity>> getItfnLease(
        @RequestBody ItfnLeaseSearch dom
    ){
        ItfnLeaseEntity result = itfnLeaseService.getItfnLease(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<ItfnLeaseEntity>>> getItfnLeaseList(
        @RequestBody ItfnLeaseSearch dom
    ){
        ResultListDto<ItfnLeaseEntity> resultList = itfnLeaseService.getItfnLeaseList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
