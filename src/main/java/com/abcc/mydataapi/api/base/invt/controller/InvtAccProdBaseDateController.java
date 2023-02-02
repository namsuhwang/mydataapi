package com.abcc.mydataapi.api.base.invt.controller;

import com.abcc.mydataapi.api.base.invt.service.InvtAccProdBaseDateService;
import com.abcc.mydataapi.api.base.invt.models.InvtAccProdBaseDateSearch;
import com.abcc.mydataapi.api.base.invt.models.entity.InvtAccProdBaseDateEntity;
import com.abcc.mydataapi.api.base.invt.models.form.InvtAccProdBaseDateForm;
import com.abcc.mydataapi.common.models.dto.ResponseDto;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
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
@RequestMapping(value = "/invtAccProdBaseDate", produces="application/json;charset=UTF-8")
public class InvtAccProdBaseDateController {
    @Autowired
    InvtAccProdBaseDateService invtAccProdBaseDateService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InvtAccProdBaseDateEntity>> regInvtAccProdBaseDate(
        @RequestBody InvtAccProdBaseDateForm dom
    ){
        invtAccProdBaseDateService.regInvtAccProdBaseDate(dom);
        InvtAccProdBaseDateEntity result = invtAccProdBaseDateService.getInvtAccProdBaseDate(new InvtAccProdBaseDateSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InvtAccProdBaseDateEntity>> modInvtAccProdBaseDate(
        @RequestBody InvtAccProdBaseDateForm dom
    ){
        invtAccProdBaseDateService.modInvtAccProdBaseDate(dom);
        InvtAccProdBaseDateEntity result = invtAccProdBaseDateService.getInvtAccProdBaseDate(new InvtAccProdBaseDateSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InvtAccProdBaseDateEntity>> getInvtAccProdBaseDate(
        @RequestBody InvtAccProdBaseDateSearch dom
    ){
        InvtAccProdBaseDateEntity result = invtAccProdBaseDateService.getInvtAccProdBaseDate(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InvtAccProdBaseDateEntity>>> getInvtAccProdBaseDateList(
        @RequestBody InvtAccProdBaseDateSearch dom
    ){
        ResultListDto<InvtAccProdBaseDateEntity> resultList = invtAccProdBaseDateService.getInvtAccProdBaseDateList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
