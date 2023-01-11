package com.kpcnc.mydataapi.api.common.api.controller;

import com.kpcnc.mydataapi.api.common.api.models.ApiMstSearch;
import com.kpcnc.mydataapi.api.common.api.models.entity.ApiMstEntity;
import com.kpcnc.mydataapi.api.common.api.models.form.ApiMstForm;
import com.kpcnc.mydataapi.api.common.api.service.ApiMstService;
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
@RequestMapping(value = "/apiMst", produces="application/json;charset=UTF-8")
public class ApiMstController {
    @Autowired
    ApiMstService apiMstService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<ApiMstEntity>> regApiMst(
        @RequestBody ApiMstForm dom
    ){
        ApiMstEntity result = apiMstService.regApiMst(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<ApiMstEntity>> modApiMst(
        @RequestBody ApiMstForm dom
    ){
        ApiMstEntity result = apiMstService.modApiMst(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<ApiMstEntity>> getApiMst(
        @RequestBody ApiMstSearch dom
    ){
        ApiMstEntity result = apiMstService.getApiMst(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<ApiMstEntity>>> getApiMstList(
        @RequestBody ApiMstSearch dom
    ){
        ResultListDto<ApiMstEntity> resultList = apiMstService.getApiMstList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
