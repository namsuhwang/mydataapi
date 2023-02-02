package com.albee.mydataapi.api.collect.pull.service.impl;

import com.albee.mydataapi.api.common.recv.models.RecvBaselineSearch;
import com.albee.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import com.albee.mydataapi.api.common.recv.service.RecvBaselineService;
import com.albee.mydataapi.api.base.db.service.DbService;
import com.albee.mydataapi.api.collect.pull.models.dto.DbParamsDto;
import com.albee.mydataapi.api.collect.pull.service.PullDbService;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallResDto;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.models.res.db.Db001ResDto;
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
public class PullDbServiceImpl implements PullDbService {

    @Autowired
    RecvBaselineService recvBaselineService;
    @Autowired CallMyDataGatewayService callMyDataGatewayService;

    @Autowired
    DbService dbService;

    @Async("pullPersonalInfoExecutor")
    public CompletableFuture<List<String>> pullDbInfoRun(ApiCallReqDto req, FormBase formBase) {
        req.setRequestApiId("DB_001");
        List<String> targetList = new ArrayList<>();

        RecvBaselineEntity baseline = recvBaselineService.getRecvBaseline(new RecvBaselineSearch(req.getMemberId(), req.getOrgCd(), req.getRequestApiId()));

        // 입력 파라메터용 Map, Json 기본 설정
        DbParamsDto dbParamsDto = (DbParamsDto) new ApiCallParamsDto(req.getMemberId(), req.getOrgCd());
        req.setReqParamJson(dbParamsDto.getParamsDb001(baseline.getSearchTimeStamp()));

        // 게이트웨이 call
        ApiCallResDto resInfo = callMyDataGatewayService.callMyDataApi(req, Db001ResDto.class);
        Db001ResDto resDto = (Db001ResDto) resInfo.getData();
        formBase.setApiTranId(resDto.getXApiTranId());
        targetList.add(req.getOrgCd());

        dbService.modDb(resDto.getForm(formBase));

        return CompletableFuture.completedFuture(targetList);
    }

}
