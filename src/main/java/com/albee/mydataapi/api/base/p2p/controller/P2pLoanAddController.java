package com.albee.mydataapi.api.base.p2p.controller;

import com.albee.mydataapi.api.base.p2p.models.entity.P2pLoanAddEntity;
import com.albee.mydataapi.api.base.p2p.models.form.P2pLoanAddForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.p2p.models.P2pLoanAddSearch;
import com.albee.mydataapi.api.base.p2p.service.P2pLoanAddService;
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
@RequestMapping(value = "/p2pLoanAdd", produces="application/json;charset=UTF-8")
public class P2pLoanAddController {
    @Autowired
    P2pLoanAddService p2pLoanAddService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<P2pLoanAddEntity>> regP2pLoanAdd(
        @RequestBody P2pLoanAddForm dom
    ){
        P2pLoanAddEntity result = p2pLoanAddService.regP2pLoanAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<P2pLoanAddEntity>> modP2pLoanAdd(
        @RequestBody P2pLoanAddForm dom
    ){
        P2pLoanAddEntity result = p2pLoanAddService.modP2pLoanAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<P2pLoanAddEntity>> getP2pLoanAdd(
        @RequestBody P2pLoanAddSearch dom
    ){
        P2pLoanAddEntity result = p2pLoanAddService.getP2pLoanAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<P2pLoanAddEntity>>> getP2pLoanAddList(
        @RequestBody P2pLoanAddSearch dom
    ){
        ResultListDto<P2pLoanAddEntity> resultList = p2pLoanAddService.getP2pLoanAddList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
