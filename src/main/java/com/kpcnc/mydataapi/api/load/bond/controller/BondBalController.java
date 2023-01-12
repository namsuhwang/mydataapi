package com.kpcnc.mydataapi.api.load.bond.controller;

import com.kpcnc.mydataapi.api.load.bond.models.BondBalSearch;
import com.kpcnc.mydataapi.api.load.bond.models.entity.BondBalEntity;
import com.kpcnc.mydataapi.api.load.bond.models.form.BondBalForm;
import com.kpcnc.mydataapi.api.load.bond.service.BondBalService;
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
@RequestMapping(value = "/bondBal", produces="application/json;charset=UTF-8")
public class BondBalController {
    @Autowired
    BondBalService bondBalService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BondBalEntity>> regBondBal(
        @RequestBody BondBalForm dom
    ){
        BondBalEntity result = bondBalService.regBondBal(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BondBalEntity>> modBondBal(
        @RequestBody BondBalForm dom
    ){
        BondBalEntity result = bondBalService.modBondBal(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BondBalEntity>> getBondBal(
        @RequestBody BondBalSearch dom
    ){
        BondBalEntity result = bondBalService.getBondBal(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BondBalEntity>>> getBondBalList(
        @RequestBody BondBalSearch dom
    ){
        ResultListDto<BondBalEntity> resultList = bondBalService.getBondBalList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
