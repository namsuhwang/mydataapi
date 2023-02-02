package com.albee.mydataapi.api.base.p2p.controller;

import com.albee.mydataapi.api.base.p2p.models.entity.P2pLoanBaseEntity;
import com.albee.mydataapi.api.base.p2p.models.form.P2pLoanBaseForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.p2p.models.P2pLoanBaseSearch;
import com.albee.mydataapi.api.base.p2p.service.P2pLoanBaseService;
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
@RequestMapping(value = "/p2pLoanBase", produces="application/json;charset=UTF-8")
public class P2pLoanBaseController {
    @Autowired
    P2pLoanBaseService p2pLoanBaseService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<P2pLoanBaseEntity>> regP2pLoanBase(
        @RequestBody P2pLoanBaseForm dom
    ){
        P2pLoanBaseEntity result = p2pLoanBaseService.regP2pLoanBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<P2pLoanBaseEntity>> modP2pLoanBase(
        @RequestBody P2pLoanBaseForm dom
    ){
        P2pLoanBaseEntity result = p2pLoanBaseService.modP2pLoanBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<P2pLoanBaseEntity>> getP2pLoanBase(
        @RequestBody P2pLoanBaseSearch dom
    ){
        P2pLoanBaseEntity result = p2pLoanBaseService.getP2pLoanBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<P2pLoanBaseEntity>>> getP2pLoanBaseList(
        @RequestBody P2pLoanBaseSearch dom
    ){
        ResultListDto<P2pLoanBaseEntity> resultList = p2pLoanBaseService.getP2pLoanBaseList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
