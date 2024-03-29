package com.albee.mydataapi.api.base.invt.controller;

import com.albee.mydataapi.api.base.invt.models.InvtAccSearch;
import com.albee.mydataapi.api.base.invt.service.InvtAccService;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.invt.models.entity.InvtAccEntity;
import com.albee.mydataapi.api.base.invt.models.form.InvtAccForm;
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
@RequestMapping(value = "/invtAcc", produces="application/json;charset=UTF-8")
public class InvtAccController {
    @Autowired
    InvtAccService invtAccService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InvtAccEntity>> regInvtAcc(
        @RequestBody InvtAccForm dom
    ){
        invtAccService.regInvtAcc(dom);
        InvtAccEntity result = invtAccService.getInvtAcc(new InvtAccSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InvtAccEntity>> modInvtAcc(
        @RequestBody InvtAccForm dom
    ){
        invtAccService.modInvtAcc(dom);
        InvtAccEntity result = invtAccService.getInvtAcc(new InvtAccSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InvtAccEntity>> getInvtAcc(
        @RequestBody InvtAccSearch dom
    ){
        InvtAccEntity result = invtAccService.getInvtAcc(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InvtAccEntity>>> getInvtAccList(
        @RequestBody InvtAccSearch dom
    ){
        ResultListDto<InvtAccEntity> resultList = invtAccService.getInvtAccList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
