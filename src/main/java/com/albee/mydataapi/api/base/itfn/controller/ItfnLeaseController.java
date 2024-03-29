package com.albee.mydataapi.api.base.itfn.controller;

import com.albee.mydataapi.api.base.itfn.models.entity.ItfnLeaseEntity;
import com.albee.mydataapi.api.base.itfn.models.form.ItfnLeaseForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.itfn.models.ItfnLeaseSearch;
import com.albee.mydataapi.api.base.itfn.service.ItfnLeaseService;
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
@RequestMapping(value = "/itfnLease", produces="application/json;charset=UTF-8")
public class ItfnLeaseController {
    @Autowired
    ItfnLeaseService itfnLeaseService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ItfnLeaseEntity>> regItfnLease(
        @RequestBody ItfnLeaseForm dom
    ){
        itfnLeaseService.regItfnLease(dom);
        ItfnLeaseEntity result = itfnLeaseService.getItfnLease(new ItfnLeaseSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ItfnLeaseEntity>> modItfnLease(
        @RequestBody ItfnLeaseForm dom
    ){
        itfnLeaseService.modItfnLease(dom);
        ItfnLeaseEntity result = itfnLeaseService.getItfnLease(new ItfnLeaseSearch(dom));
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
