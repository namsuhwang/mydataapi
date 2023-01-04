package com.kpcnc.mydataapi.controller;


import com.kpcnc.mydataapi.models.member.MemberSearch;
import com.kpcnc.mydataapi.models.member.entity.MemberEntity;
import com.kpcnc.mydataapi.models.member.form.MemberForm;
import com.kpcnc.mydataapi.service.MemberService;
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
import java.util.Map;

//@Api(tags = "[ 나의 자산 ]")
@Slf4j
@RestController
@EnableWebMvc
@RequiredArgsConstructor
@RequestMapping(value = "/member", produces="application/json;charset=UTF-8")
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("/reg")
    public ResponseEntity<MemberEntity> regMember(
            @RequestBody MemberForm dom
    ){
        log.info("call : /member/reg");
        log.info("params : " + dom.toString());
        MemberEntity result = memberService.regMember(dom);

        log.info("member reg result : " + result.toString());


        return ResponseEntity.ok()
                .body(result);
    }

    @PostMapping("/mod")
    public ResponseEntity<MemberEntity> modMember(
            @RequestBody MemberForm dom
    ){
        log.info("call : /member/mod");
        log.info("params : " + dom.toString());
        MemberEntity result = memberService.modMember(dom);

        return ResponseEntity.ok().body(result);
    }



    @PostMapping("")
    public ResponseEntity<MemberEntity> getMember(
            @RequestBody MemberSearch dom
    ){
        log.info("call : /member");
        log.info("params : " + dom.toString());
        MemberEntity result = memberService.getMember(dom.getMemberId());
        log.info("result : " + result.toString());

        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/list")
    public ResponseEntity<List<MemberEntity>> getMemberList(
            @RequestBody MemberSearch dom
    ){
        log.info("call : /member/list");
        log.info("params : " + dom.toString());
        List<MemberEntity> result = memberService.getMemberList(dom);
        log.info("result : " + result.toString());

        return ResponseEntity.ok().body(result);
    }


}
