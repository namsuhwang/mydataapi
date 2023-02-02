package com.abcc.mydataapi.api.base.dc.controller;

import com.abcc.mydataapi.api.base.dc.models.entity.DcBaseEntity;
import com.abcc.mydataapi.api.base.dc.models.form.DcBaseForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.dc.models.DcBaseSearch;
import com.abcc.mydataapi.api.base.dc.service.DcBaseService;
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
@RequestMapping(value = "/dcBase", produces="application/json;charset=UTF-8")
public class DcBaseController {
    @Autowired
    DcBaseService dcBaseService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<DcBaseEntity>> regDcBase(
        @RequestBody DcBaseForm dom
    ){
        DcBaseEntity result = dcBaseService.regDcBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<DcBaseEntity>> modDcBase(
        @RequestBody DcBaseForm dom
    ){
        DcBaseEntity result = dcBaseService.modDcBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<DcBaseEntity>> getDcBase(
        @RequestBody DcBaseSearch dom
    ){
        DcBaseEntity result = dcBaseService.getDcBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<DcBaseEntity>>> getDcBaseList(
        @RequestBody DcBaseSearch dom
    ){
        ResultListDto<DcBaseEntity> resultList = dcBaseService.getDcBaseList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
