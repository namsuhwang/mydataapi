package com.kpcnc.mydataapi.api.load.invt.controller;

import com.kpcnc.mydataapi.api.load.invt.models.InvtAccHistSearch;
import com.kpcnc.mydataapi.api.load.invt.models.entity.InvtAccHistEntity;
import com.kpcnc.mydataapi.api.load.invt.models.form.InvtAccHistForm;
import com.kpcnc.mydataapi.api.load.invt.service.InvtAccHistService;
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
@RequestMapping(value = "/invtAccHist", produces="application/json;charset=UTF-8")
public class InvtAccHistController {
    @Autowired
    InvtAccHistService invtAccHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InvtAccHistEntity>> regInvtAccHist(
        @RequestBody InvtAccHistForm dom
    ){
        InvtAccHistEntity result = invtAccHistService.regInvtAccHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InvtAccHistEntity>> modInvtAccHist(
        @RequestBody InvtAccHistForm dom
    ){
        InvtAccHistEntity result = invtAccHistService.modInvtAccHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InvtAccHistEntity>> getInvtAccHist(
        @RequestBody InvtAccHistSearch dom
    ){
        InvtAccHistEntity result = invtAccHistService.getInvtAccHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InvtAccHistEntity>>> getInvtAccHistList(
        @RequestBody InvtAccHistSearch dom
    ){
        ResultListDto<InvtAccHistEntity> resultList = invtAccHistService.getInvtAccHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}