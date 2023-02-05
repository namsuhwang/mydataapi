package com.albee.mydataapi.api.common.trans.service.impl;

import com.albee.mydataapi.api.common.member.models.member.MemberSearch;
import com.albee.mydataapi.api.common.member.models.member.entity.MemberEntity;
import com.albee.mydataapi.api.common.member.service.MemberService;
import com.albee.mydataapi.api.common.trans.models.dto.CustJoinCheck;
import com.albee.mydataapi.api.common.trans.models.dto.TransRequestSpec;
import com.albee.mydataapi.api.common.trans.service.TransRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class TransRequestServiceImpl implements TransRequestService {
    @Autowired
    MemberService memberService;

    /*
        서비스 가입여부 확인
        API ID : 전송요구-001
        API 요청자 : 종합포털
        API 제공자 : 정보수신자, 거점기관
        API명(URI) : /consents/check-join
        설명
            . 정보주체가 사전에 정보수신자의 서비스에 가입했는지 여부를 확인
        처리내용
            . 회원정보 조회 후 회원 가입 여부 응답
     */
    @Override
    public CustJoinCheck transRequest001(CustJoinCheck dom) {
        MemberSearch search = new MemberSearch();
        search.setCi(dom.getUserCi());
        MemberEntity member = memberService.getMember(search);
        dom.setIsJoin(member != null && member.getMemberStatus().equals("01") ? true : false);
        return dom;
    }

    /*
        전송요구서 전송
        API ID : 전송요구-002
        API 요청자 : 종합포털
        API 제공자 : 정보수신자, 거점기관
        API명(URI) : /consents/registry
        설명
            . 정보주체가 전송요구앱을 통해 전송요구한 내역 등을 담은 전송요구서를 정보수신자에게 전송
            . 정보수신자는 전송요구서 정보를 이용하여 정보제공자에게 통합인증을 요청
        처리내용
            . 수신한 전송요구 내용을 테이블(전송요구서)에 저장
     */
    @Override
    public Boolean transRequest002(TransRequestSpec dom) {
        return true;
    }
}
