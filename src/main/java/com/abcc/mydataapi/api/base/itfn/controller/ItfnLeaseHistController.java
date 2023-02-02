package com.abcc.mydataapi.api.base.itfn.controller;

import com.abcc.mydataapi.api.base.itfn.models.entity.ItfnLeaseHistEntity;
import com.abcc.mydataapi.api.base.itfn.models.form.ItfnLeaseHistForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.itfn.models.ItfnLeaseHistSearch;
import com.abcc.mydataapi.api.base.itfn.service.ItfnLeaseHistService;
import com.abcc.mydataapi.common.models.dto.ResponseDto;
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
@RequestMapping(value = "/itfnLeaseHist", produces="application/json;charset=UTF-8")
public class ItfnLeaseHistController {
    @Autowired
    ItfnLeaseHistService itfnLeaseHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ItfnLeaseHistEntity>> regItfnLeaseHist(
        @RequestBody ItfnLeaseHistForm dom
    ){
        itfnLeaseHistService.regItfnLeaseHist(dom);
        ItfnLeaseHistEntity result = itfnLeaseHistService.getItfnLeaseHist(new ItfnLeaseHistSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ItfnLeaseHistEntity>> modItfnLeaseHist(
        @RequestBody ItfnLeaseHistForm dom
    ){
        itfnLeaseHistService.modItfnLeaseHist(dom);
        ItfnLeaseHistEntity result = itfnLeaseHistService.getItfnLeaseHist(new ItfnLeaseHistSearch(dom));
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
