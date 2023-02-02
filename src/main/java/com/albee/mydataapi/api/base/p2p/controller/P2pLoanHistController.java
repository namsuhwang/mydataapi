package com.albee.mydataapi.api.base.p2p.controller;

import com.albee.mydataapi.api.base.p2p.models.entity.P2pLoanHistEntity;
import com.albee.mydataapi.api.base.p2p.models.form.P2pLoanHistForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.p2p.models.P2pLoanHistSearch;
import com.albee.mydataapi.api.base.p2p.service.P2pLoanHistService;
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
@RequestMapping(value = "/p2pLoanHist", produces="application/json;charset=UTF-8")
public class P2pLoanHistController {
    @Autowired
    P2pLoanHistService p2pLoanHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<P2pLoanHistEntity>> regP2pLoanHist(
        @RequestBody P2pLoanHistForm dom
    ){
        P2pLoanHistEntity result = p2pLoanHistService.regP2pLoanHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<P2pLoanHistEntity>> modP2pLoanHist(
        @RequestBody P2pLoanHistForm dom
    ){
        P2pLoanHistEntity result = p2pLoanHistService.modP2pLoanHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<P2pLoanHistEntity>> getP2pLoanHist(
        @RequestBody P2pLoanHistSearch dom
    ){
        P2pLoanHistEntity result = p2pLoanHistService.getP2pLoanHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<P2pLoanHistEntity>>> getP2pLoanHistList(
        @RequestBody P2pLoanHistSearch dom
    ){
        ResultListDto<P2pLoanHistEntity> resultList = p2pLoanHistService.getP2pLoanHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
