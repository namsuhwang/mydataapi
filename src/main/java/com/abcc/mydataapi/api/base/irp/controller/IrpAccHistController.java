package com.abcc.mydataapi.api.base.irp.controller;

import com.abcc.mydataapi.api.base.irp.models.IrpAccHistSearch;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.irp.models.entity.IrpAccHistEntity;
import com.abcc.mydataapi.api.base.irp.models.form.IrpAccHistForm;
import com.abcc.mydataapi.api.base.irp.service.IrpAccHistService;
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
@RequestMapping(value = "/irpAccHist", produces="application/json;charset=UTF-8")
public class IrpAccHistController {
    @Autowired
    IrpAccHistService irpAccHistService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<IrpAccHistEntity>> regIrpAccHist(
        @RequestBody IrpAccHistForm dom
    ){
        IrpAccHistEntity result = irpAccHistService.regIrpAccHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<IrpAccHistEntity>> modIrpAccHist(
        @RequestBody IrpAccHistForm dom
    ){
        IrpAccHistEntity result = irpAccHistService.modIrpAccHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<IrpAccHistEntity>> getIrpAccHist(
        @RequestBody IrpAccHistSearch dom
    ){
        IrpAccHistEntity result = irpAccHistService.getIrpAccHist(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<IrpAccHistEntity>>> getIrpAccHistList(
        @RequestBody IrpAccHistSearch dom
    ){
        ResultListDto<IrpAccHistEntity> resultList = irpAccHistService.getIrpAccHistList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
