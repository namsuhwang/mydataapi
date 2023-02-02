package com.albee.mydataapi.api.base.db.controller;

import com.albee.mydataapi.api.base.db.models.DbSearch;
import com.albee.mydataapi.api.base.db.models.entity.DbEntity;
import com.albee.mydataapi.api.base.db.models.form.DbForm;
import com.albee.mydataapi.api.base.db.service.DbService;
import com.albee.mydataapi.common.models.dto.ResponseDto;
import com.albee.mydataapi.common.models.dto.ResultListDto;
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
@RequestMapping(value = "/db", produces="application/json;charset=UTF-8")
public class DbController {
    @Autowired
    DbService dbService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<DbEntity>> regDb(
        @RequestBody DbForm dom
    ){
        DbEntity result = dbService.regDb(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<DbEntity>> modDb(
        @RequestBody DbForm dom
    ){
        DbEntity result = dbService.modDb(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<DbEntity>> getDb(
        @RequestBody DbSearch dom
    ){
        DbEntity result = dbService.getDb(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<DbEntity>>> getDbList(
        @RequestBody DbSearch dom
    ){
        ResultListDto<DbEntity> resultList = dbService.getDbList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
