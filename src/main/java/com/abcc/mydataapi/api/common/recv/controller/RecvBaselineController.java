package com.abcc.mydataapi.api.common.recv.controller;

import com.abcc.mydataapi.api.common.recv.models.RecvBaselineSearch;
import com.abcc.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import com.abcc.mydataapi.api.common.recv.models.form.RecvBaselineForm;
import com.abcc.mydataapi.api.common.recv.service.RecvBaselineService;
import com.abcc.mydataapi.common.models.dto.ResponseDto;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@RestController
@EnableWebMvc
@RequiredArgsConstructor
@RequestMapping(value = "/recvBaseline", produces="application/json;charset=UTF-8")
public class RecvBaselineController {
    @Autowired
    RecvBaselineService recvBaselineService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<RecvBaselineEntity>> regRecvBaseline(
        @RequestBody RecvBaselineForm dom
    ){
        recvBaselineService.regRecvBaseline(dom);
        RecvBaselineEntity result = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<RecvBaselineEntity>> modRecvBaseline(
        @RequestBody RecvBaselineForm dom
    ){
        recvBaselineService.modRecvBaseline(dom);
        RecvBaselineEntity result = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<RecvBaselineEntity>> getRecvBaseline(
        @RequestBody RecvBaselineSearch dom
    ){
        RecvBaselineEntity result = recvBaselineService.getRecvBaseline(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<RecvBaselineEntity>>> getRecvBaselineList(
        @RequestBody RecvBaselineSearch dom
    ){
        ResultListDto<RecvBaselineEntity> resultList = recvBaselineService.getRecvBaselineList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
