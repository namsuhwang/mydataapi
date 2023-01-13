package com.kpcnc.mydataapi.api.load.invt.controller;

import com.kpcnc.mydataapi.api.load.invt.models.InvtAccBaseSearch;
import com.kpcnc.mydataapi.api.load.invt.models.entity.InvtAccBaseEntity;
import com.kpcnc.mydataapi.api.load.invt.models.form.InvtAccBaseForm;
import com.kpcnc.mydataapi.api.load.invt.service.InvtAccBaseService;
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
@RequestMapping(value = "/invtAccBase", produces="application/json;charset=UTF-8")
public class InvtAccBaseController {
    @Autowired
    InvtAccBaseService invtAccBaseService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InvtAccBaseEntity>> regInvtAccBase(
        @RequestBody InvtAccBaseForm dom
    ){
        InvtAccBaseEntity result = invtAccBaseService.regInvtAccBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InvtAccBaseEntity>> modInvtAccBase(
        @RequestBody InvtAccBaseForm dom
    ){
        InvtAccBaseEntity result = invtAccBaseService.modInvtAccBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InvtAccBaseEntity>> getInvtAccBase(
        @RequestBody InvtAccBaseSearch dom
    ){
        InvtAccBaseEntity result = invtAccBaseService.getInvtAccBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InvtAccBaseEntity>>> getInvtAccBaseList(
        @RequestBody InvtAccBaseSearch dom
    ){
        ResultListDto<InvtAccBaseEntity> resultList = invtAccBaseService.getInvtAccBaseList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
