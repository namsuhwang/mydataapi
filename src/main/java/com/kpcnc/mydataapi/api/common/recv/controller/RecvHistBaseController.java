package com.kpcnc.mydataapi.api.common.recv.controller;

import com.kpcnc.mydataapi.api.common.recv.models.RecvHistBaseSearch;
import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvHistBaseEntity;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvHistBaseForm;
import com.kpcnc.mydataapi.api.common.recv.service.RecvHistBaseService;
import com.kpcnc.mydataapi.common.models.dto.ResponseDto;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Slf4j
@RestController
@EnableWebMvc
@RequiredArgsConstructor
@RequestMapping(value = "/recvHistBase", produces="application/json;charset=UTF-8")
public class RecvHistBaseController {
    @Autowired
    RecvHistBaseService recvHistBaseService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<RecvHistBaseEntity>> regRecvHistBase(
        @RequestBody RecvHistBaseForm dom
    ){
        recvHistBaseService.regRecvHistBase(dom);
        RecvHistBaseEntity result = recvHistBaseService.getRecvHistBase(new RecvHistBaseSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<RecvHistBaseEntity>> modRecvHistBase(
        @RequestBody RecvHistBaseForm dom
    ){
        recvHistBaseService.modRecvHistBase(dom);
        RecvHistBaseEntity result = recvHistBaseService.getRecvHistBase(new RecvHistBaseSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<RecvHistBaseEntity>> getRecvHistBase(
        @RequestBody RecvHistBaseSearch dom
    ){
        RecvHistBaseEntity result = recvHistBaseService.getRecvHistBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<RecvHistBaseEntity>>> getRecvHistBaseList(
        @RequestBody RecvHistBaseSearch dom
    ){
        ResultListDto<RecvHistBaseEntity> resultList = recvHistBaseService.getRecvHistBaseList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
