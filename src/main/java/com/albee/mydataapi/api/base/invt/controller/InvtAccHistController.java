package com.albee.mydataapi.api.base.invt.controller;

import com.albee.mydataapi.api.base.invt.models.InvtAccHistSearch;
import com.albee.mydataapi.api.base.invt.service.InvtAccHistService;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.invt.models.entity.InvtAccHistEntity;
import com.albee.mydataapi.api.base.invt.models.form.InvtAccHistForm;
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
@RequestMapping(value = "/invtAccHist", produces="application/json;charset=UTF-8")
public class InvtAccHistController {
    @Autowired
    InvtAccHistService invtAccHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InvtAccHistEntity>> regInvtAccHist(
        @RequestBody InvtAccHistForm dom
    ){
        invtAccHistService.regInvtAccHist(dom);
        InvtAccHistEntity result = invtAccHistService.getInvtAccHist(new InvtAccHistSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InvtAccHistEntity>> modInvtAccHist(
        @RequestBody InvtAccHistForm dom
    ){
        invtAccHistService.modInvtAccHist(dom);
        InvtAccHistEntity result = invtAccHistService.getInvtAccHist(new InvtAccHistSearch(dom));
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
