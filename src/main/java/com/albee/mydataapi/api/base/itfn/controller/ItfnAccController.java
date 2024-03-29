package com.albee.mydataapi.api.base.itfn.controller;

import com.albee.mydataapi.api.base.itfn.models.entity.ItfnAccEntity;
import com.albee.mydataapi.api.base.itfn.models.form.ItfnAccForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.itfn.models.ItfnAccSearch;
import com.albee.mydataapi.api.base.itfn.service.ItfnAccService;
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
@RequestMapping(value = "/itfnAcc", produces="application/json;charset=UTF-8")
public class ItfnAccController {
    @Autowired
    ItfnAccService itfnAccService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ItfnAccEntity>> regItfnAcc(
        @RequestBody ItfnAccForm dom
    ){
        itfnAccService.regItfnAcc(dom);
        ItfnAccEntity result = itfnAccService.getItfnAcc(new ItfnAccSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ItfnAccEntity>> modItfnAcc(
        @RequestBody ItfnAccForm dom
    ){
        itfnAccService.modItfnAcc(dom);
        ItfnAccEntity result = itfnAccService.getItfnAcc(new ItfnAccSearch(dom));
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
