package com.albee.mydataapi.api.collect.pull.service.impl;

import com.albee.mydataapi.api.base.bank.service.BankAccService;
import com.albee.mydataapi.api.base.bank.service.BankCustService;
import com.albee.mydataapi.api.collect.pull.models.form.PullForm;
import com.albee.mydataapi.api.collect.pull.service.PullBankService;
import com.albee.mydataapi.api.collect.pull.service.PullCardService;
import com.albee.mydataapi.api.collect.pull.service.PullInsuService;
import com.albee.mydataapi.api.collect.pull.service.PullService;
import com.albee.mydataapi.api.common.api.service.ApiMstService;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.gateway.service.CallMyDataGatewayService;
import com.albee.mydataapi.api.common.member.models.member.MemberTokenSearch;
import com.albee.mydataapi.api.common.member.models.member.entity.MemberEntity;
import com.albee.mydataapi.api.common.member.models.member.entity.MemberTokenEntity;
import com.albee.mydataapi.api.common.member.service.MemberService;
import com.albee.mydataapi.api.common.member.service.MemberTokenService;
import com.albee.mydataapi.api.common.recv.models.form.RecvStatusForm;
import com.albee.mydataapi.common.CommUtil;
import com.albee.mydataapi.common.exception.MyDataApiException;
import com.albee.mydataapi.common.models.ErrorCode;
import com.albee.mydataapi.api.common.recv.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class PullServiceImpl implements PullService {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberTokenService memberTokenService;
    @Autowired
    ApiMstService apiMstService;
    @Autowired
    RecvBaselineService recvBaselineService;
    @Autowired
    LedgerBankService ledgerBankService;
    @Autowired
    CallMyDataGatewayService callMyDataGatewayService;
    @Autowired
    BankAccService bankAccService;
    @Autowired
    BankCustService bankCustService;

    @Autowired
    RequestBankParamsSetService reqParamsSetService;
    @Autowired
    RecvStatusService recvStatusService;
    @Autowired
    RecvHistBaseService recvHistBaseService;

    @Autowired RecvHistDetailService recvHistDetailService;

    @Autowired
    PullBankService pullBankService;
    @Autowired
    PullCardService pullCardService;
    @Autowired
    PullInsuService pullInsuService;

    /*
        Async로 기관별로 조회 호출.
        기관코드 목록을 응답.
     */
    @Override
    public List<String> execPullPersonalInfoRun(PullForm form){
        List<String> targetList = new ArrayList<>();

        // 회원 정합성 체크
        MemberEntity member = memberService.getMember(form.getMemberId());
        if(member == null){
            throw new MyDataApiException(ErrorCode.MYDATA_ERROR_1001, "존재하지 않는 회원입니다.");
        }

        // 전송요구 내역 조회
        MemberTokenSearch tokenSearch = new MemberTokenSearch();
        tokenSearch.setMemberId(form.getMemberId());
        tokenSearch.setCurrentDt(CommUtil.getCurrentDateTime14());
        List<MemberTokenEntity> tokenList = memberTokenService.getMemberTokenList(tokenSearch).getList();
        if(CommUtil.isListNullEmpty(tokenList)){
            throw new MyDataApiException(ErrorCode.MYDATA_ERROR_1002, "유효한 전송요구 내역이 없습니다.");
        }

        RecvStatusForm recvStatusForm = new RecvStatusForm();
        recvStatusForm.setMemberId(form.getMemberId());
        String recvDay = CommUtil.getCurrentDate8();
        recvStatusForm.setRecvDay(recvDay);
        recvStatusForm.setTargetOrgCnt(tokenList.size());
        recvStatusForm.setRecvStartDt(CommUtil.getCurrentDateTime14());
        recvStatusForm.setRecvStatus("0");
        recvStatusForm.setCompleteOrgCnt(0);
        recvStatusForm.setRegUserId("user01");
        recvStatusForm.setChgUserId("user01");
        String recvSeq = recvStatusService.createRecvSeq(recvStatusForm);
        recvStatusForm.setRecvSeq(recvSeq);
        recvStatusService.regRecvStatus(recvStatusForm);

        // 전송요구 등록된 기관별로 전송요청함
        ApiCallReqDto reqInfo = new ApiCallReqDto();
        reqInfo.setMemberId(member.getMemberId());
        reqInfo.setMemberCi(member.getCi());
        reqInfo.setApiTranDay(recvDay);
        reqInfo.setRecvSeq(recvSeq);

        for(MemberTokenEntity token : tokenList){
            reqInfo.setMemberToken(token);
            reqInfo.setOrgCd(token.getOrgCd());
            reqInfo.setAccessToken(token.getAccessToken());
            reqInfo.setRefreshToken(token.getRepreshToken());
            reqInfo.setIdstType(CommUtil.getIdstTypeByScope(token.getScopeList().split(" ")[0]));

            // 고객선택자산 정보 요청. sendRequestType = 1.
            // 0(자산목록 요청)의 경우는 통합인증하면서 고객이 전송요구 등록할 때에 사용함
            if(token.getSendRequestType().equals("1")) {
                switch(token.getIdstType().toUpperCase()){
                    case "BANK": pullBankService.pullBankInfoRun(reqInfo, recvStatusForm); break;
                    case "CARD": pullCardService.pullCardInfoRun(reqInfo, recvStatusForm); break;
                    case "INSU": pullInsuService.pullInsuInfoRun(reqInfo, recvStatusForm); break;
                }
                targetList.add(token.getOrgCd());
            }
        }

        return targetList;
    }


}
