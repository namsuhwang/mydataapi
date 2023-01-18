package com.kpcnc.mydataapi.api.collect.pull.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccForm;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankCustForm;
import com.kpcnc.mydataapi.api.base.bank.service.BankAccService;
import com.kpcnc.mydataapi.api.base.bank.service.BankCustService;
import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallRequestInfoDto;
import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallResponseInfoDto;
import com.kpcnc.mydataapi.api.collect.pull.models.form.PullForm;
import com.kpcnc.mydataapi.api.collect.pull.service.PullService;
import com.kpcnc.mydataapi.api.common.api.models.ApiMstSearch;
import com.kpcnc.mydataapi.api.common.api.models.entity.ApiMstEntity;
import com.kpcnc.mydataapi.api.common.api.service.ApiMstService;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import com.kpcnc.mydataapi.api.common.gateway.models.in.Bank001DetailInDto;
import com.kpcnc.mydataapi.api.common.gateway.models.in.Bank001InDto;
import com.kpcnc.mydataapi.api.common.gateway.service.CallMyDataGatewayService;
import com.kpcnc.mydataapi.api.common.member.models.member.MemberTokenSearch;
import com.kpcnc.mydataapi.api.common.member.models.member.entity.MemberEntity;
import com.kpcnc.mydataapi.api.common.member.models.member.entity.MemberTokenEntity;
import com.kpcnc.mydataapi.api.common.member.service.MemberService;
import com.kpcnc.mydataapi.api.common.member.service.MemberTokenService;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvHistBaseForm;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvHistDetailForm;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvStatusForm;
import com.kpcnc.mydataapi.api.common.recv.service.*;
import com.kpcnc.mydataapi.common.CommUtil;
import com.kpcnc.mydataapi.common.exception.MyDataApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.kpcnc.mydataapi.common.models.ErrorCode.MYDATA_ERROR_1001;
import static com.kpcnc.mydataapi.common.models.ErrorCode.MYDATA_ERROR_1002;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class PullServiceImpl implements PullService {

    @Autowired MemberService memberService;
    @Autowired MemberTokenService memberTokenService;
    @Autowired ApiMstService apiMstService;
    @Autowired RecvBaselineService recvBaselineService;
    @Autowired LedgerBankService ledgerBankService;
    @Autowired CallMyDataGatewayService callMyDataGatewayService;
    @Autowired BankAccService bankAccService;
    @Autowired BankCustService bankCustService;

    @Autowired
    RequestParamsSetService reqParamsSetService;
    @Autowired
    RecvStatusService recvStatusService;
    @Autowired
    RecvHistBaseService recvHistBaseService;

    @Autowired
    RecvHistDetailService recvHistDetailService;

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
            throw new MyDataApiException(MYDATA_ERROR_1001, "존재하지 않는 회원입니다.");
        }

        // 전송요구 내역 조회
        MemberTokenSearch tokenSearch = new MemberTokenSearch();
        tokenSearch.setMemberId(form.getMemberId());
        tokenSearch.setCurrentDt(CommUtil.getCurrentDateTime14());
        List<MemberTokenEntity> tokenList = memberTokenService.getMemberTokenList(tokenSearch).getList();
        if(CommUtil.isListNullEmpty(tokenList)){
            throw new MyDataApiException(MYDATA_ERROR_1002, "유효한 전송요구 내역이 없습니다.");
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
        for(MemberTokenEntity token : tokenList){
            // 고객선택자산 정보 요청. sendRequestType = 1.
            // 0(자산목록 요청)의 경우는 통합인증하면서 고객이 전송요구 등록할 때에 사용함
            if(token.getSendRequestType().equals("1")) {
                try {
                    pullPersonalInfoRun(member, token, recvStatusForm);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                targetList.add(token.getOrgCd());
            }
        }

        return targetList;
    }


    /*
        기관별 전송요구등록건별 조회 처리
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> pullPersonalInfoRun(MemberEntity member, MemberTokenEntity memberToken, RecvStatusForm recvStatusForm) throws JsonProcessingException {
        List<String> targetList = new ArrayList<>();
        ApiMstEntity targetApiInfo = null;
        HashMap<String, Object> paramsMap = null;
        List<String> assetList = null;  // 자산목록(예:계좌목록)
        HashMap<String, Object> reqParamMap = null;

        List<String> scopeList = Arrays.asList(memberToken.getScopeList().split(" "));

        ApiCallRequestInfoDto reqInfo = new ApiCallRequestInfoDto();
        reqInfo.setMemberId(memberToken.getMemberId());
        reqInfo.setMemberCi(member.getCi());
        reqInfo.setAccessToken(memberToken.getAccessToken());
        reqInfo.setRefreshToken(memberToken.getRepreshToken());
        reqInfo.setIdstType(CommUtil.getIdstTypeByScope(scopeList.get(0)));
        reqInfo.setOrgCd(memberToken.getOrgCd());

        // 전송여부가 자산목록인 건 조회.
        // MEMBER_TOKEM.SCOPE_LIST 의 첫번째는 무조건 자산목록(*.list) scope 라고 가정.
        /* 자산목록 요청인 건만 먼저 조회하여 조회해야할 자산목록 설정(예:계좌목록)  */


        // 보유자산목록을 조회하기 위한 API 정보(*.list)
        ApiMstEntity apiMst = getApiListByScope(scopeList.get(0)).get(0);
        reqParamMap = reqParamsSetService.getParamsBank001(reqInfo.getMemberId(), reqInfo.getOrgCd());

        reqInfo.setRequestApiId(apiMst.getApiId());
        reqInfo.setRequestUrl(apiMst.getApiUrlResource());

        // 수신 상태 업데이트
        recvStatusForm.setIncOrgCnt(1);
        recvStatusForm.setLastRecvOrgCd(reqInfo.getOrgCd());
        recvStatusService.updRecvStatus(recvStatusForm);

        // 수신 시작 정보 생성
        RecvHistBaseForm recvHistBaseForm = new RecvHistBaseForm();
        recvHistBaseForm.setOrgCd(reqInfo.getOrgCd());
        recvHistBaseForm.setApiId(reqInfo.getRequestApiId());
        recvHistBaseForm.setRecvSeq(recvStatusForm.getRecvSeq());
        recvHistBaseForm.setRecvStartDt(CommUtil.getCurrentDateTime14());
        recvHistBaseForm.setRegUserId("user01");
        recvHistBaseForm.setChgUserId("user01");
        recvHistBaseService.regRecvHistBase(recvHistBaseForm);

        RecvHistDetailForm regHistDetailFrom = new RecvHistDetailForm(recvHistBaseForm);

        while(true){
            reqInfo.setRequestParameterJson(new ObjectMapper().writeValueAsString(reqParamMap));

            // 게이트웨이 call
            ApiCallResponseInfoDto resInfo = callMyDataGatewayService.callMyDataApi(reqInfo);

            // 수신한 내용을 먼저 RECV_HIST_DETAIL 인서트
            regHistDetailFrom.setRecvDetailSeq(recvHistDetailService.createRecvDetailSeq());
            regHistDetailFrom.setRecvData(resInfo.getResultJson());
            recvHistDetailService.regRecvHistDetail(regHistDetailFrom);

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }

            reqParamMap.put("search_timestamp", resInfo.getSearchTimeStamp());
            reqParamMap.put("next_page", resInfo.getNextPage());

            // 수신한 결과를 테이블에 인서트
            Bank001InDto bank001InDto = (Bank001InDto) resInfo.getData();
            FormBase formBase = new FormBase();
            formBase.setApiTranDay(CommUtil.getCurrentDate8());
            formBase.setApiTranId(bank001InDto.getXApiTranId());
            formBase.setRegUserId("user01");
            formBase.setChgUserId("user01");

            // BankCust 테이블 반영
            BankCustForm bankCustForm = (BankCustForm) formBase;
            bankCustForm.setRegDate(bank001InDto.getRegDate());
            bankCustService.modBankCust(bankCustForm);

            // BankAcc 테이블 반영
            // 계좌목록은 해지계좌목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
            bankAccService.allDelBankAcc((BankAccForm) formBase);
            List<Bank001DetailInDto> accountList = bank001InDto.getAccountList();
            for(Bank001DetailInDto accountInfo : accountList){
                bankAccService.regBankAcc(accountInfo.getForm(formBase));
            }
        }

        recvHistBaseForm.setRecvEndDt(CommUtil.getCurrentDateTime14());
        recvHistBaseService.updRecvHistBase(recvHistBaseForm);

        for(String scopeTmp : scopeList){
//            List<String> apiIdList = getApiIdByScope(scopeTmp);

        }

        return CompletableFuture.completedFuture(targetList);
    }


    /*
        in : scope (예 : bank.deposit)
        out : scope에 해당하는 API ID 목록(예 :  BANK_002, BANK_003, BANK_004, BANK_014)
     */
    private List<ApiMstEntity> getApiListByScope(String scope){
        List<String> apiIdList = new ArrayList<>();
        List<ApiMstEntity> apiMstlist = apiMstService.getApiMstList(new ApiMstSearch(scope)).getList();
        return apiMstlist;
    }


}
