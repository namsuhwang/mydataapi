package com.kpcnc.mydataapi.api.load.bond.controller;

import com.kpcnc.mydataapi.api.load.bond.models.BondSearch;
import com.kpcnc.mydataapi.api.load.bond.models.entity.BondEntity;
import com.kpcnc.mydataapi.api.load.bond.models.form.BondForm;
import com.kpcnc.mydataapi.api.load.bond.service.BondService;
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
@RequestMapping(value = "/bond", produces="application/json;charset=UTF-8")
public class BondController {
    @Autowired
    BondService bondService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<BondEntity>> regBond(
        @RequestBody BondForm dom
    ){
        BondEntity result = bondService.regBond(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<BondEntity>> modBond(
        @RequestBody BondForm dom
    ){
        BondEntity result = bondService.modBond(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<BondEntity>> getBond(
        @RequestBody BondSearch dom
    ){
        BondEntity result = bondService.getBond(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<BondEntity>>> getBondList(
        @RequestBody BondSearch dom
    ){
        ResultListDto<BondEntity> resultList = bondService.getBondList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
