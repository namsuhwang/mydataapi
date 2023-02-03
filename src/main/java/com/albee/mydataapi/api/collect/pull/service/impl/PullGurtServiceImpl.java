package com.albee.mydataapi.api.collect.pull.service.impl;

import com.albee.mydataapi.api.base.gurt.models.*;
import com.albee.mydataapi.api.base.gurt.models.entity.*;
import com.albee.mydataapi.api.base.gurt.models.form.*;
import com.albee.mydataapi.api.base.gurt.service.*;
import com.albee.mydataapi.api.collect.pull.models.dto.GurtParamsDto;
import com.albee.mydataapi.api.collect.pull.service.PullGurtService;
import com.albee.mydataapi.api.common.api.models.entity.ApiMstEntity;
import com.albee.mydataapi.api.common.api.service.ApiMstService;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallResDto;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.models.res.gurt.*;
import com.albee.mydataapi.api.common.gateway.service.CallMyDataGatewayService;
import com.albee.mydataapi.api.common.recv.models.RecvBaselineSearch;
import com.albee.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import com.albee.mydataapi.api.common.recv.models.form.RecvStatusForm;
import com.albee.mydataapi.api.common.recv.service.RecvBaselineService;
import com.albee.mydataapi.api.common.recv.service.RecvStatusService;
import com.albee.mydataapi.common.CommUtil;
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
public class PullGurtServiceImpl implements PullGurtService {

    @Autowired
    ApiMstService apiMstService;
    @Autowired
    RecvStatusService recvStatusService;
    @Autowired
    RecvBaselineService recvBaselineService;
    @Autowired CallMyDataGatewayService callMyDataGatewayService;

    @Autowired
    GurtService gurtService;
    @Autowired
    GurtBaseService gurtBaseService;
    @Autowired
    GurtInsdService grutInsdService;
    @Autowired
    GurtHistService gurtHistService;

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> pullGurtInfoRun(ApiCallReqDto req, RecvStatusForm recvStatusForm) {
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

        CompletableFuture<List<String[]>> gurt001Result = callGurt001(req, formBase);
        gurt001Result.thenAccept(gurtList -> {
            for (String[] gurt : gurtList) {
                callGurt002(req, formBase, gurt[0]);
                callGurt003(req, formBase, gurt[0]);
            }
        });


        // 수신 상태 업데이트. 기관코드 + API 별로 종료 상태 저장.
        recvStatusForm.setRecvStatus("1");
        recvStatusForm.setRecvEndDt(CommUtil.getCurrentDateTime14());
        recvStatusService.updRecvStatus(recvStatusForm);
        return CompletableFuture.completedFuture(targetList);
    }


    // GURT. 보증보험 목록
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String[]>> callGurt001(ApiCallReqDto req, FormBase formBase) {
        req.setRequestApiId("GURT_001");

        List<String[]> gurtList = new ArrayList<>();

        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));
        String nextPage = baseline.getNextPage();

        // 입력 파라메터용 Map, Json 기본 설정
        GurtParamsDto gurtParamsDto = (GurtParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());


        while(true) {
            req.setReqParamJson(gurtParamsDto.getParamsGurt001(baseline.getSearchTimeStamp(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Gurt001ResDto.class, Gurt001ResDetailDto.class);
            Gurt001ResDto resDto = (Gurt001ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            // 목록은 해지목록을 알 수 없기 때문에 일단 전체 삭제 후 인서트
            gurtService.allDelGurt((GurtForm) formBase);

            if(CommUtil.isListNullEmpty(resDto.getList())){
                return CompletableFuture.completedFuture(gurtList);
            }

            for (Gurt001ResDetailDto detail : resDto.getList()) {
                gurtService.regGurt(detail.getForm(formBase));
                if(detail.getIsConsent()){
                    gurtList.add(new String[]{detail.getInsuNum()});
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(gurtList);
    }

    // GURT_BASE 보증보험 기본정보
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callGurt002(ApiCallReqDto req, FormBase formBase, String insuNum) {
        req.setRequestApiId("GURT_002");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        GurtBaseEntity lastHist = gurtBaseService.getGurtBase(new GurtBaseSearch(req.getMemberId(), req.getOrgCd(), insuNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        GurtParamsDto gurtParamsDto = (GurtParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(gurtParamsDto.getParamsGurt002(insuNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Gurt002ResDto.class);
        Gurt002ResDto resDto = (Gurt002ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        gurtBaseService.modGurtBase(resDto.getForm(formBase, insuNum));

        GurtInsdForm form = (GurtInsdForm) formBase;
        form.setInsuNum(insuNum);
        grutInsdService.allDelGurtInsd(form);

        if(CommUtil.isListNullEmpty(resDto.getList())){
            for(Gurt002ResDetailDto detail : resDto.getList()){
                grutInsdService.regGurtInsd(detail.getForm(formBase, insuNum));
            }
        }

        return CompletableFuture.completedFuture(new String[]{insuNum});
    }

    // GURT_HIST 보증보험 거래내역
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callGurt003(ApiCallReqDto req, FormBase formBase, String insuNum) {
        req.setRequestApiId("GURT_003");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        GurtHistEntity lastHist = gurtHistService.getGurtHistLast(new GurtHistSearch(req.getMemberId(), req.getOrgCd(), insuNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        GurtParamsDto gurtParamsDto = (GurtParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            req.setReqParamJson(gurtParamsDto.getParamsGurt003(insuNum, lastHist.getTransDate(), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Gurt003ResDto.class, Gurt003ResDetailDto.class);
            Gurt003ResDto resDto = (Gurt003ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if(CommUtil.isListNullEmpty(resDto.getList())){
                return CompletableFuture.completedFuture(new String[]{insuNum});
            }

            for (Gurt003ResDetailDto detail : resDto.getList()) {
                if(detail.getTransDate().equals(lastHist.getTransDate())){
                    gurtHistService.modGurtHist(detail.getForm(formBase, insuNum));
                }else {
                    gurtHistService.regGurtHist(detail.getForm(formBase, insuNum));
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

}
