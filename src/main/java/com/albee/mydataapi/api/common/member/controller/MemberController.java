package com.albee.mydataapi.api.common.member.controller;


import com.albee.mydataapi.api.common.member.service.MemberService;
import com.albee.mydataapi.common.models.dto.ResponseDto;
import com.albee.mydataapi.api.common.member.models.member.MemberSearch;
import com.albee.mydataapi.api.common.member.models.member.entity.MemberEntity;
import com.albee.mydataapi.api.common.member.models.member.form.MemberForm;
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
    public ResponseEntity<ResponseDto<MemberEntity>> regMember(
            @RequestBody MemberForm dom
    ){
        log.info("call : /member/reg");
        log.info("params : " + dom.toString());
        MemberEntity result = memberService.regMember(dom);

        log.info("member reg result : " + result.toString());

        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/mod")
    public ResponseEntity<ResponseDto<MemberEntity>> modMember(
            @RequestBody MemberForm dom
    ){
        log.info("call : /member/mod");
        log.info("params : " + dom.toString());
        MemberEntity result = memberService.modMember(dom);

        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }



    @PostMapping("")
    public ResponseEntity<ResponseDto<MemberEntity>> getMember(
            @RequestBody MemberSearch dom
    ){
        log.info("call : /member");
        log.info("params : " + dom.toString());
        MemberEntity result = memberService.getMember(new MemberSearch(dom.getMemberId()));
        log.info("result : " + result.toString());

        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", result));
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDto<ResultListDto<MemberEntity>>> getMemberList(
            @RequestBody MemberSearch dom
    ){
        log.info("call : /member/list");
        log.info("params : " + dom.toString());
        ResultListDto<MemberEntity> resultList = memberService.getMemberList(dom);
        log.info("result : " + resultList.toString());

        return ResponseEntity.ok().body(new ResponseDto<>("0000", "SUCCESS", resultList));
    }


}
