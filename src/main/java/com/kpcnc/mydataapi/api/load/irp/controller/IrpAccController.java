package com.kpcnc.mydataapi.api.load.irp.controller;

import com.kpcnc.mydataapi.api.load.irp.models.IrpAccSearch;
import com.kpcnc.mydataapi.api.load.irp.models.entity.IrpAccEntity;
import com.kpcnc.mydataapi.api.load.irp.models.form.IrpAccForm;
import com.kpcnc.mydataapi.api.load.irp.service.IrpAccService;
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
@RequestMapping(value = "/irpAcc", produces="application/json;charset=UTF-8")
public class IrpAccController {
    @Autowired
    IrpAccService irpAccService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<IrpAccEntity>> regIrpAcc(
        @RequestBody IrpAccForm dom
    ){
        IrpAccEntity result = irpAccService.regIrpAcc(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<IrpAccEntity>> modIrpAcc(
        @RequestBody IrpAccForm dom
    ){
        IrpAccEntity result = irpAccService.modIrpAcc(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<IrpAccEntity>> getIrpAcc(
        @RequestBody IrpAccSearch dom
    ){
        IrpAccEntity result = irpAccService.getIrpAcc(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<IrpAccEntity>>> getIrpAccList(
        @RequestBody IrpAccSearch dom
    ){
        ResultListDto<IrpAccEntity> resultList = irpAccService.getIrpAccList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
