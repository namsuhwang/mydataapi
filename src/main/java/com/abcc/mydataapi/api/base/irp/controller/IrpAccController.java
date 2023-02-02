package com.abcc.mydataapi.api.base.irp.controller;

import com.abcc.mydataapi.api.base.irp.models.IrpAccSearch;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.irp.models.entity.IrpAccEntity;
import com.abcc.mydataapi.api.base.irp.models.form.IrpAccForm;
import com.abcc.mydataapi.api.base.irp.service.IrpAccService;
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
