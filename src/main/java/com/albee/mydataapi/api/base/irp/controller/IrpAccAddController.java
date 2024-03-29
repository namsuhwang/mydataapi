package com.albee.mydataapi.api.base.irp.controller;

import com.albee.mydataapi.api.base.irp.models.IrpAccAddSearch;
import com.albee.mydataapi.api.base.irp.models.form.IrpAccAddForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.irp.models.entity.IrpAccAddEntity;
import com.albee.mydataapi.api.base.irp.service.IrpAccAddService;
import com.albee.mydataapi.common.models.dto.ResponseDto;
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
@RequestMapping(value = "/irpAccAdd", produces="application/json;charset=UTF-8")
public class IrpAccAddController {
    @Autowired
    IrpAccAddService irpAccAddService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<IrpAccAddEntity>> regIrpAccAdd(
        @RequestBody IrpAccAddForm dom
    ){
        irpAccAddService.regIrpAccAdd(dom);
        IrpAccAddEntity result = irpAccAddService.getIrpAccAddLast(new IrpAccAddSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<IrpAccAddEntity>> modIrpAccAdd(
        @RequestBody IrpAccAddForm dom
    ){
        irpAccAddService.modIrpAccAdd(dom);
        IrpAccAddEntity result = irpAccAddService.getIrpAccAddLast(new IrpAccAddSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<IrpAccAddEntity>> getIrpAccAdd(
        @RequestBody IrpAccAddSearch dom
    ){
        IrpAccAddEntity result = irpAccAddService.getIrpAccAdd(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<IrpAccAddEntity>>> getIrpAccAddList(
        @RequestBody IrpAccAddSearch dom
    ){
        ResultListDto<IrpAccAddEntity> resultList = irpAccAddService.getIrpAccAddList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
