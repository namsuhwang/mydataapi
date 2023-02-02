package com.abcc.mydataapi.api.base.invt.controller;

import com.abcc.mydataapi.api.base.invt.models.InvtAutoTransSearch;
import com.abcc.mydataapi.api.base.invt.service.InvtAutoTransService;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.invt.models.entity.InvtAutoTransEntity;
import com.abcc.mydataapi.api.base.invt.models.form.InvtAutoTransForm;
import com.abcc.mydataapi.common.models.dto.ResponseDto;
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
@RequestMapping(value = "/invtAutoTrans", produces="application/json;charset=UTF-8")
public class InvtAutoTransController {
    @Autowired
    InvtAutoTransService invtAutoTransService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InvtAutoTransEntity>> regInvtAutoTrans(
        @RequestBody InvtAutoTransForm dom
    ){
        invtAutoTransService.regInvtAutoTrans(dom);
        InvtAutoTransEntity result = invtAutoTransService.getInvtAutoTrans(new InvtAutoTransSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InvtAutoTransEntity>> modInvtAutoTrans(
        @RequestBody InvtAutoTransForm dom
    ){
        invtAutoTransService.modInvtAutoTrans(dom);
        InvtAutoTransEntity result = invtAutoTransService.getInvtAutoTrans(new InvtAutoTransSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InvtAutoTransEntity>> getInvtAutoTrans(
        @RequestBody InvtAutoTransSearch dom
    ){
        InvtAutoTransEntity result = invtAutoTransService.getInvtAutoTrans(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InvtAutoTransEntity>>> getInvtAutoTransList(
        @RequestBody InvtAutoTransSearch dom
    ){
        ResultListDto<InvtAutoTransEntity> resultList = invtAutoTransService.getInvtAutoTransList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
