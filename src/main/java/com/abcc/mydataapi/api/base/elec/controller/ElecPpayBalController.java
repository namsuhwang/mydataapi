package com.abcc.mydataapi.api.base.elec.controller;

import com.abcc.mydataapi.api.base.elec.models.entity.ElecPpayBalEntity;
import com.abcc.mydataapi.api.base.elec.models.form.ElecPpayBalForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.elec.models.ElecPpayBalSearch;
import com.abcc.mydataapi.api.base.elec.service.ElecPpayBalService;
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
@RequestMapping(value = "/elecPpayBal", produces="application/json;charset=UTF-8")
public class ElecPpayBalController {
    @Autowired
    ElecPpayBalService elecPpayBalService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ElecPpayBalEntity>> regElecPpayBal(
        @RequestBody ElecPpayBalForm dom
    ){
        ElecPpayBalEntity result = elecPpayBalService.regElecPpayBal(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ElecPpayBalEntity>> modElecPpayBal(
        @RequestBody ElecPpayBalForm dom
    ){
        ElecPpayBalEntity result = elecPpayBalService.modElecPpayBal(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<ElecPpayBalEntity>> getElecPpayBal(
        @RequestBody ElecPpayBalSearch dom
    ){
        ElecPpayBalEntity result = elecPpayBalService.getElecPpayBal(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<ElecPpayBalEntity>>> getElecPpayBalList(
        @RequestBody ElecPpayBalSearch dom
    ){
        ResultListDto<ElecPpayBalEntity> resultList = elecPpayBalService.getElecPpayBalList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
