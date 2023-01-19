package com.kpcnc.mydataapi.api.common.recv.controller;

import com.kpcnc.mydataapi.api.common.recv.models.RecvStatusSearch;
import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvStatusEntity;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvStatusForm;
import com.kpcnc.mydataapi.api.common.recv.service.RecvStatusService;
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
@RequestMapping(value = "/recvStatus", produces="application/json;charset=UTF-8")
public class RecvStatusController {
    @Autowired
    RecvStatusService recvStatusService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<RecvStatusEntity>> regRecvStatus(
        @RequestBody RecvStatusForm dom
    ){
        recvStatusService.regRecvStatus(dom);
        RecvStatusEntity result = recvStatusService.getRecvStatus(new RecvStatusSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<RecvStatusEntity>> modRecvStatus(
        @RequestBody RecvStatusForm dom
    ){
        recvStatusService.modRecvStatus(dom);
        RecvStatusEntity result = recvStatusService.getRecvStatus(new RecvStatusSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<RecvStatusEntity>> getRecvStatus(
        @RequestBody RecvStatusSearch dom
    ){
        RecvStatusEntity result = recvStatusService.getRecvStatus(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<RecvStatusEntity>>> getRecvStatusList(
        @RequestBody RecvStatusSearch dom
    ){
        ResultListDto<RecvStatusEntity> resultList = recvStatusService.getRecvStatusList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
