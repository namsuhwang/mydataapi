package com.albee.mydataapi.api.common.trans.service.impl;

import com.albee.mydataapi.api.base.common.service.PersonalInfoService;
import com.albee.mydataapi.api.common.auth.models.dto.TotalAuthRequest;
import com.albee.mydataapi.api.common.auth.models.dto.TotalAuthResponse;
import com.albee.mydataapi.api.common.gateway.models.res.ResRootDto;
import com.albee.mydataapi.api.common.member.models.member.MemberSearch;
import com.albee.mydataapi.api.common.member.models.member.MemberTokenSearch;
import com.albee.mydataapi.api.common.member.models.member.entity.MemberEntity;
import com.albee.mydataapi.api.common.member.models.member.entity.MemberTokenEntity;
import com.albee.mydataapi.api.common.member.models.member.form.MemberTokenForm;
import com.albee.mydataapi.api.common.member.service.MemberService;
import com.albee.mydataapi.api.common.member.service.MemberTokenService;
import com.albee.mydataapi.api.common.trans.models.TransReqSearch;
import com.albee.mydataapi.api.common.trans.models.dto.*;
import com.albee.mydataapi.api.common.trans.models.entity.TransReqEntity;
import com.albee.mydataapi.api.common.trans.service.TransReqDbService;
import com.albee.mydataapi.api.common.trans.service.TransRequestService;
import com.albee.mydataapi.common.CommUtil;
import com.albee.mydataapi.common.client.MydataapidriverFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class TransRequestServiceImpl implements TransRequestService {
    @Autowired
    MemberService memberService;

    @Autowired
    TransReqDbService transReqDbService;

    @Autowired
    MemberTokenService memberTokenService;

    @Autowired
    MydataapidriverFeignClient mydataapidriverFeignClient;

    @Autowired
    PersonalInfoService personalInfoService;

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
            4. 신규 전송요구건이면 회원토큰 테이블에 인서트, 수정건이면 업데이트
            5. 전송요그-003 을 이용하여 종합포털(또는 거점기관)에 전송요구 등록 결과를 통보함
     */
    @Override
    public Boolean transRequest002(TransRequestSpec dom) {

        MemberSearch memberSearch = new MemberSearch();
        memberSearch.setCi(dom.getUsername());
        MemberEntity member = memberService.getMember(memberSearch);
        dom.setMember(member);

        if(dom.getSendReqSeq() != null && dom.getSendReqSeq() > 0){
            MemberTokenEntity token = memberTokenService.getMemberToken(new MemberTokenSearch(member.getMemberId(), dom.getOrgCode(), dom.getSendReqSeq()));
            dom.setToken(token);
        }

        transRequestProc(dom);
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
    public Boolean transRequest004(TransRequestWithdraw dom) {

        TransReqEntity transReq = transReqDbService.getTransReq(new TransReqSearch(dom.getMemberId(), null, dom.getTxId()));

        // 기존 전송요구건이 없으면 에러 처리
        if(transReq == null){
            return false;
        }

        MemberTokenEntity token = memberTokenService.getMemberToken(new MemberTokenSearch(dom.getMemberId(), null, dom.getTxId()));

        // 기존 토큰이 없거나 유효하지 않으면 에러 처리
        if(token == null || token.getAccessTokenExpireYn().equalsIgnoreCase("Y")){
            return false;
        }

        transRequestWithdrawProc(dom, transReq, token);

        return true;
    }


    /*
        전송요구-002 의 내용을 처리

            transRequest002 에서는 먼저 정상 응답만 후 async로 transRequestProc 를 호출하여 실제 처리함
            1. 수신한 전송요구 내용을 테이블(전송요구서)에 저장
            2. 통합인증-002 를 호출하여 해당 전송요구 내용에 대한 접근토큰(정보제공자측에서 발급) 을 발급받음
            3. 신규 전송요구건이면 회원토큰 테이블에 인서트, 수정건이면 업데이트
            4. 전송요그-003 을 이용하여 종합포털(또는 거점기관)에 전송요구 등록 결과를 통보함
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<ResRootDto> transRequestProc(TransRequestSpec spec) {
        ResRootDto result = new ResRootDto();

        Date currentDt = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다. 년월일시분초 14자리 포멧
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        String currentDtString = df.format(currentDt.getTime());
        TransRequestConsent consent = (new ObjectMapper()).convertValue(spec.getConsent(), TransRequestConsent.class);


        // 통합인증-002 호출
        TotalAuthRequest totAuthReq = new TotalAuthRequest(spec);
        TotalAuthResponse totAuthRes = mydataapidriverFeignClient.totalAuthRequest(totAuthReq).getBody();; // 실제로는 응답값을 받아와야 함

        long expireDtLong = currentDt.getTime() + totAuthRes.getExpiresIn();
        String accessTokenDueDt = df.format(expireDtLong);

        long refreshExpireDtLong = currentDt.getTime() + totAuthRes.getExpiresIn();
        String refreshTokenDutDt = df.format(refreshExpireDtLong);

        List<String> scopeList = CommUtil.getScopeList(spec.getConsent());
        String scopeString = CommUtil.getStringScopeList(scopeList);
        String idstType = CommUtil.getIdstTypeByScope(scopeString.split(" ")[0]);

        // 전송요청유형. 0:.list 만 존재. 1: 고객선택자산 요청 포함
        String sendRequestType = "0";  // .list 가 아닌 scope 가 하나라도 있으면 "1"
        for(String sc : scopeList){
            if(!sc.toLowerCase().contains(".list")){
                sendRequestType = "1";
                break;
            }
        }

        MemberTokenForm tokenForm = new MemberTokenForm();
        tokenForm.setMemberId(spec.getMember().getMemberId());
        tokenForm.setOrgCd(spec.getOrgCode());

        // 동일한 전송요구건이 없으면 인서트 존재하면 업데이트
        if(spec.getSendReqSeq() == null && spec.getToken() == null){
            transReqDbService.regTransReq(spec.getTransReqForm());
            int sendReqSeq = memberTokenService.createSendReqSeq(new MemberTokenSearch(spec.getMember().getMemberId(), spec.getOrgCode()));
            tokenForm.setSendReqSeq(sendReqSeq);
        }else{
            transReqDbService.updTransReq(spec.getTransReqForm());
            MemberTokenEntity token = memberTokenService.getMemberToken(new MemberTokenSearch(spec.getMember().getMemberId(), spec.getOrgCode(), spec.getSendReqSeq()));
            tokenForm.setSendReqSeq(token.getSendReqSeq());
        }

        tokenForm.setIdstType(idstType);
        tokenForm.setScopeList(scopeString);
        tokenForm.setScopeLists(scopeList);
        tokenForm.setSendRequestType(sendRequestType);
        tokenForm.setFpSendReqYn(consent.getIsScheduled() ? "Y" : "N");
        tokenForm.setFpSendReqDt(currentDtString);
        tokenForm.setFpSendReqStartDay(currentDtString.substring(0, 8));
        tokenForm.setFpSendReqEndDay(consent.getEndDate());
        tokenForm.setFpCycl(consent.getFndCycle());
        tokenForm.setHoldEndDay(consent.getPeriod());
        tokenForm.setAccessToken(totAuthRes.getAccessToken());
        tokenForm.setAccessTokenExpireIn(totAuthRes.getExpiresIn());
        tokenForm.setAccessTokenDueDt(accessTokenDueDt);
        tokenForm.setAccessTokenIssueDt(CommUtil.getCurrentDateTime14());
        tokenForm.setAccessTokenExpireYn("N");
        tokenForm.setRefreshToken(totAuthRes.getRefreshToken());
        tokenForm.setRefreshTokenExpireIn(totAuthRes.getRefreshTokenExpiresIn());
        tokenForm.setRefreshTokenDueDt(refreshTokenDutDt);
        tokenForm.setRefreshTokenExpireYn("N");
        tokenForm.setRefreshTokenIssueDt(CommUtil.getCurrentDateTime14());
        memberTokenService.regMemberToken(tokenForm);

        result.setXApiTranId(spec.getXApiTranId());
        result.setRspCode("000000");
        result.setRspMsg("성공");

        // 종합포털에 전송요구 내용 전달
        TransReqEntity transReq = transReqDbService.getTransReq(new TransReqSearch(spec.getMember().getMemberId(), spec.getOrgCode()));
        transRequest003(transReq);

        return CompletableFuture.completedFuture(result);
    }


    /*
        전송요구-003 의 내용을 처리

            1. 개별인증-004 를 이용하여 정보제공자가 접근토큰을 검증 및 폐기하도록 함
            2. 필요시 개인신용정보 삭제(개인신용정보 삭제 요청 여부가 true 인 경우)
            3. 토큰 폐기 처리(MEMBER_TOKEN) 상태를 취소 상태로 변경(업데이트)
            4. 전송요구-003 이용하여 전송요구 철회 결과를 종합포털(또는 거점기관)에 전달함
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<ResRootDto> transRequestWithdrawProc(TransRequestWithdraw dom, TransReqEntity transReq, MemberTokenEntity token) {

        ResRootDto result = null;

        String expireDt = CommUtil.getCurrentDateTime14();

        result.setXApiTranId(dom.getXApiTranId());

        // 전송요구 철회대상
        // 전송요구 테이블(TRANS_REQ)은 상태항목이 없으므로 업데이트할게 없음
        // 토큰 expire 처리token.setAccessTokenExpireYn("Y");
        token.setAccessTokenExpireDt(expireDt);
        token.setRefreshTokenExpireYn("Y");
        token.setRefreshTokenExpireDt(expireDt);
        memberTokenService.updMemberToken(token);

        // 개인신용정보 삭제 처리
        if(dom.getIsDelete()){
            personalInfoService.deleteTable(transReq);
        }

        result = transRequest003(transReq);

        return CompletableFuture.completedFuture(result);
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
    public ResRootDto transRequest003(TransReqEntity dom) {
        TransRequestProcResult procResult = new TransRequestProcResult();
        procResult.setMemberId(dom.getMemberId());
        procResult.setXApiTranId(dom.getApiTranId());
        procResult.setType("01");   // ‘01’ : 전송요구 결과 전송. ‘02’ : 전송요구 철회 결과 전송
        procResult.setResultCode("00000");
        procResult.setResultMsg("성공");
        procResult.setTxId(dom.getTxId());
        procResult.setUserCi(dom.getCi());
        ResponseEntity<ResRootDto> result = mydataapidriverFeignClient.replyTransRequestProcResult(procResult);
        return result.getBody();
    }

}
