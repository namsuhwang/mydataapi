package com.kpcnc.mydataapi.api.load.itfn.controller;

import com.kpcnc.mydataapi.api.load.itfn.models.ItfnAccSearch;
import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnAccEntity;
import com.kpcnc.mydataapi.api.load.itfn.models.form.ItfnAccForm;
import com.kpcnc.mydataapi.api.load.itfn.service.ItfnAccService;
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
@RequestMapping(value = "/itfnAcc", produces="application/json;charset=UTF-8")
public class ItfnAccController {
    @Autowired
    ItfnAccService itfnAccService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ItfnAccEntity>> regItfnAcc(
        @RequestBody ItfnAccForm dom
    ){
        ItfnAccEntity result = itfnAccService.regItfnAcc(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ItfnAccEntity>> modItfnAcc(
        @RequestBody ItfnAccForm dom
    ){
        ItfnAccEntity result = itfnAccService.modItfnAcc(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<ItfnAccEntity>> getItfnAcc(
        @RequestBody ItfnAccSearch dom
    ){
        ItfnAccEntity result = itfnAccService.getItfnAcc(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<ItfnAccEntity>>> getItfnAccList(
        @RequestBody ItfnAccSearch dom
    ){
        ResultListDto<ItfnAccEntity> resultList = itfnAccService.getItfnAccList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
