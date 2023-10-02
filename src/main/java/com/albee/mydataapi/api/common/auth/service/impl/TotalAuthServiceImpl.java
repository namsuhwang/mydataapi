package com.albee.mydataapi.api.common.auth.service.impl;

import com.albee.mydataapi.api.base.common.service.PersonalInfoService;
import com.albee.mydataapi.api.common.auth.models.dto.TotalAuthRequest;
import com.albee.mydataapi.api.common.auth.models.dto.TotalAuthResponse;
import com.albee.mydataapi.api.common.auth.service.TotalAuthService;
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
public class TotalAuthServiceImpl implements TotalAuthService {
    @Autowired
    MydataapidriverFeignClient mydataapidriverFeignClient;


    /*
        접근토큰 발급 요청
        API ID : 전송요구-004
        API 요청자 : 마이데이터사업자
        API 제공자 : 정보제공자, 중계기관
        API명(URI) : /oauth2.0/token
        설명
        마이데이터사업자는 고객이 선택한 정보제공자를 대상으로 통합인증을 요청(전자서명 전송)
        • 마이데이터 서버는 1개 이상의 정보제공자에게 해당 기관을 대상으로 하는 전자서명을 각각 전송
        • 요청메시지 내 auth_type, consent_type 항목 설정 방식
            - 공동인증서(인증서 본인확인) 기반 통합인증 : auth_type : 0, consent_type : 0
            - 사설인증서(전자서명인증사업자) 기반 통합인증 : auth_type : 1, consent_type : 1
        처리내용
     */
    @Override
    public TotalAuthResponse totalAuth002(TotalAuthRequest dom){
        TotalAuthResponse totAuthRes = mydataapidriverFeignClient.totalAuthRequest(dom).getBody();; // 실제로는 응답값을 받아와야 함

        return totAuthRes;
    }


}
