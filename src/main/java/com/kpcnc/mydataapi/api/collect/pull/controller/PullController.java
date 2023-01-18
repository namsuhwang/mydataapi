package com.kpcnc.mydataapi.api.collect.pull.controller;

import com.kpcnc.mydataapi.api.base.bond.models.BondBalSearch;
import com.kpcnc.mydataapi.api.base.bond.models.entity.BondBalEntity;
import com.kpcnc.mydataapi.api.base.bond.models.form.BondBalForm;
import com.kpcnc.mydataapi.api.base.bond.service.BondBalService;
import com.kpcnc.mydataapi.api.collect.pull.models.form.PullForm;
import com.kpcnc.mydataapi.api.collect.pull.service.PullService;
import com.kpcnc.mydataapi.common.models.dto.ResponseDto;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Slf4j
@RestController
@EnableWebMvc
@RequiredArgsConstructor
@RequestMapping(value = "/pull", produces="application/json;charset=UTF-8")
public class PullController {
    @Autowired
    PullService pullService;

    @PostMapping("")
    public ResponseEntity<ResponseDto<List<String>>> pullPersonalCredit(
        @RequestBody PullForm dom
    ){
        List<String> pullTargetList = pullService.execPullPersonalInfoRun(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", pullTargetList));
    }
}
