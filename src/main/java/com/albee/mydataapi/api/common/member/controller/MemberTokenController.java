package com.albee.mydataapi.api.common.member.controller;

import com.albee.mydataapi.api.common.member.service.MemberTokenService;
import com.albee.mydataapi.api.common.member.models.member.MemberTokenSearch;
import com.albee.mydataapi.api.common.member.models.member.entity.MemberTokenEntity;
import com.albee.mydataapi.api.common.member.models.member.form.MemberTokenForm;
import com.albee.mydataapi.common.models.dto.ResponseDto;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@RestController
@EnableWebMvc
@RequiredArgsConstructor
@RequestMapping(value = "/memberToken", produces="application/json;charset=UTF-8")
public class MemberTokenController {
    @Autowired
    MemberTokenService memberTokenService;

    @PostMapping("/reg")
    public ResponseEntity<ResponseDto<MemberTokenEntity>> regMemberToken(
        @RequestBody MemberTokenForm dom
    ){
        memberTokenService.regMemberToken(dom);
        MemberTokenEntity result = memberTokenService.getMemberToken(new MemberTokenSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<MemberTokenEntity>> modMemberToken(
        @RequestBody MemberTokenForm dom
    ){
        memberTokenService.modMemberToken(dom);
        MemberTokenEntity result = memberTokenService.getMemberToken(new MemberTokenSearch(dom));
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto<MemberTokenEntity>> getMemberToken(
        @RequestBody MemberTokenSearch dom
    ){
        MemberTokenEntity result = memberTokenService.getMemberToken(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<MemberTokenEntity>>> getMemberTokenList(
        @RequestBody MemberTokenSearch dom
    ){
        ResultListDto<MemberTokenEntity> resultList = memberTokenService.getMemberTokenList(dom);
        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }

}
