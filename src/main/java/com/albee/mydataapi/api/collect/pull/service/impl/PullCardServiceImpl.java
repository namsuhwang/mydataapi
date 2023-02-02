package com.albee.mydataapi.api.collect.pull.service.impl;

import com.albee.mydataapi.api.base.card.models.*;
import com.albee.mydataapi.api.base.card.models.entity.*;
import com.albee.mydataapi.api.base.card.models.form.*;
import com.albee.mydataapi.api.base.card.service.*;
import com.albee.mydataapi.api.collect.pull.service.*;
import com.albee.mydataapi.api.common.api.models.entity.ApiMstEntity;
import com.albee.mydataapi.api.common.api.service.ApiMstService;
import com.albee.mydataapi.api.common.member.service.MemberService;
import com.albee.mydataapi.api.common.member.service.MemberTokenService;
import com.albee.mydataapi.api.common.recv.models.RecvBaselineSearch;
import com.albee.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import com.albee.mydataapi.api.common.recv.service.RecvBaselineService;
import com.albee.mydataapi.api.common.recv.service.RecvHistBaseService;
import com.albee.mydataapi.api.common.recv.service.RecvHistDetailService;
import com.albee.mydataapi.common.CommUtil;
import com.albee.mydataapi.api.collect.pull.models.dto.CardParamsDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallResDto;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.service.CallMyDataGatewayService;
import com.albee.mydataapi.api.common.recv.models.form.RecvStatusForm;
import com.albee.mydataapi.api.common.recv.service.RecvStatusService;
import com.albee.mydataapi.api.common.gateway.models.res.card.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class PullCardServiceImpl implements PullCardService {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberTokenService memberTokenService;
    @Autowired
    ApiMstService apiMstService;
    @Autowired
    RecvBaselineService recvBaselineService;
    @Autowired CallMyDataGatewayService callMyDataGatewayService;

    @Autowired CardAprDmHistService cardAprDmHistService;
    @Autowired
    CardAprOsHistService cardAprOsHistService;
    @Autowired CardBaseService cardBaseService;
    @Autowired
    CardPtService cardPtService;
    @Autowired CardChargeAddService cardChargeAddService;
    @Autowired CardChargeService cardChargeService;
    @Autowired CardDmPcaService cardDmPcaService;
    @Autowired CardLoanLgHistService cardLoanLgHistService;
    @Autowired CardLoanLgService cardLoanLgService;
    @Autowired CardLoanService cardLoanService;
    @Autowired CardLoanStService cardLoanStService;
    @Autowired CardOsPcaService cardOsPcaService;
    @Autowired CardPayDetailService cardPayDetailService;
    @Autowired
    CardPayService cardPayService;
    @Autowired
    CardRvService cardRvService;
    @Autowired
    CardService cardService;

    @Autowired
    PullIrpService pullIrpService;
    @Autowired
    PullPpayService pullPpayService;
    @Autowired
    PullDbService pullDbService;
    @Autowired
    PullDcService pullDcService;
    @Autowired RecvStatusService recvStatusService;
    @Autowired
    RecvHistBaseService recvHistBaseService;
    @Autowired
    RecvHistDetailService recvHistDetailService;

    /*
        기관별 전송요구등록건별 조회 처리
     */
    @Override
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> pullCardInfoRun(ApiCallReqDto req, RecvStatusForm recvStatusForm) {
        List<String> targetList = new ArrayList<>();

        FormBase formBase = new FormBase(req.getMemberId(), req.getOrgCd());
        formBase.setApiTranDay(req.getApiTranDay());

        // 전송여부가 자산목록인 건 조회.
        // MEMBER_TOKEM.SCOPE_LIST 의 첫번째는 무조건 자산목록(*.list) scope 라고 가정.
        /* 자산목록 요청인 건만 먼저 조회하여 조회해야할 자산목록 설정(예:계좌목록)  */

        // 보유자산목록(*.list)을 조회하기 위한 API 정보
        ApiMstEntity assetListQryApiEntity = apiMstService.getApiListByScope(req.getMemberToken().getScopeLists().get(0)).get(0);
        req.setRequestApiId(assetListQryApiEntity.getApiId());
        req.setRequestUrl(assetListQryApiEntity.getApiUrlResource());

        // 수신 상태 업데이트. 기관코드 + API 별로 수신시작/종료 상태 저장.
        recvStatusService.updRecvStatus(recvStatusForm, 1, req.getOrgCd());

        // 카드별이 아닌 고객별 데이터 조회
        if(req.getMemberToken().getScopeLists().contains("card.card")){    // 카드 정보

            CompletableFuture<List<String>> card001Result = callCard001(req, formBase);
            card001Result.thenAccept(cardIdList -> {
                for (String cardId : cardIdList) {
                    callCard002(req, formBase, cardId);  // 카드 기본정보
                }
            });

            callCard008(req, formBase);    // 국내 승인내역
            callCard009(req, formBase);    // 해외 승인내역
            callCard014(req, formBase);    // 국내 카드매입정보(매입취소정보)
            callCard015(req, formBase);    // 해외 카드매입정보(매입취소정보)
        }

        if(req.getMemberToken().getScopeLists().contains("card.point")){    // 포인트 정보
            callCard003(req, formBase);
        }

        if(req.getMemberToken().getScopeLists().contains("card.bill")){    // 청구 정보
            callCard004(req, formBase);
            callCard005(req, formBase);
            callCard006(req, formBase);
            callCard007(req, formBase);
        }

        if(req.getMemberToken().getScopeLists().contains("card.loan")){    // 대출 정보
            callCard010(req, formBase);
            callCard011(req, formBase);

            // 장기 대출 거래내역
            CompletableFuture<List<String>> card012Result = callCard012(req, formBase);
            card012Result.thenAccept(loanNumList -> {
                for (String loanNum : loanNumList) {
                    callCard013(req, formBase, loanNum);
                }
            });
        }

        if(req.getMemberToken().getScopeLists().contains("card.prepaid")){
            pullPpayService.pullPpayInfoRun(req, formBase);
        }
        
        // 수신 상태 업데이트. 기관코드 + API 별로 종료 상태 저장.
        recvStatusForm.setRecvStatus("1");
        recvStatusForm.setRecvEndDt(CommUtil.getCurrentDateTime14());
        recvStatusService.updRecvStatus(recvStatusForm);
        return CompletableFuture.completedFuture(targetList);
    }

    /*
        CARD_001 (CARD) 카드 목록
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> callCard001(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("CARD_001");

        List<String> cardIdList = new ArrayList<>();

        // 입력 파라메터용 Map, Json 기본 설정
        CardParamsDto cardParamsDto = (CardParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));

        req.setReqParamJson(cardParamsDto.getParamsCard001(baseline.getSearchTimeStamp(), baseline.getNextPage()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Card001ResDto.class, Card001ResDetailDto.class);
        Card001ResDto resDto = (Card001ResDto) resInfo.getData();

        // 카드목록은 해지카드목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        cardService.allDelCard((CardForm) formBase);

        formBase.setApiTranDay(req.getApiTranDay());
        formBase.setApiTranId(resDto.getXApiTranId());
        List<Card001ResDetailDto> accountInfoList = resDto.getList();

        // 테이블 반영
        for(Card001ResDetailDto detail : accountInfoList){
            cardService.regCard(detail.getForm(formBase));
            if(detail.getIsConsent() && !cardIdList.contains(detail.getCardId())){
                cardIdList.add(detail.getCardId());
            }
        }

        return CompletableFuture.completedFuture(cardIdList);
    }


    /*
        CARD_002 (CARD_BASE) 카드 기본정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callCard002(ApiCallReqDto req, FormBase formBase, String cardId){
        req.setRequestApiId("CARD_002");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        CardBaseEntity entity = cardBaseService.getCardBase(new CardBaseSearch(req.getMemberId(), req.getOrgCd(), cardId));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        CardParamsDto cardParamsDto = (CardParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(cardParamsDto.getParamsCard002(cardId, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Card002ResDto.class);
        Card002ResDto resDto = (Card002ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());
        cardBaseService.regCardBase(resDto.getForm(formBase, cardId));
        return CompletableFuture.completedFuture(new String[]{cardId});
    }


    /*
        CARD_003 (CARD_PT) 카드 포인트 정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callCard003(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("CARD_003");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        CardParamsDto cardParamsDto = (CardParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(cardParamsDto.getParamsCard003(baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Card003ResDto.class, Card003ResDetailDto.class);
        Card003ResDto resDto = (Card003ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        // 탈퇴한 포인트가 있을 수 있을 수 있는데 알 수 없기 때문에 일단 전체 삭제 후 인서트
        cardPtService.allDelCardPt((CardPtForm) formBase);

        if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
            for (Card003ResDetailDto detail : resDto.getList()) {
                cardPtService.regCardPt(detail.getForm(formBase));
            }
        }
        return CompletableFuture.completedFuture(new String[]{req.getMemberId()});
    }



    /*
        CARD_004 (CARD_CHARGE) 카드 청구 기본정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callCard004(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("CARD_004");
        CardChargeEntity lastHist = cardChargeService.getCardChargeLast(new CardChargeSearch(req.getMemberId(), req.getOrgCd()));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        CardParamsDto cardParamsDto = (CardParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(cardParamsDto.getParamsCard004(lastHist.getChargeMonth(), CommUtil.getCurrentDate8().substring(1, 6), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Card004ResDto.class, Card004ResDetailDto.class);
            Card004ResDto resDto = (Card004ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Card004ResDetailDto detail : resDto.getList()) {
                    if(detail.getChargeMonth().equals(lastHist.getChargeMonth())){
                        cardChargeService.modCardCharge(detail.getForm(formBase));
                    }else {
                        cardChargeService.regCardCharge(detail.getForm(formBase));
                    }
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{req.getMemberId()});
    }



    /*
        CARD_005 (CARD_CHARGE_ADD) 카드 청구 추가정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callCard005(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("CARD_005");

        CardChargeAddEntity lastHist = cardChargeAddService.getCardChargeAddLast(new CardChargeAddSearch(req.getMemberId(), req.getOrgCd()));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        CardParamsDto cardParamsDto = (CardParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(cardParamsDto.getParamsCard005(lastHist.getChargeMonth(), CommUtil.getCurrentDate8().substring(1, 6), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Card005ResDto.class, Card005ResDetailDto.class);
            Card005ResDto resDto = (Card005ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Card005ResDetailDto detail : resDto.getList()) {
                    if(detail.getChargeMonth().equals(lastHist.getChargeMonth())){
                        cardChargeAddService.modCardChargeAdd(detail.getForm(formBase));
                    }else {
                        cardChargeAddService.regCardChargeAdd(detail.getForm(formBase));
                    }
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{req.getMemberId()});
    }


    /*
        CARD_006 (CARD_PAY) 카드 결제정보, (CARD_PAY_DETAIL) 카드 결제정보 상세
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callCard006(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("CARD_006");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        CardParamsDto cardParamsDto = (CardParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(cardParamsDto.getParamsCard003(baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Card006ResDto.class, Card006ResDetailDto.class);
        Card006ResDto resDto = (Card006ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        // 고객의 현재 결제 정보를 먼저 전부 삭제 후 인서트
        cardPayDetailService.allDelCardPayDetail((CardPayDetailForm) formBase);

        // 결제 정보 기본(CARD_PAY) 부터 반영
        cardPayService.modCardPay(resDto.getForm(formBase));

        if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
            for (Card006ResDetailDto detail : resDto.getList()) {
                cardPayDetailService.regCardPayDetail(detail.getForm(formBase));
            }
        }
        return CompletableFuture.completedFuture(new String[]{req.getMemberId()});
    }



    /*
        CARD_007 (CARD_RV) 카드 리볼빙 정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callCard007(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("CARD_007");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        CardParamsDto cardParamsDto = (CardParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(cardParamsDto.getParamsCard003(baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Card007ResDto.class, Card007ResDetailDto.class);
        Card007ResDto resDto = (Card007ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        // 고객의 현재 리볼빙 정보를 먼저 전부 삭제 후 인서트
        cardRvService.allDelCardRv((CardRvForm) formBase);

        if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
            for (Card007ResDetailDto detail : resDto.getList()) {
                cardRvService.regCardRv(detail.getForm(formBase));
            }
        }
        return CompletableFuture.completedFuture(new String[]{req.getMemberId()});
    }


    /*
        CARD_008 (CARD_APR_DM_HIST) 카드 국내 승인내역
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callCard008(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("CARD_008");

        CardAprDmHistEntity lastHist = cardAprDmHistService.getCardAprDmHistLast(new CardAprDmHistSearch(req.getMemberId(), req.getOrgCd()));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        CardParamsDto cardParamsDto = (CardParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(cardParamsDto.getParamsCard008(lastHist.getApprovedDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Card008ResDto.class, Card008ResDetailDto.class);
            Card008ResDto resDto = (Card008ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Card008ResDetailDto detail : resDto.getList()) {
                    if(detail.getApprovedDtime().substring(0, 8).equals(lastHist.getApprovedDtime().substring(0, 8))){
                        cardAprDmHistService.modCardAprDmHist(detail.getForm(formBase));
                    }else {
                        cardAprDmHistService.regCardAprDmHist(detail.getForm(formBase));
                    }
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{req.getMemberId()});
    }


    /*
        CARD_009 (CARD_APR_OS_HIST) 카드 해외 승인내역
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callCard009(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("CARD_009");

        CardAprOsHistEntity lastHist = cardAprOsHistService.getCardAprOsHistLast(new CardAprOsHistSearch(req.getMemberId(), req.getOrgCd()));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        CardParamsDto cardParamsDto = (CardParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(cardParamsDto.getParamsCard009(lastHist.getApprovedDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Card009ResDto.class, Card009ResDetailDto.class);
            Card009ResDto resDto = (Card009ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Card009ResDetailDto detail : resDto.getList()) {
                    if(detail.getApprovedDtime().substring(0, 8).equals(lastHist.getApprovedDtime().substring(0, 8))){
                        cardAprOsHistService.modCardAprOsHist(detail.getForm(formBase));
                    }else {
                        cardAprOsHistService.regCardAprOsHist(detail.getForm(formBase));
                    }
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{req.getMemberId()});
    }



    /*
        CARD_010 (CARD_LOAN) 카드 대출상품 목록
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callCard010(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("CARD_010");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        CardParamsDto cardParamsDto = (CardParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(cardParamsDto.getParamsCard003(baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Card007ResDto.class, Card007ResDetailDto.class);
        Card007ResDto resDto = (Card007ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        // 고객의 현재 리볼빙 정보를 먼저 전부 삭제 후 인서트
        cardRvService.allDelCardRv((CardRvForm) formBase);

        if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
            for (Card007ResDetailDto detail : resDto.getList()) {
                cardRvService.regCardRv(detail.getForm(formBase));
            }
        }
        return CompletableFuture.completedFuture(new String[]{req.getMemberId()});
    }




    /*
        CARD_011 (CARD_LOAN_ST) 카드 단기대출 정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callCard011(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("CARD_011");

        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        CardParamsDto cardParamsDto = (CardParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(cardParamsDto.getParamsCard011(baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Card011ResDto.class, Card011ResDetailDto.class);
        Card011ResDto resDto = (Card011ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        // 고객의 현재 리볼빙 정보를 먼저 전부 삭제 후 인서트
        cardLoanStService.allDelCardLoanSt((CardLoanStForm) formBase);

        if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
            for (Card011ResDetailDto detail : resDto.getList()) {
                cardLoanStService.regCardLoanSt(detail.getForm(formBase));
            }
        }
        return CompletableFuture.completedFuture(new String[]{req.getMemberId()});
    }



    /*
        CARD_012 (CARD_LOAN_LG) 카드 장기대출 정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> callCard012(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("CARD_012");

        List<String> loanNumList = new ArrayList<>();

        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        CardParamsDto cardParamsDto = (CardParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(cardParamsDto.getParamsCard012(baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Card012ResDto.class, Card012ResDetailDto.class);
        Card012ResDto resDto = (Card012ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        // 고객의 현재 리볼빙 정보를 먼저 전부 삭제 후 인서트
        cardLoanLgService.allDelCardLoanLg((CardLoanLgForm) formBase);

        if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
            for (Card012ResDetailDto detail : resDto.getList()) {
                cardLoanLgService.regCardLoanLg(detail.getForm(formBase));
                loanNumList.add(detail.getLoanNum());
            }
        }
        return CompletableFuture.completedFuture(loanNumList);
    }


    /*
        CARD_013 (CARD_LOAN_LG_HIST) 카드 장기대출 거래내역
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callCard013(ApiCallReqDto req, FormBase formBase, String loanNum){
        req.setRequestApiId("CARD_013");

        CardLoanLgHistEntity lastHist = cardLoanLgHistService.getCardLoanLgHistLast(new CardLoanLgHistSearch(req.getMemberId(), req.getOrgCd(), loanNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        CardParamsDto cardParamsDto = (CardParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(cardParamsDto.getParamsCard013(loanNum, lastHist.getTransDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Card013ResDto.class, Card013ResDetailDto.class);
            Card013ResDto resDto = (Card013ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Card013ResDetailDto detail : resDto.getList()) {
                    if(detail.getTransDtime().substring(0, 8).equals(lastHist.getTransDtime().substring(0, 8))){
                        cardLoanLgHistService.modCardLoanLgHist(detail.getForm(formBase));
                    }else {
                        cardLoanLgHistService.regCardLoanLgHist(detail.getForm(formBase));
                    }
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{req.getMemberId()});
    }



    /*
        CARD_014 (CARD_DM_PCA) 카드 국내 카드매입정보(매입취소정보)
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callCard014(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("CARD_014");

        CardDmPcaEntity lastHist = cardDmPcaService.getCardDmPcaLast(new CardDmPcaSearch(req.getMemberId(), req.getOrgCd()));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        CardParamsDto cardParamsDto = (CardParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(cardParamsDto.getParamsCard014(lastHist.getPurchaseDate(), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Card014ResDto.class, Card014ResDetailDto.class);
            Card014ResDto resDto = (Card014ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Card014ResDetailDto detail : resDto.getList()) {
                    if(detail.getPurchaseDate().substring(0, 8).equals(lastHist.getPurchaseDate().substring(0, 8))){
                        cardDmPcaService.modCardDmPca(detail.getForm(formBase));
                    }else {
                        cardDmPcaService.regCardDmPca(detail.getForm(formBase));
                    }
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{req.getMemberId()});
    }

    /*
        CARD_015 (CARD_OS_PCA) 카드 해외 카드매입정보(매입취소정보)
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callCard015(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("CARD_015");

        CardOsPcaEntity lastHist = cardOsPcaService.getCardOsPcaLast(new CardOsPcaSearch(req.getMemberId(), req.getOrgCd()));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        CardParamsDto cardParamsDto = (CardParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(cardParamsDto.getParamsCard015(lastHist.getPurchaseDate(), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Card015ResDto.class, Card015ResDetailDto.class);
            Card015ResDto resDto = (Card015ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Card015ResDetailDto detail : resDto.getList()) {
                    if(detail.getPurchaseDate().substring(0, 8).equals(lastHist.getPurchaseDate().substring(0, 8))){
                        cardOsPcaService.modCardOsPca(detail.getForm(formBase));
                    }else {
                        cardOsPcaService.regCardOsPca(detail.getForm(formBase));
                    }
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{req.getMemberId()});
    }

}
