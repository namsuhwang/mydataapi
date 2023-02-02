package com.abcc.mydataapi.api.base.irp.controller;

import com.abcc.mydataapi.api.base.irp.models.IrpAccBaseSearch;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.irp.models.entity.IrpAccBaseEntity;
import com.abcc.mydataapi.api.base.irp.models.form.IrpAccBaseForm;
import com.abcc.mydataapi.api.base.irp.service.IrpAccBaseService;
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
@RequestMapping(value = "/irpAccBase", produces="application/json;charset=UTF-8")
public class IrpAccBaseController {
    @Autowired
    IrpAccBaseService irpAccBaseService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<IrpAccBaseEntity>> regIrpAccBase(
        @RequestBody IrpAccBaseForm dom
    ){
        IrpAccBaseEntity result = irpAccBaseService.regIrpAccBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<IrpAccBaseEntity>> modIrpAccBase(
        @RequestBody IrpAccBaseForm dom
    ){
        IrpAccBaseEntity result = irpAccBaseService.modIrpAccBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<IrpAccBaseEntity>> getIrpAccBase(
        @RequestBody IrpAccBaseSearch dom
    ){
        IrpAccBaseEntity result = irpAccBaseService.getIrpAccBase(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<IrpAccBaseEntity>>> getIrpAccBaseList(
        @RequestBody IrpAccBaseSearch dom
    ){
        ResultListDto<IrpAccBaseEntity> resultList = irpAccBaseService.getIrpAccBaseList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
