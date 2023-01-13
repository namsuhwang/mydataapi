package com.kpcnc.mydataapi.api.load.invt.controller;

import com.kpcnc.mydataapi.api.load.invt.models.InvtPensionAccAddSearch;
import com.kpcnc.mydataapi.api.load.invt.models.entity.InvtPensionAccAddEntity;
import com.kpcnc.mydataapi.api.load.invt.models.form.InvtPensionAccAddForm;
import com.kpcnc.mydataapi.api.load.invt.service.InvtPensionAccAddService;
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
@RequestMapping(value = "/invtPensionAccAdd", produces="application/json;charset=UTF-8")
public class InvtPensionAccAddController {
    @Autowired
    InvtPensionAccAddService invtPensionAccAddService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InvtPensionAccAddEntity>> regInvtPensionAccAdd(
        @RequestBody InvtPensionAccAddForm dom
    ){
        InvtPensionAccAddEntity result = invtPensionAccAddService.regInvtPensionAccAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InvtPensionAccAddEntity>> modInvtPensionAccAdd(
        @RequestBody InvtPensionAccAddForm dom
    ){
        InvtPensionAccAddEntity result = invtPensionAccAddService.modInvtPensionAccAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InvtPensionAccAddEntity>> getInvtPensionAccAdd(
        @RequestBody InvtPensionAccAddSearch dom
    ){
        InvtPensionAccAddEntity result = invtPensionAccAddService.getInvtPensionAccAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InvtPensionAccAddEntity>>> getInvtPensionAccAddList(
        @RequestBody InvtPensionAccAddSearch dom
    ){
        ResultListDto<InvtPensionAccAddEntity> resultList = invtPensionAccAddService.getInvtPensionAccAddList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}