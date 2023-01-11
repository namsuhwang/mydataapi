package com.kpcnc.mydataapi.api.common.org.controller;

import com.kpcnc.mydataapi.api.common.org.models.OrgMstSearch;
import com.kpcnc.mydataapi.api.common.org.models.entity.OrgMstEntity;
import com.kpcnc.mydataapi.api.common.org.models.form.OrgMstForm;
import com.kpcnc.mydataapi.api.common.org.service.OrgMstService;
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
@RequestMapping(value = "/orgMst", produces="application/json;charset=UTF-8")
public class OrgMstController {
    @Autowired
    OrgMstService orgMstService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<OrgMstEntity>> regOrgMst(
        @RequestBody OrgMstForm dom
    ){
        OrgMstEntity result = orgMstService.regOrgMst(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<OrgMstEntity>> modOrgMst(
        @RequestBody OrgMstForm dom
    ){
        OrgMstEntity result = orgMstService.modOrgMst(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<OrgMstEntity>> getOrgMst(
        @RequestBody OrgMstSearch dom
    ){
        OrgMstEntity result = orgMstService.getOrgMst(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<OrgMstEntity>>> getOrgMstList(
        @RequestBody OrgMstSearch dom
    ){
        ResultListDto<OrgMstEntity> resultList = orgMstService.getOrgMstList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
