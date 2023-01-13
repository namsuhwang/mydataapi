package com.kpcnc.mydataapi.api.base.bond.controller;

import com.kpcnc.mydataapi.api.base.bond.models.BondHistSearch;
import com.kpcnc.mydataapi.api.base.bond.models.entity.BondHistEntity;
import com.kpcnc.mydataapi.api.base.bond.models.form.BondHistForm;
import com.kpcnc.mydataapi.api.base.bond.service.BondHistService;
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

@Slf4j
@RestController
@EnableWebMvc
@RequiredArgsConstructor
@RequestMapping(value = "/bondHist", produces="application/json;charset=UTF-8")
public class BondHistController {
    @Autowired
    BondHistService bondHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BondHistEntity>> regBondHist(
        @RequestBody BondHistForm dom
    ){
        BondHistEntity result = bondHistService.regBondHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BondHistEntity>> modBondHist(
        @RequestBody BondHistForm dom
    ){
        BondHistEntity result = bondHistService.modBondHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BondHistEntity>> getBondHist(
        @RequestBody BondHistSearch dom
    ){
        BondHistEntity result = bondHistService.getBondHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BondHistEntity>>> getBondHistList(
        @RequestBody BondHistSearch dom
    ){
        ResultListDto<BondHistEntity> resultList = bondHistService.getBondHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
