package com.albee.mydataapi.api.common.trans.service.impl;

import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import com.albee.mydataapi.api.common.gateway.models.res.ResRootDto;
import com.albee.mydataapi.api.common.member.models.member.MemberSearch;
import com.albee.mydataapi.api.common.member.models.member.entity.MemberEntity;
import com.albee.mydataapi.api.common.member.service.MemberService;
import com.albee.mydataapi.api.common.trans.models.TransReqSearch;
import com.albee.mydataapi.api.common.trans.models.dto.CustJoinCheck;
import com.albee.mydataapi.api.common.trans.models.dto.ReplyTransRequestProcResult;
import com.albee.mydataapi.api.common.trans.models.dto.TransRequestRevokeRequest;
import com.albee.mydataapi.api.common.trans.models.dto.TransRequestSpec;
import com.albee.mydataapi.api.common.trans.models.entity.TransReqEntity;
import com.albee.mydataapi.api.common.trans.service.TransReqService;
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

    @Autowired
    TransReqService transReqService;

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
            1. 먼저 수신했다는 의미로 바로 응답(응답 후 아래 내용을 본격 처리함)
            2. 수신한 전송요구 내용을 테이블(전송요구서)에 저장
            3. 통합인증-002 를 호출하여 해당 전송요구 내용에 대한 접근토큰(정보제공자측에서 발급) 을 발급받음
            4. 발급 받은 접근토큰/리프레쉬토큰을 전송요구서 테이블에 업데이트함
            5. 전송요그-003 을 이용하여 종합포털(또는 거점기관)에 전송요구 등록 결과를 통보함
     */
    @Override
    public Boolean transRequest002(TransRequestSpec dom) {
        transReqService.regTransReq(dom.getTransReqForm());
        return true;
    }


    /*
        전송요구 또는 철회 결과 전송
        API ID : 전송요구-003
        API 요청자 : 정보수신자
        API 제공자 : 종합포털, 거점기관
        API명(URI) : /consents/result
        설명
            . 정보수신자가 전송요구(통합인증) 또는 전송요구 철회 완료 후 그 결과를 종합포털에 전송
        처리내용
            . 전송요구 등록/수정 및 철회 요청 처리 후에 호출하여 종합포털(거점기관)에 전달함
     */
    @Override
    public Boolean transRequest003(TransReqEntity dom) {
        ReplyTransRequestProcResult result = new ReplyTransRequestProcResult();
        result.setType("01");   // ‘01’ : 전송요구 결과 전송. ‘02’ : 전송요구 철회 결과 전송
        result.setResultCode("00000");
        result.setResultMsg("성공");
        result.setTxId(dom.getTxId());
        result.setUserCi(dom.getCi());
        return true;
    }

    /*
        전송요구 철회 요청
        API ID : 전송요구-004
        API 요청자 : 종합포털
        API 제공자 : 정보수신자, 거점기관
        API명(URI) : /consents/revoke
        설명
            . 정보주체가 전송요구앱을 통해 전송요구 철회 시 종합포털이 정보수신자에게 전송요구 철회를 요청
        처리내용
            1. 전송요구 내역(전송요구서ID) 등이 존재하는 건인지 검증하여 바로 응답
            2. 개별인증-004 를 이용하여 정보제공자가 접근토큰을 검증 및 폐기하도록 함
            3. 필요시 개인신용정보 삭제(개인신용정보 삭제 요청 여부가 true 인 경우)
            4. 토큰 폐기 처리(MEMBER_TOKEN) 상태를 취소 상태로 변경(업데이트)
            5. 전송요구-003 이용하여 전송요구 철회 결과를 종합포털(또는 거점기관)에 전달함
     */
    @Override
    public ResRootDto transRequest004(TransRequestRevokeRequest dom) {
        ResRootDto result = new ResBaseDto();
        result.setXApiTranId("");

        // 전송요구 철회대상 조회
        TransReqEntity transReq = transReqService.getTransReq(new TransReqSearch(dom.getMemberId(), null, dom.getTxId()));


        if(transRequest003(transReq)){

            result.setRspCode("00000");
            result.setRspMsg("SUCCESS");
        }else{
            result.setRspCode("99999");
            result.setRspMsg("FAIL");
        }

        return result;
    }
}
