package com.albee.mydataapi.api.collect.pull.service.impl;

import com.albee.mydataapi.api.base.bond.models.BondBalSearch;
import com.albee.mydataapi.api.base.bond.models.BondHistSearch;
import com.albee.mydataapi.api.base.bond.service.BondBalService;
import com.albee.mydataapi.api.base.bond.service.BondHistService;
import com.albee.mydataapi.api.base.bond.service.BondService;
import com.albee.mydataapi.api.collect.pull.models.dto.BondParamsDto;
import com.albee.mydataapi.api.common.gateway.models.res.bond.*;
import com.albee.mydataapi.api.common.recv.models.RecvBaselineSearch;
import com.albee.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import com.albee.mydataapi.api.common.recv.service.RecvBaselineService;
import com.albee.mydataapi.common.CommUtil;
import com.albee.mydataapi.api.base.bond.models.entity.BondBalEntity;
import com.albee.mydataapi.api.base.bond.models.entity.BondHistEntity;
import com.albee.mydataapi.api.base.bond.models.form.BondForm;
import com.albee.mydataapi.api.collect.pull.service.PullBondService;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallResDto;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
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
public class PullBondServiceImpl implements PullBondService {

    @Autowired
    RecvBaselineService recvBaselineService;
    @Autowired CallMyDataGatewayService callMyDataGatewayService;

    @Autowired
    BondService bondService;
    @Autowired
    BondBalService bondBalService;
    @Autowired
    BondHistService bondHistService;

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> pullBondInfoRun(ApiCallReqDto req, FormBase formBase) {
        List<String> targetList = new ArrayList<>();

        CompletableFuture<List<String>> bond001Result = callBond001(req, formBase);
        bond001Result.thenAccept(bondNumList -> {
            for(String bondNum : bondNumList){
                callBond002(req, formBase, bondNum);
                callBond003(req, formBase, bondNum);
            }
        });

        return CompletableFuture.completedFuture(targetList);
    }

    /*
        BOND_001 (BOND)  목록
     */
    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> callBond001(ApiCallReqDto req, FormBase formBase){
        req.setRequestApiId("BOND_001");

        List<String> bondNumList = new ArrayList<>();

        // 입력 파라메터용 Map, Json 기본 설정
        BondParamsDto bondParamsDto = (BondParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));

        req.setReqParamJson(bondParamsDto.getParamsBond001(baseline.getSearchTimeStamp(), baseline.getNextPage()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Bond001ResDto.class, Bond001ResDetailDto.class);
        Bond001ResDto resDto = (Bond001ResDto) resInfo.getData();

        // 해지건을 알 수 없기 때문에 일단 전체 삭제 후 인서트
        bondService.allDelBond((BondForm) formBase);

        formBase.setApiTranDay(req.getApiTranDay());
        formBase.setApiTranId(resDto.getXApiTranId());
        List<Bond001ResDetailDto> accountInfoList = resDto.getList();

        // 테이블 반영
        for(Bond001ResDetailDto detail : accountInfoList){
            bondService.regBond(detail.getForm(formBase));
            if(detail.getIsConsent()){
                bondNumList.add(detail.getBondNum());
            }
        }

        return CompletableFuture.completedFuture(bondNumList);
    }

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callBond002(ApiCallReqDto req, FormBase formBase, String bondNum) {
        req.setRequestApiId("BOND_002");

        // 일단 전체 삭제하려고 했으나 애매해서 우선 기존 계좌를 순서대로 호출하고 응답 내용이 없는 건(basic_cnt = 0)은 삭제하도록 함
        BondBalEntity entity = bondBalService.getBondBal(new BondBalSearch(req.getMemberId(), req.getOrgCd(), bondNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(entity);

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        BondParamsDto bondParamsDto = (BondParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(bondParamsDto.getParamsBond002(bondNum, baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Bond002ResDto.class);
        Bond002ResDto resDto = (Bond002ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());

        bondBalService.modBondBal(resDto.getForm(formBase, bondNum));

        return CompletableFuture.completedFuture(new String[]{bondNum});
    }

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<String[]> callBond003(ApiCallReqDto req, FormBase formBase, String bondNum) {
        req.setRequestApiId("BOND_003");
        BondHistEntity lastHist = bondHistService.getBondHistLast(new BondHistSearch(req.getMemberId(), req.getOrgCd(), bondNum));
        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(lastHist);
        String nextPage = baseline.getNextPage();

        // 요청 파라메터 기본값(회원ID, 조회 대상 기관코드) 설정한 기본 DTO 생성
        BondParamsDto bondParamsDto = (BondParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());

        while(true) {
            // from : 마지막 거래내역의 거래일자, to : 오늘 일자
            req.setReqParamJson(bondParamsDto.getParamsBond003(bondNum, lastHist.getTransDtime().substring(0, 8), CommUtil.getCurrentDate8(), nextPage));

            // 게이트웨이 call
            ApiCallResDto resInfo = callMyDataGatewayService.callRepeatMyDataApi(req, Bond003ResDto.class, Bond003ResDetailDto.class);
            Bond003ResDto resDto = (Bond003ResDto) resInfo.getData();
            formBase.setApiTranId(resDto.getXApiTranId());

            if (resDto.getListCnt() != null && resDto.getListCnt() > 0) {
                for (Bond003ResDetailDto detail : resDto.getList()) {
                    if(lastHist.getTransDtime().substring(0, 8).equals(detail.getTransDtime().substring(0, 8))) {
                        bondHistService.modBondHist(detail.getForm(formBase, bondNum));
                    }else{
                        bondHistService.regBondHist(detail.getForm(formBase, bondNum));
                    }
                }
            }

            if(CommUtil.isNullEmpty(resInfo.getNextPage())){
                break;
            }else{
                nextPage = resInfo.getNextPage();
            }
        }

        return CompletableFuture.completedFuture(new String[]{bondNum});
    }

}
