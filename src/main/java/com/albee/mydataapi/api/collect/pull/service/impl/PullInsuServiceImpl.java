package com.albee.mydataapi.api.collect.pull.service.impl;

import com.albee.mydataapi.api.base.insu.models.*;
import com.albee.mydataapi.api.base.insu.models.entity.*;
import com.albee.mydataapi.api.base.insu.models.form.*;
import com.albee.mydataapi.api.base.insu.service.*;
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
import com.albee.mydataapi.api.collect.pull.models.dto.InsuParamsDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallResDto;
import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.service.CallMyDataGatewayService;
import com.albee.mydataapi.api.common.recv.models.form.RecvStatusForm;
import com.albee.mydataapi.api.common.recv.service.RecvStatusService;
import com.albee.mydataapi.api.common.gateway.models.res.insu.*;
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
public class PullInsuServiceImpl implements PullInsuService {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberTokenService memberTokenService;
    @Autowired
    ApiMstService apiMstService;
    @Autowired
    RecvBaselineService recvBaselineService;
    @Autowired CallMyDataGatewayService callMyDataGatewayService;

    @Autowired
    InsuBaseInsdService insuBaseInsdService ;
    @Autowired InsuBaseService insuBaseService ;
    @Autowired InsuCarHistService insuCarHistService;
    @Autowired InsuCarService insuCarService;
    @Autowired InsuGurtService insuGurtService ;
    @Autowired InsuHistService insuHistService ;
    @Autowired InsuInsdBaseService insuInsdBaseService;
    @Autowired
    InsuInsdCarService insuInsdCarService;
    @Autowired InsuInsdGurtService insuInsdGurtService;
    @Autowired InsuInsdMiBasePpService insuInsdMiBasePpService;
    @Autowired InsuInsdMiBaseService insuInsdMiBaseService;
    @Autowired InsuInsdMiSccontService insuInsdMiSccontService;
    @Autowired InsuInsdMiService insuInsdMiService;
    @Autowired InsuInsdSccontService insuInsdSccontService;
    @Autowired InsuInsdService insuInsdService;
    @Autowired InsuLoanAddService insuLoanAddService;
    @Autowired InsuLoanBaseService insuLoanBaseService;
    @Autowired InsuLoanHistIntService insuLoanHistIntService;
    @Autowired InsuLoanHistService insuLoanHistService;
    @Autowired
    InsuLoanService insuLoanService;
    @Autowired
    InsuMiBasePpService insuMiBasePpService;
    @Autowired InsuMiBaseService insuMiBaseService;
    @Autowired InsuMiHistService insuMiHistService;
    @Autowired InsuMiPayService insuMiPayService;
    @Autowired InsuMiSccontService insuMiSccontService;
    @Autowired InsuMiService insuMiService;
    @Autowired InsuPayService insuPayService;
    @Autowired
    InsuSccontService insuSccontService;
    @Autowired InsuService insuService;

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
    public CompletableFuture<List<String>> pullInsuInfoRun(ApiCallReqDto req, RecvStatusForm recvStatusForm) {
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

        // insu.insurance
        if(req.getMemberToken().getScopeLists().contains("insu.insurance")){    // 보험목록
            CompletableFuture<List<String[]>> insu001Result = callInsu001(req, formBase);
            insu001Result.thenAccept(insuList -> {
                for (String[] insu : insuList) {
                    if((Integer.valueOf(insu[1]) > 1 && Integer.valueOf(insu[1]) <= 22) || (Integer.valueOf(insu[1]) == 99)){
                        CompletableFuture<List<String[]>> insu002Result = callInsu002(req, formBase, insu[0]);  // 보험 기본정보
                        insu002Result.thenAccept(insuredList -> {
                            for (String[] insured : insuredList) {
                                callInsu003(req, formBase, insured[0], insured[1]);  // 보험 특약정보
                            }
                        });
                        callInsu005(req, formBase, insu[0]);  // 보험 납입 정보
                        callInsu006(req, formBase, insu[0]);  // 보험 거래내역
                        callInsu012(req, formBase, insu[0]);  // 보험 보장 정보
                    }else if(Integer.valueOf(insu[1]) == 17){
                        CompletableFuture<List<String[]>> insu004Result = callInsu004(req, formBase, insu[0]);  // 자동차보험 정보
                        insu004Result.thenAccept(carList -> {
                            for (String[] car : carList) {
                                callInsu007(req, formBase, car[0], car[1]);  // 자동차보험 거래내역
                            }
                        });
                    }else{
                        CompletableFuture<List<String[]>> insu018Result = callInsu018(req, formBase, insu[0]);  // 물, 일반보험 기본정보
                        insu018Result.thenAccept(insuredList -> {
                            for (String[] insured : insuredList) {
                                callInsu019(req, formBase, insured[0], insured[1]);  // 물, 일반보험 특약정보
                            }
                        });
                        callInsu020(req, formBase, insu[0]);  // 물, 일반보험 납입정보
                        callInsu021(req, formBase, insu[0]);  // 물, 일반보험 거래내역
                        callInsu024(req, formBase, insu[0]);  // 물, 일반보험 보장정보
                    }
                }
            });

            // insu.loan
            if(req.getMemberToken().getScopeLists().contains("insu.loan")) {
                CompletableFuture<List<String>> insu008Result = callInsu008(req, formBase);
                insu008Result.thenAccept(loanList -> {
                    for (String accountNum : loanList) {
                        callInsu009(req, formBase, accountNum);  // 대출상품 기본정보
                        callInsu010(req, formBase, accountNum);  // 대출상품 추가정보
                        callInsu011(req, formBase, accountNum);  // 대출상품 거래내역
                    }
                });
            }

            // insu.insured
            if(req.getMemberToken().getScopeLists().contains("insu.insured")) {    //
                CompletableFuture<List<String[]>> insu013Result = callInsu013(req, formBase);
                insu013Result.thenAccept(insuredInsuList -> {
                    for (String[] insu : insuredInsuList) {
                        if ((Integer.valueOf(insu[1]) > 1 && Integer.valueOf(insu[1]) <= 22) || (Integer.valueOf(insu[1]) == 99)) {
                            callInsu014(req, formBase, insu[0]);  // 피보험자 보험 기본정보
                            // CompletableFuture<List<String[]>> insu015Result = callInsu015(req, formBase, insu[0]);  // 피보험자 보험 특약 정보
                            callInsu015(req, formBase, insu[0]);  // 피보험자 보험 특약 정보
                            callInsu017(req, formBase, insu[0]);  // 피보험자 보험 보장정보
                        } else if (Integer.valueOf(insu[1]) == 17) {
                            callInsu016(req, formBase, insu[0]);  // 피보험자 자동차보험 정보
                        } else {
                            CompletableFuture<List<String[]>> insu022Result = callInsu022(req, formBase, insu[0]);  // 피보험자 물, 일반보험 기본정보
                            insu022Result.thenAccept(insdMiList -> {
                                for (String[] insdMi : insdMiList) {
                                    callInsu023(req, formBase, insdMi[0], insdMi[1]);  // 피보험자 물, 일반보험 특약정보
                                }
                            });
                            callInsu025(req, formBase, insu[0]);  // 피보험자 물, 일반 보장정보
                        }
                    }
                });
            }
        }

        if(req.getMemberToken().getScopeLists().contains("insu.irp")){
            pullIrpService.pullIrpInfoRun(req, formBase);
        }

        if(req.getMemberToken().getScopeLists().contains("insu.db")){
            pullDbService.pullDbInfoRun(req, formBase);
        }

        if(req.getMemberToken().getScopeLists().contains("insu.dc")){
            pullDcService.pullDcInfoRun(req, formBase);
        }

        // 수신 상태 업데이트. 기관코드 + API 별로 종료 상태 저장.
        recvStatusForm.setRecvStatus("1");
        recvStatusForm.setRecvEndDt(CommUtil.getCurrentDateTime14());
        recvStatusService.updRecvStatus(recvStatusForm);
        return CompletableFuture.completedFuture(targetList);
    }

    /*
        INSU_001 (INSU) 보험 목록
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String[]>> callInsu001(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("INSU_001");

        List<String[]> insuList = new ArrayList<>();

        // 입력 파라메터용 Map, Json 기본 설정
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        // InsuEntity entity = insuService.getInsuLast(new InsuSearch(req.getMemberId(), req.getOrgCd()));
        // RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // memberId, orgCd, apiId 만으로 찾을 수 있는 경우 **last 호출하지 않고 baseline 호출
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));

        req.setReqParamJson(insuParamsDto.getParamsInsu001(baseline.getSearchTimeStamp(), baseline.getNextPage()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu001ResDto.class, Insu001ResDetailDto.class);
        Insu001ResDto resDto = (Insu001ResDto) resInfo.getData();

        // 보험목록은 해지목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        insuService.allDelInsu((InsuForm) formBase);

        formBase.setApiTranId(resDto.getXApiTranId());
        List<Insu001ResDetailDto> insuInfoList = resDto.getList();

        // 테이블 반영
        for(Insu001ResDetailDto detail : insuInfoList){
            insuService.regInsu(detail.getForm(formBase));
            if(detail.getIsConsent() && !insuList.contains(detail.getInsuNum())){
                insuList.add(new String[]{detail.getInsuNum(), detail.getInsuType()});
            }
        }

        return CompletableFuture.completedFuture(insuList);
    }


    /*
        INSU_002 (INSU_BASE) 보함 기본정보, (INSU_BASE_INSD) 보함 기본정보 피보험자 목록
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String[]>> callInsu002(ApiCallReqDto req, FormBase formBase, String insuNum){
        req.setRequestApiId("INSU_002");

        List<String[]> insdList = new ArrayList<>();

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        InsuBaseEntity entity = insuBaseService.getInsuBase(new InsuBaseSearch(req.getMemberId(), req.getOrgCd(), insuNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(insuParamsDto.getParamsInsu002(insuNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu002ResDto.class, Insu002ResDetailDto.class);
        Insu002ResDto resDto = (Insu002ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        // 기본정보 업데이트
        insuBaseService.modInsuBase(resDto.getForm(formBase));

        // 보험목록은 해지목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        InsuBaseInsdForm form = (InsuBaseInsdForm) formBase;
        form.setInsuNum(insuNum);
        insuBaseInsdService.allDelInsuBaseInsd(form);

        if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
            for (Insu002ResDetailDto detail : resDto.getList()) {
                insuBaseInsdService.regInsuBaseInsd(detail.getForm(formBase, insuNum));
                insdList.add(new String[]{insuNum, detail.getInsuredNo()});
            }
        }

        return CompletableFuture.completedFuture(insdList);
    }


    /*
        INSU_003 (INSU_SCCONT) 보험 특약정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInsu003(ApiCallReqDto req, FormBase formBase, String insuNum, String insuredNo){
        req.setRequestApiId("INSU_003");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        InsuSccontEntity entity = insuSccontService.getInsuSccontLast(new InsuSccontSearch(req.getMemberId(), req.getOrgCd(), insuNum, insuredNo));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(insuParamsDto.getParamsInsu003(insuNum, insuredNo, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu003ResDto.class, Insu003ResDetailDto.class);
        Insu003ResDto resDto = (Insu003ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        // 없어진 특약을 모르므로 일단 전체 삭제 후 인서트
        InsuSccontForm form = (InsuSccontForm) formBase;
        form.setInsuNum(insuNum);
        form.setInsuredNo(insuredNo);
        insuSccontService.allDelInsuSccont(form);

        if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
            for (Insu003ResDetailDto detail : resDto.getList()) {
                insuSccontService.regInsuSccont(detail.getForm(formBase, insuNum, insuredNo));
            }
        }
        return CompletableFuture.completedFuture(new String[]{insuNum, insuredNo});
    }



    /*
        INSU_004 (INSU_CAR) 자동차보험 정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String[]>> callInsu004(ApiCallReqDto req, FormBase formBase, String insuNum){
        req.setRequestApiId("INSU_004");

        List<String[]> insuCarList = new ArrayList<>();

        InsuCarEntity entity = insuCarService.getInsuCarLast(new InsuCarSearch(req.getMemberId(), req.getOrgCd(), insuNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(insuParamsDto.getParamsInsu004(insuNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu004ResDto.class, Insu004ResDetailDto.class);
        Insu004ResDto resDto = (Insu004ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        // 일단 전체 삭제 후 인서트
        InsuCarForm form = (InsuCarForm) formBase;
        form.setInsuNum(insuNum);
        insuCarService.allDelInsuCar(form);

        if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
            for (Insu004ResDetailDto detail : resDto.getList()) {
                insuCarService.regInsuCar(detail.getForm(formBase, insuNum));
                insuCarList.add(new String[]{insuNum, detail.getCarNumber()});
            }
        }
        return CompletableFuture.completedFuture(insuCarList);
    }



    /*
        INSU_005 (INSU_PAY) 보험 납입정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInsu005(ApiCallReqDto req, FormBase formBase, String insuNum){
        req.setRequestApiId("INSU_005");

        InsuPayEntity entity = insuPayService.getInsuPay(new InsuPaySearch(req.getMemberId(), req.getOrgCd(), insuNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(insuParamsDto.getParamsInsu005(insuNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Insu005ResDto.class);
        Insu005ResDto resDto = (Insu005ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        insuPayService.modInsuPay(resDto.getForm(formBase, insuNum));

        return CompletableFuture.completedFuture(new String[]{insuNum});
    }


    /*
        INSU_006 (CARD_PAY) 카드 결제정보, (CARD_PAY_DETAIL) 카드 결제정보 상세
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInsu006(ApiCallReqDto req, FormBase formBase, String insuNum){
        req.setRequestApiId("INSU_006");

        InsuHistEntity lastHist = insuHistService.getInsuHistLast(new InsuHistSearch(req.getMemberId(), req.getOrgCd(), insuNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(insuParamsDto.getParamsInsu006(insuNum, lastHist.getTransDate(), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu006ResDto.class, Insu006ResDetailDto.class);
            Insu006ResDto resDto = (Insu006ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (!CommUtil.isListNullEmpty(resDto.getList())) {
                for (Insu006ResDetailDto detail : resDto.getList()) {
                    if(detail.getTransDate().equals(lastHist.getTransDate())){
                        insuHistService.modInsuHist(detail.getForm(formBase, insuNum));
                    }else{
                        insuHistService.regInsuHist(detail.getForm(formBase, insuNum));
                    }
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{insuNum});
    }



    /*
        INSU_007 (INSU_CAR_HIST) 자동차보험 거래내역
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInsu007(ApiCallReqDto req, FormBase formBase, String insuNum, String carNumber){
        req.setRequestApiId("INSU_007");

        InsuCarHistEntity lastHist = insuCarHistService.getInsuCarHistLast(new InsuCarHistSearch(req.getMemberId(), req.getOrgCd(), insuNum, carNumber));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(insuParamsDto.getParamsInsu007(insuNum, carNumber, lastHist.getTransDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu007ResDto.class, Insu007ResDetailDto.class);
            Insu007ResDto resDto = (Insu007ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (!CommUtil.isListNullEmpty(resDto.getList())) {
                for (Insu007ResDetailDto detail : resDto.getList()) {
                    if(detail.getTransDtime().substring(0, 8).equals(lastHist.getTransDtime().substring(0, 8))){
                        insuCarHistService.modInsuCarHist(detail.getForm(formBase, insuNum, carNumber));
                    }else{
                        insuCarHistService.regInsuCarHist(detail.getForm(formBase, insuNum, carNumber));
                    }
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{insuNum});
    }


    /*
        INSU_008 (INSU_LOAN) 대출상품 목록
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> callInsu008(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("INSU_008");

        List<String> loanList = new ArrayList<>();

        // 입력 파라메터용 Map, Json 기본 설정
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        // InsuLoanEntity entity = insuLoanService.getInsuLoan(new InsuLoanSearch(req.getMemberId(), req.getOrgCd()));
        // RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // memberId, orgCd, apiId 만으로 찾을 수 있는 경우 **last 호출하지 않고 baseline 호출
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));

        req.setReqParamJson(insuParamsDto.getParamsInsu001(baseline.getSearchTimeStamp(), baseline.getNextPage()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu008ResDto.class, Insu008ResDetailDto.class);
        Insu008ResDto resDto = (Insu008ResDto) resInfo.getData();

        // 보험목록은 해지목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        insuLoanService.allDelInsuLoan((InsuLoanForm) formBase);

        formBase.setApiTranId(resDto.getXApiTranId());
        List<Insu008ResDetailDto> insuInfoList = resDto.getList();

        // 테이블 반영
        for(Insu008ResDetailDto detail : insuInfoList){
            insuLoanService.regInsuLoan(detail.getForm(formBase));
            if(detail.getIsConsent() && !loanList.contains(detail.getAccountNum())){
                loanList.add(detail.getAccountNum());
            }
        }

        return CompletableFuture.completedFuture(loanList);
    }


    /*
        INSU_009 (INSU_LOAN_BASE) 대출상품 기본정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInsu009(ApiCallReqDto req, FormBase formBase, String accountNum){
        req.setRequestApiId("INSU_009");

        InsuLoanBaseEntity entity = insuLoanBaseService.getInsuLoanBase(new InsuLoanBaseSearch(req.getMemberId(), req.getOrgCd(), accountNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(insuParamsDto.getParamsInsu009(accountNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Insu009ResDto.class);
        Insu009ResDto resDto = (Insu009ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        insuLoanBaseService.modInsuLoanBase(resDto.getForm(formBase, accountNum));

        return CompletableFuture.completedFuture(new String[]{accountNum});
    }



    /*
        INSU_010 (INSU_LOAN_ADD) 대출상품 추가정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInsu010(ApiCallReqDto req, FormBase formBase, String accountNum){
        req.setRequestApiId("INSU_010");

        InsuLoanAddEntity entity = insuLoanAddService.getInsuLoanAdd(new InsuLoanAddSearch(req.getMemberId(), req.getOrgCd(), accountNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(insuParamsDto.getParamsInsu010(accountNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Insu010ResDto.class);
        Insu010ResDto resDto = (Insu010ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        insuLoanAddService.modInsuLoanAdd(resDto.getForm(formBase, accountNum));

        return CompletableFuture.completedFuture(new String[]{accountNum});
    }




    /*
        INSU_011 (INSU_LOAN_HIST) 대출상품 거래내역
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInsu011(ApiCallReqDto req, FormBase formBase, String accountNum){
        req.setRequestApiId("INSU_011");

        InsuLoanHistEntity lastHist = insuLoanHistService.getInsuLoanHistLast(new InsuLoanHistSearch(req.getMemberId(), req.getOrgCd(), accountNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(insuParamsDto.getParamsInsu011(accountNum, lastHist.getTransDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu011ResDto.class, Insu011ResDetailDto.class);
            Insu011ResDto resDto = (Insu011ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (!CommUtil.isListNullEmpty(resDto.getList())) {
                for (Insu011ResDetailDto detail : resDto.getList()) {
                    if(detail.getTransDtime().substring(0, 8).equals(lastHist.getTransDtime().substring(0, 8))){
                        insuLoanHistService.modInsuLoanHist(detail.getForm(formBase, accountNum));
                    }else{
                        insuLoanHistService.regInsuLoanHist(detail.getForm(formBase, accountNum));
                    }

                    // 이자 내역
                    if (!CommUtil.isListNullEmpty(detail.getList())) {
                        for (Insu011ResDetailIntDto detailInt : detail.getList()) {
                            insuLoanHistIntService.modInsuLoanHistInt(detailInt.getForm(formBase, accountNum, detail.getTransNo(), detail.getTransDtime()));
                        }
                    }
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{accountNum});
    }



    /*
        INSU_012 (INSU_GURT) 보험 보장정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInsu012(ApiCallReqDto req, FormBase formBase, String insuNum){
        req.setRequestApiId("INSU_012");

        // 입력 파라메터용 Map, Json 기본 설정
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        InsuGurtEntity entity = insuGurtService.getInsuGurtLast(new InsuGurtSearch(req.getMemberId(), req.getOrgCd(), insuNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        req.setReqParamJson(insuParamsDto.getParamsInsu012(insuNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu012ResDto.class, Insu012ResDetailDto.class);
        Insu012ResDto resDto = (Insu012ResDto) resInfo.getData();

        // 보험목록은 해지목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        InsuGurtForm form = (InsuGurtForm) formBase;
        form.setInsuNum(insuNum);
        insuGurtService.allDelInsuGurt(form);

        formBase.setApiTranId(resDto.getXApiTranId());
        List<Insu012ResDetailDto> insuGurtList = resDto.getList();

        // 테이블 반영
        for(Insu012ResDetailDto detail : insuGurtList){
            insuGurtService.regInsuGurt(detail.getForm(formBase, insuNum));
        }

        return CompletableFuture.completedFuture(new String[]{insuNum});
    }


    /*
        INSU_013 (INSU_INSD) 피보험자 보험 목록
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String[]>> callInsu013(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("INSU_013");

        List<String[]> insuList = new ArrayList<>();

        // 입력 파라메터용 Map, Json 기본 설정
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));

        req.setReqParamJson(insuParamsDto.getParamsInsu001(baseline.getSearchTimeStamp(), baseline.getNextPage()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu013ResDto.class, Insu013ResDetailDto.class);
        Insu013ResDto resDto = (Insu013ResDto) resInfo.getData();

        // 보험목록은 해지목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        insuService.allDelInsu((InsuForm) formBase);

        formBase.setApiTranId(resDto.getXApiTranId());
        List<Insu013ResDetailDto> insuInfoList = resDto.getList();

        // 테이블 반영
        for(Insu013ResDetailDto detail : insuInfoList){
            insuInsdService.regInsuInsd(detail.getForm(formBase));
            if(detail.getIsConsent() && !insuList.contains(detail.getInsuNum())){
                insuList.add(new String[]{detail.getInsuNum(), detail.getInsuType()});
            }
        }

        return CompletableFuture.completedFuture(insuList);
    }



    /*
        INSU_014 (INSU_INSD_BASE) 피보험자 보험 기본정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInsu014(ApiCallReqDto req, FormBase formBase, String insuNum){
        req.setRequestApiId("INSU_014");

        InsuInsdBaseEntity entity = insuInsdBaseService.getInsuInsdBase(new InsuInsdBaseSearch(req.getMemberId(), req.getOrgCd(), insuNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(insuParamsDto.getParamsInsu014(insuNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Insu014ResDto.class);
        Insu014ResDto resDto = (Insu014ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        insuInsdBaseService.modInsuInsdBase(resDto.getForm(formBase, insuNum));

        return CompletableFuture.completedFuture(new String[]{insuNum});
    }

    /*
        INSU_015 (INSU_INSD_SCCONT) 보험 피보험자 보험 특약 정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String[]>> callInsu015(ApiCallReqDto req, FormBase formBase, String insuNum){
        req.setRequestApiId("INSU_015");

        List<String[]> insuredInsdSccontList = new ArrayList<>();

        // 입력 파라메터용 Map, Json 기본 설정
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        InsuInsdSccontEntity entity = insuInsdSccontService.getInsuInsdSccontLast(new InsuInsdSccontSearch(req.getMemberId(), req.getOrgCd(), insuNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        req.setReqParamJson(insuParamsDto.getParamsInsu015(insuNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu015ResDto.class, Insu015ResDetailDto.class);
        Insu015ResDto resDto = (Insu015ResDto) resInfo.getData();

        // 보험목록은 해지목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        InsuForm form = (InsuForm) formBase;
        form.setInsuNum(insuNum);
        insuService.allDelInsu(form);

        formBase.setApiTranId(resDto.getXApiTranId());
        List<Insu015ResDetailDto> insuInfoList = resDto.getList();

        // 테이블 반영
        for(Insu015ResDetailDto detail : insuInfoList){
            insuInsdSccontService.regInsuInsdSccont(detail.getForm(formBase, insuNum));
            insuredInsdSccontList.add(new String[]{insuNum, detail.getContractName()});
        }

        return CompletableFuture.completedFuture(insuredInsdSccontList);
    }

    /*
        INSU_016 (INSU_INSD_CAR) 피보험자 자동차보험 정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInsu016(ApiCallReqDto req, FormBase formBase, String insuNum){
        req.setRequestApiId("INSU_016");

        // 입력 파라메터용 Map, Json 기본 설정
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        InsuInsdCarEntity entity = insuInsdCarService.getInsuInsdCarLast(new InsuInsdCarSearch(req.getMemberId(), req.getOrgCd(), insuNum));
        RecvBaselineEntity baseline = null;
        if(entity != null){
            baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(entity.getApiTranDay(), entity.getApiTranId()));
        }

        req.setReqParamJson(insuParamsDto.getParamsInsu016(insuNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu016ResDto.class, Insu016ResDetailDto.class);
        Insu016ResDto resDto = (Insu016ResDto) resInfo.getData();

        // 보험목록은 해지목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        InsuInsdCarForm form = (InsuInsdCarForm) formBase;
        form.setInsuNum(insuNum);
        insuInsdCarService.allDelInsuInsdCar(form);

        formBase.setApiTranId(resDto.getXApiTranId());
        List<Insu016ResDetailDto> insuInsdCarInfoList = resDto.getList();

        // 테이블 반영
        for(Insu016ResDetailDto detail : insuInsdCarInfoList){
            insuInsdCarService.regInsuInsdCar(detail.getForm(formBase, insuNum));
        }

        return CompletableFuture.completedFuture(new String[]{insuNum});
    }

    /*
        INSU_017 (INSU_INSD_GURT) 보험 피보험자 보험 보장정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInsu017(ApiCallReqDto req, FormBase formBase, String insuNum){
        req.setRequestApiId("INSU_017");

        // 입력 파라메터용 Map, Json 기본 설정
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        InsuInsdGurtEntity entity = insuInsdGurtService.getInsuInsdGurtLast(new InsuInsdGurtSearch(req.getMemberId(), req.getOrgCd(), insuNum));
        RecvBaselineEntity baseline = null;
        if(entity != null){
            baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(entity.getApiTranDay(), entity.getApiTranId()));
        }

        req.setReqParamJson(insuParamsDto.getParamsInsu017(insuNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu017ResDto.class, Insu017ResDetailDto.class);
        Insu017ResDto resDto = (Insu017ResDto) resInfo.getData();

        // 보험목록은 해지목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        InsuInsdCarForm form = (InsuInsdCarForm) formBase;
        form.setInsuNum(insuNum);
        insuInsdCarService.allDelInsuInsdCar(form);

        formBase.setApiTranId(resDto.getXApiTranId());
        List<Insu017ResDetailDto> insuInsdGurtInfoList = resDto.getList();

        // 테이블 반영
        for(Insu017ResDetailDto detail : insuInsdGurtInfoList){
            insuInsdGurtService.regInsuInsdGurt(detail.getForm(formBase, insuNum));
        }

        return CompletableFuture.completedFuture(new String[]{insuNum});
    }


    /*
        INSU_018 (INSU_MI_BASE) 물, 일반보험 기본정보, (INSU_MI_BASE_PP) 물, 일반보험 기본정보 목적물
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String[]>> callInsu018(ApiCallReqDto req, FormBase formBase, String insuNum){
        req.setRequestApiId("INSU_018");

        List<String[]> insuredList = new ArrayList<>();

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        InsuMiBaseEntity entity = insuMiBaseService.getInsuMiBase(new InsuMiBaseSearch(req.getMemberId(), req.getOrgCd(), insuNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(insuParamsDto.getParamsInsu002(insuNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu018ResDto.class, Insu018ResDetailDto.class);
        Insu018ResDto resDto = (Insu018ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        // 기본정보 업데이트
        insuMiBaseService.modInsuMiBase(resDto.getForm(formBase));

        // 보험목록은 해지목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        InsuMiBasePpForm form = (InsuMiBasePpForm) formBase;
        form.setInsuNum(insuNum);
        insuMiBasePpService.allDelInsuMiBasePp(form);

        if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
            for (Insu018ResDetailDto detail : resDto.getList()) {
                insuMiBasePpService.regInsuMiBasePp(detail.getForm(formBase, insuNum));
                insuredList.add(new String[]{insuNum, detail.getIsPerson() + detail.getPrizeNum()});
            }
        }

        return CompletableFuture.completedFuture(insuredList);
    }


    /*
        INSU_019 (INSU_MI_SCCONT) 보험 물, 일반보험 특약정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInsu019(ApiCallReqDto req, FormBase formBase, String insuNum, String insuredNo){
        req.setRequestApiId("INSU_019");

        // 입력 파라메터용 Map, Json 기본 설정
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        InsuMiSccontEntity entity = insuMiSccontService.getInsuMiSccontLast(new InsuMiSccontSearch(req.getMemberId(), req.getOrgCd(), insuNum, insuredNo));
        RecvBaselineEntity baseline = null;
        if(entity != null){
            baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(entity.getApiTranDay(), entity.getApiTranId()));
        }

        req.setReqParamJson(insuParamsDto.getParamsInsu017(insuNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu019ResDto.class, Insu019ResDetailDto.class);
        Insu019ResDto resDto = (Insu019ResDto) resInfo.getData();

        // 보험목록은 해지목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        InsuMiSccontForm form = (InsuMiSccontForm) formBase;
        form.setInsuNum(insuNum);
        form.setInsuredNo(insuredNo);
        insuMiSccontService.allDelInsuMiSccont(form);

        formBase.setApiTranId(resDto.getXApiTranId());
        List<Insu019ResDetailDto> insuMiSccontInfoList = resDto.getList();

        // 테이블 반영
        for(Insu019ResDetailDto detail : insuMiSccontInfoList){
            insuMiSccontService.regInsuMiSccont(detail.getForm(formBase, insuNum, insuredNo));
        }

        return CompletableFuture.completedFuture(new String[]{insuNum, insuredNo});
    }

    /*
        INSU_020 (INSU_MI_PAY) 물, 일반보험 납입정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInsu020(ApiCallReqDto req, FormBase formBase, String insuNum){
        req.setRequestApiId("INSU_020");

        InsuMiPayEntity entity = insuMiPayService.getInsuMiPay(new InsuMiPaySearch(req.getMemberId(), req.getOrgCd(), insuNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(insuParamsDto.getParamsInsu020(insuNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Insu020ResDto.class);
        Insu020ResDto resDto = (Insu020ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        insuMiPayService.modInsuMiPay(resDto.getForm(formBase, insuNum));

        return CompletableFuture.completedFuture(new String[]{insuNum});
    }

    /*
        INSU_022 (CARD_MI_HIST) 물, 일반보험 거래내역
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInsu021(ApiCallReqDto req, FormBase formBase, String insuNum){
        req.setRequestApiId("INSU_021");

        InsuMiHistEntity lastHist = insuMiHistService.getInsuMiHistLast(new InsuMiHistSearch(req.getMemberId(), req.getOrgCd(), insuNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(insuParamsDto.getParamsInsu021(insuNum, lastHist.getTransDate(), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu021ResDto.class, Insu021ResDetailDto.class);
            Insu021ResDto resDto = (Insu021ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (!CommUtil.isListNullEmpty(resDto.getList())) {
                for (Insu021ResDetailDto detail : resDto.getList()) {
                    if(detail.getTransDate().equals(lastHist.getTransDate())){
                        insuMiHistService.modInsuMiHist(detail.getForm(formBase, insuNum));
                    }else{
                        insuMiHistService.regInsuMiHist(detail.getForm(formBase, insuNum));
                    }
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{insuNum});
    }

    /*
        INSU_022 (INSU_INSD_MI_BASE) 피보험자 물, 일반보험 기본정보, (INSU_INSD_MI_BASE_PP) 피보험자 물, 일반보험 기본정보 목적물
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String[]>> callInsu022(ApiCallReqDto req, FormBase formBase, String insuNum){
        req.setRequestApiId("INSU_022");

        List<String[]> insdMiList = new ArrayList<>();

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        InsuInsdMiBaseEntity entity = insuInsdMiBaseService.getInsuInsdMiBase(new InsuInsdMiBaseSearch(req.getMemberId(), req.getOrgCd(), insuNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(insuParamsDto.getParamsInsu022(insuNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu022ResDto.class, Insu022ResDetailDto.class);
        Insu022ResDto resDto = (Insu022ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        // 기본정보 업데이트
        insuInsdMiBaseService.modInsuInsdMiBase(resDto.getForm(formBase));

        // 보험목록은 해지목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        InsuInsdMiBasePpForm form = (InsuInsdMiBasePpForm) formBase;
        form.setInsuNum(insuNum);
        insuInsdMiBasePpService.allDelInsuInsdMiBasePp(form);

        if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
            for (Insu022ResDetailDto detail : resDto.getList()) {
                insuInsdMiBasePpService.regInsuInsdMiBasePp(detail.getForm(formBase, insuNum));
                insdMiList.add(new String[]{insuNum, detail.getIsPerson() + detail.getPrizeNum()});
            }
        }

        return CompletableFuture.completedFuture(insdMiList);
    }

    /*
        INSU_023 (INSU_INSD_MI_SCCONT) 피보험자 물, 일반보험 특약정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInsu023(ApiCallReqDto req, FormBase formBase, String insuNum, String insuredNo){
        req.setRequestApiId("INSU_023");

        InsuInsdMiSccontEntity lastHist = insuInsdMiSccontService.getInsuInsdMiSccontLast(new InsuInsdMiSccontSearch(req.getMemberId(), req.getOrgCd(), insuNum, insuredNo));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        req.setReqParamJson(insuParamsDto.getParamsInsu023(insuNum, insuredNo, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu023ResDto.class, Insu023ResDetailDto.class);
        Insu023ResDto resDto = (Insu023ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        InsuInsdMiSccontForm form = (InsuInsdMiSccontForm) formBase;
        form.setInsuNum(insuNum);
        form.setInsuredNo(insuredNo);
        insuInsdMiSccontService.allDelInsuInsdMiSccont(form);

        if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
            for (Insu023ResDetailDto detail : resDto.getList()) {
                insuInsdMiSccontService.regInsuInsdMiSccont(detail.getForm(formBase, insuNum, insuredNo));
            }
        }

        return CompletableFuture.completedFuture(new String[]{insuNum, insuredNo});
    }

    /*
        INSU_024 (INSU_MI) 물, 일반 보장정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInsu024(ApiCallReqDto req, FormBase formBase, String insuNum){
        req.setRequestApiId("INSU_023");

        InsuMiEntity lastHist = insuMiService.getInsuMiLast(new InsuMiSearch(req.getMemberId(), req.getOrgCd(), insuNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(insuParamsDto.getParamsInsu024(insuNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu024ResDto.class, Insu024ResDetailDto.class);
        Insu024ResDto resDto = (Insu024ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        InsuMiForm form = (InsuMiForm) formBase;
        form.setInsuNum(insuNum);
        insuMiService.allDelInsuMi(form);

        if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
            for (Insu024ResDetailDto detail : resDto.getList()) {
                insuMiService.regInsuMi(detail.getForm(formBase, insuNum));
            }
        }

        return CompletableFuture.completedFuture(new String[]{insuNum});
    }

    /*
        INSU_025 (INSU_INSD_MI) 피보험자 물, 일반 보장정보
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInsu025(ApiCallReqDto req, FormBase formBase, String insuNum){
        req.setRequestApiId("INSU_025");

        InsuInsdMiEntity lastHist = insuInsdMiService.getInsuInsdMiLast(new InsuInsdMiSearch(req.getMemberId(), req.getOrgCd(), insuNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InsuParamsDto insuParamsDto = (InsuParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(insuParamsDto.getParamsInsu025(insuNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Insu025ResDto.class, Insu025ResDetailDto.class);
        Insu025ResDto resDto = (Insu025ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        InsuInsdMiForm form = (InsuInsdMiForm) formBase;
        form.setInsuNum(insuNum);
        insuInsdMiService.allDelInsuInsdMi(form);

        if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
            for (Insu025ResDetailDto detail : resDto.getList()) {
                insuInsdMiService.regInsuInsdMi(detail.getForm(formBase, insuNum));
            }
        }

        return CompletableFuture.completedFuture(new String[]{insuNum});
    }

}
