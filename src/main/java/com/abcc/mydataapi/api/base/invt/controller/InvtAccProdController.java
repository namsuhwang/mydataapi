package com.abcc.mydataapi.api.base.invt.controller;

import com.abcc.mydataapi.api.base.invt.models.entity.InvtAccProdEntity;
import com.abcc.mydataapi.api.base.invt.models.form.InvtAccProdForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.invt.models.InvtAccProdSearch;
import com.abcc.mydataapi.api.base.invt.service.InvtAccProdService;
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
@RequestMapping(value = "/invtAccProd", produces="application/json;charset=UTF-8")
public class InvtAccProdController {
    @Autowired
    InvtAccProdService invtAccProdService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<InvtAccProdEntity>> regInvtAccProd(
        @RequestBody InvtAccProdForm dom
    ){
        invtAccProdService.regInvtAccProd(dom);
        InvtAccProdEntity result = invtAccProdService.getInvtAccProd(new InvtAccProdSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<InvtAccProdEntity>> modInvtAccProd(
        @RequestBody InvtAccProdForm dom
    ){
        invtAccProdService.modInvtAccProd(dom);
        InvtAccProdEntity result = invtAccProdService.getInvtAccProd(new InvtAccProdSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<InvtAccProdEntity>> getInvtAccProd(
        @RequestBody InvtAccProdSearch dom
    ){
        InvtAccProdEntity result = invtAccProdService.getInvtAccProd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<InvtAccProdEntity>>> getInvtAccProdList(
        @RequestBody InvtAccProdSearch dom
    ){
        ResultListDto<InvtAccProdEntity> resultList = invtAccProdService.getInvtAccProdList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
