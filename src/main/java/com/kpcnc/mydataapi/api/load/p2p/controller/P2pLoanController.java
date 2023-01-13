package com.kpcnc.mydataapi.api.load.p2p.controller;

import com.kpcnc.mydataapi.api.load.p2p.models.P2pLoanSearch;
import com.kpcnc.mydataapi.api.load.p2p.models.entity.P2pLoanEntity;
import com.kpcnc.mydataapi.api.load.p2p.models.form.P2pLoanForm;
import com.kpcnc.mydataapi.api.load.p2p.service.P2pLoanService;
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
@RequestMapping(value = "/p2pLoan", produces="application/json;charset=UTF-8")
public class P2pLoanController {
    @Autowired
    P2pLoanService p2pLoanService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<P2pLoanEntity>> regP2pLoan(
        @RequestBody P2pLoanForm dom
    ){
        P2pLoanEntity result = p2pLoanService.regP2pLoan(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<P2pLoanEntity>> modP2pLoan(
        @RequestBody P2pLoanForm dom
    ){
        P2pLoanEntity result = p2pLoanService.modP2pLoan(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<P2pLoanEntity>> getP2pLoan(
        @RequestBody P2pLoanSearch dom
    ){
        P2pLoanEntity result = p2pLoanService.getP2pLoan(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<P2pLoanEntity>>> getP2pLoanList(
        @RequestBody P2pLoanSearch dom
    ){
        ResultListDto<P2pLoanEntity> resultList = p2pLoanService.getP2pLoanList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
