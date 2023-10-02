package com.albee.mydataapi.api.collect.pull.service.impl;

import com.albee.mydataapi.api.base.invt.models.*;
import com.albee.mydataapi.api.base.invt.models.entity.*;
import com.albee.mydataapi.api.base.invt.models.form.InvtAccProdForm;
import com.albee.mydataapi.api.base.invt.service.*;
import com.albee.mydataapi.api.collect.pull.service.PullInvtService;
import com.albee.mydataapi.api.common.api.models.entity.ApiMstEntity;
import com.albee.mydataapi.api.common.api.service.ApiMstService;
import com.albee.mydataapi.api.common.gateway.models.res.invt.*;
import com.albee.mydataapi.api.common.recv.models.RecvBaselineSearch;
import com.albee.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import com.albee.mydataapi.api.common.recv.models.form.RecvStatusForm;
import com.albee.mydataapi.api.common.recv.service.RecvBaselineService;
import com.albee.mydataapi.api.common.recv.service.RecvStatusService;
import com.albee.mydataapi.common.CommUtil;
import com.albee.mydataapi.api.base.invt.models.form.InvtAccForm;
import com.albee.mydataapi.api.base.invt.models.form.InvtAutoTransForm;
import com.albee.mydataapi.api.collect.pull.models.dto.InvtParamsDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallResDto;
import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.service.CallMyDataGatewayService;
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
public class PullInvtServiceImpl implements PullInvtService {

    @Autowired
    ApiMstService apiMstService;
    @Autowired
    RecvStatusService recvStatusService;
    @Autowired
    RecvBaselineService recvBaselineService;
    @Autowired CallMyDataGatewayService callMyDataGatewayService;

    @Autowired
    InvtAccService invtAccService;
    @Autowired
    InvtAccBaseService invtAccBaseService;
    @Autowired
    InvtAccHistService invtAccHistService;
    @Autowired
    InvtAccProdBaseDateService invtAccProdBaseDateService;
    @Autowired InvtAccProdService invtAccProdService;
    @Autowired InvtAutoTransService invtAutoTransService;
    @Autowired
    InvtPensionAccAddService invtPensionAccAddService;

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> pullInvtInfoRun(ApiCallReqDto req, RecvStatusForm recvStatusForm) {
        List<String> targetList = new ArrayList<>();

        FormBase formBase = new FormBase(req.getMemberId(), req.getOrgCd());
        formBase.setApiTranDay(req.getApiTranDay());

        // 보유자산목록(*.list)을 조회하기 위한 API 정보
        ApiMstEntity assetListQryApiEntity = apiMstService.getApiListByScope(req.getMemberToken().getScopeLists().get(0)).get(0);
        req.setRequestApiId(assetListQryApiEntity.getApiId());
        req.setRequestUrl(assetListQryApiEntity.getApiUrlResource());

        // 수신 상태 업데이트. 기관코드 + API 별로 수신시작/종료 상태 저장.
        recvStatusService.updRecvStatus(recvStatusForm, 1, req.getOrgCd());

        CompletableFuture<List<String[]>> Invt001Result = callInvt001(req, formBase);
        Invt001Result.thenAccept(accList -> {
            for (String[] acc : accList) {
                if(acc[1].equals("105")){
                    callInvt005(req, formBase, acc[0]);
                    callInvt006(req, formBase, acc[0]);
                }else{
                    callInvt002(req, formBase, acc[0]);
                    callInvt003(req, formBase, acc[0]);
                    callInvt004(req, formBase, acc[0]);
                }
            }
        });

        // 수신 상태 업데이트. 기관코드 + API 별로 종료 상태 저장.
        recvStatusForm.setRecvStatus("1");
        recvStatusForm.setRecvEndDt(CommUtil.getCurrentDateTime14());
        recvStatusService.updRecvStatus(recvStatusForm);
        return CompletableFuture.completedFuture(targetList);
    }


    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String[]>> callInvt001(ApiCallReqDto req, FormBase formBase) {
        req.setRequestApiId("INVT_001");

        List<String[]> accList = new ArrayList<>();

        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));

        // 입력 파라메터용 Map, Json 기본 설정
        InvtParamsDto invtParamsDto = (InvtParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(invtParamsDto.getParamsInvt001(baseline.getSearchTimeStamp(), baseline.getNextPage()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Invt001ResDto.class, Invt001ResDetailDto.class);
        Invt001ResDto resDto = (Invt001ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        // 목록은 해지목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        invtAccService.allDelInvtAcc((InvtAccForm) formBase);

        if(CommUtil.isListNullEmpty(resDto.getList())){
            return CompletableFuture.completedFuture(accList);
        }

        for (Invt001ResDetailDto detail : resDto.getList()) {
            invtAccService.regInvtAcc(detail.getForm(formBase));
            if(detail.getIsConsent()){
                accList.add(new String[]{detail.getAccountNum(), detail.getAccountType()});
            }
        }

        return CompletableFuture.completedFuture(accList);
    }

    // INVT_ACC_BASE
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInvt002(ApiCallReqDto req, FormBase formBase, String accountNum) {
        req.setRequestApiId("INVT_002");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        InvtAccBaseEntity entity = invtAccBaseService.getInvtAccBase(new InvtAccBaseSearch(req.getMemberId(), req.getOrgCd(), accountNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InvtParamsDto invtParamsDto = (InvtParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(invtParamsDto.getParamsInvt002(accountNum,  baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Invt002ResDto.class);
        Invt002ResDto resDto = (Invt002ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        invtAccBaseService.modInvtAccBase(resDto.getForm(formBase, accountNum));

        return CompletableFuture.completedFuture(new String[]{accountNum});
    }

    // INVT_ACC_HIST
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInvt003(ApiCallReqDto req, FormBase formBase, String accountNum) {
        req.setRequestApiId("INVT_003");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        InvtAccHistEntity lastHist = invtAccHistService.getInvtAccHistLast(new InvtAccHistSearch(req.getMemberId(), req.getOrgCd(), accountNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InvtParamsDto invtParamsDto = (InvtParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            /*
            LocalDate fromLd = LocalDate.of(Integer.valueOf(lastHist.getTransDtime().substring(0, 3))
                    , Integer.valueOf(lastHist.getTransDtime().substring(3, 4)), Integer.valueOf(lastHist.getTransDtime().substring(4, 5))) ;
            LocalDate toLd = fromLd.plusDays(500);
            */
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(invtParamsDto.getParamsInvt003(accountNum, lastHist.getTransDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Invt003ResDto.class, Invt003ResDetailDto.class);
            Invt003ResDto resDto = (Invt003ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Invt003ResDetailDto detail : resDto.getList()) {
                    if(detail.getTransDtime().substring(0, 8).equals(lastHist.getTransDtime().substring(0, 8))){
                        invtAccHistService.modInvtAccHist(detail.getForm(formBase, accountNum));
                    }else {
                        invtAccHistService.regInvtAccHist(detail.getForm(formBase, accountNum));
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

    // INVT_ACC_PROD_BASE_DATE (금융투자 계좌 상품정보 기준 일자), INVT_ACC_PROD (금융투자 계좌 상품정보)
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInvt004(ApiCallReqDto req, FormBase formBase, String accountNum) {
        req.setRequestApiId("INVT_004");

        InvtAccProdBaseDateEntity entity = invtAccProdBaseDateService.getInvtAccProdBaseDate(new InvtAccProdBaseDateSearch(req.getMemberId(), req.getOrgCd(), accountNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InvtParamsDto invtParamsDto = (InvtParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        invtAccProdService.allDelInvtAccProd((InvtAccProdForm) formBase);

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(invtParamsDto.getParamsInvt004(accountNum, baseline.getSearchTimeStamp(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Invt004ResDto.class, Invt004ResDetailDto.class);
            Invt004ResDto resDto = (Invt004ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            invtAccProdBaseDateService.modInvtAccProdBaseDate(resDto.getForm(formBase, accountNum));

            if (!CommUtil.isListNullEmpty(resDto.getList())) {
                for (Invt004ResDetailDto detail : resDto.getList()) {
                    invtAccProdService.regInvtAccProd(detail.getForm(formBase, accountNum));
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

    // INVT_PENSION_ACC_ADD. 금융투자 연금계좌 추가정보
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInvt005(ApiCallReqDto req, FormBase formBase, String accountNum) {
        req.setRequestApiId("INVT_005");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        InvtPensionAccAddEntity entity = invtPensionAccAddService.getInvtPensionAccAdd(new InvtPensionAccAddSearch(req.getMemberId(), req.getOrgCd(), accountNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InvtParamsDto invtParamsDto = (InvtParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(invtParamsDto.getParamsInvt005(accountNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Invt005ResDto.class);
        Invt005ResDto resDto = (Invt005ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        invtPensionAccAddService.modInvtPensionAccAdd(resDto.getForm(formBase, accountNum));

        return CompletableFuture.completedFuture(new String[]{accountNum});
    }

    // INVT_AUTO_TRANS. 금융투자 계좌지정 자동이체 등록정보
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callInvt006(ApiCallReqDto req, FormBase formBase, String accountNum) {
        req.setRequestApiId("INVT_006");

        InvtAutoTransEntity lastHist = invtAutoTransService.getInvtAutoTransLast(new InvtAutoTransSearch(req.getMemberId(), req.getOrgCd(), accountNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        InvtParamsDto invtParamsDto = (InvtParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            req.setReqParamJson(invtParamsDto.getParamsInvt006(accountNum, baseline.getSearchTimeStamp(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Invt006ResDto.class, Invt006ResDetailDto.class);
            Invt006ResDto resDto = (Invt006ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            InvtAutoTransForm form = (InvtAutoTransForm) formBase;
            form.setAccountNum(accountNum);
            invtAutoTransService.allDelInvtAutoTrans(form);

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Invt006ResDetailDto detail : resDto.getList()) {
                    invtAutoTransService.regInvtAutoTrans(detail.getForm(formBase, accountNum));
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


}
