package com.albee.mydataapi.api.common.gateway.service.impl;

import com.albee.mydataapi.api.common.recv.models.form.RecvBaselineForm;
import com.albee.mydataapi.api.common.recv.models.form.RecvHistBaseForm;
import com.albee.mydataapi.api.common.recv.service.RecvBaselineService;
import com.albee.mydataapi.api.common.recv.service.RecvHistBaseService;
import com.albee.mydataapi.api.common.recv.service.RecvHistDetailService;
import com.albee.mydataapi.api.common.recv.service.RequestBankParamsSetService;
import com.albee.mydataapi.common.CommUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallResDto;
import com.albee.mydataapi.api.common.gateway.models.res.ResBaseListDto;
import com.albee.mydataapi.api.common.gateway.service.CallMyDataGatewayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class CallMyDataGatewayServiceImpl implements CallMyDataGatewayService {
    @Autowired
    RecvHistBaseService recvHistBaseService;

    @Autowired
    RecvHistDetailService recvHistDetailService;

    @Autowired
    RecvBaselineService recvBaselineService;

    @Autowired
    RequestBankParamsSetService reqBankParamsSetService;

    /*
        in : ApiCallRequestInfo
        out : ApiCallResponseInfo
     */
    @Override
    public <T> ApiCallResDto callMyDataApi(ApiCallReqDto reqInfo, T classType) {
        log.info("callMyDataApi in_params:" + reqInfo);
        ApiCallResDto<T> resInfo = new ApiCallResDto<T>();

        /*
            API 게이트웨이 호출.
            나중에 게이트웨이 솔루션업체와 협의하여 마저 코딩.
         */

        /*
        String resJson = "{\n" +
                "    \"x-api-tran-id\":\"X1111\",\n" +
                "    \"rsp_code\":\"00000\",\n" +
                "    \"rsp_msg\":\"SUCCESS\",\n" +
                "    \"search_timestamp\":11111111,\n" +
                "    \"reg_date\":\"20190101\",\n" +
                "    \"next_page\":\"\",\n" +
                "    \"account_cnt\":2,\n" +
                "    \"account_list\":[\n" +
                "        {\n" +
                "            \"account_num\":\"11111101111111\",\n" +
                "            \"is_consent\":true,\n" +
                "            \"seqno\":\"\",\n" +
                "            \"is_foreign_deposit\":false,\n" +
                "            \"prod_name\":\"수신계좌1\",\n" +
                "            \"is_minus\":false,\n" +
                "            \"account_type\":\"1002\",\n" +
                "            \"account_status\":\"01\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"account_num\":\"1111110222222\",\n" +
                "            \"is_consent\":true,\n" +
                "            \"seqno\":\"\",\n" +
                "            \"is_foreign_deposit\":false,\n" +
                "            \"prod_name\":\"수신계좌2\",\n" +
                "            \"is_minus\":true,\n" +
                "            \"account_type\":\"1001\",\n" +
                "            \"account_status\":\"01\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
         */

        // 수신 이력 기본 정보 생성
        RecvHistBaseForm recvHistBaseForm = new RecvHistBaseForm(reqInfo.getMemberId(), reqInfo.getOrgCd(), reqInfo.getRequestApiId(), reqInfo.getRecvSeq());
        recvHistBaseService.regRecvHistBase(recvHistBaseForm);

        Object resultData = null;
        try {
            resultData = new ObjectMapper().readValue(resInfo.getResultJson(), classType.getClass());
            // resultData = new ObjectMapper().readValue(resInfo.getResultJson(), Class.forName("com.albee.mydataapi.api.common.gateway.models.in" + reqInfo.getRequestApiId() + "InDto"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        resInfo.setData((T)resultData);
        // res.setSearchTimeStamp(); resJson 에서 search_time_stamp 추출하여 설정해야 하나 임시로 현재시간으로 설정
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        resInfo.setSearchTimeStamp(Long.valueOf(timestamp.toString()));

        // 수신 베이스라인 설정
        RecvBaselineForm recvBaselineForm = new RecvBaselineForm(reqInfo.getMemberId(), reqInfo.getOrgCd(), reqInfo.getRequestApiId());
        recvBaselineForm.setApiTranDay(reqInfo.getApiTranDay());
        recvBaselineForm.setApiTranId(resInfo.getApiTranId());
        recvBaselineForm.setSearchTimeStamp(resInfo.getSearchTimeStamp());
        recvBaselineForm.setLastRecvDt(CommUtil.getCurrentDateTime14());
        recvBaselineService.regRecvBaseline(recvBaselineForm);

        // BANK_001 에 대한 수신 처리 완료 설정
        recvHistBaseForm.setRecvEndDt(CommUtil.getCurrentDateTime14());
        recvHistBaseService.updRecvHistBase(recvHistBaseForm);

        // 수신한 내용을 먼저 RECV_HIST_DETAIL 인서트
        recvHistDetailService.regRecvHistDetail(
                new RecvHistBaseForm(reqInfo.getMemberId(), reqInfo.getOrgCd(), reqInfo.getRequestApiId(), reqInfo.getRecvSeq()), resInfo.getResultJson());
        return resInfo;
    }


    /*
        in : ApiCallRequestInfo
        out : ApiCallResponseInfo
     */
    @Override
    public <T, D> ApiCallResDto callRepeatMyDataApi(ApiCallReqDto reqInfo, T classTypeT, D classTypeD) {
        log.info("callRepeatMyDataApi in_params:" + reqInfo);

        ApiCallResDto<T> resInfo = new ApiCallResDto<T>();
        List<D> resDetailList = new ArrayList<>();

        /*
            API 게이트웨이 호출.
            나중에 게이트웨이 솔루션업체와 협의하여 마저 코딩.
         */

        /*
        String resJson = "{\n" +
                "    \"x-api-tran-id\":\"X1111\",\n" +
                "    \"rsp_code\":\"00000\",\n" +
                "    \"rsp_msg\":\"SUCCESS\",\n" +
                "    \"search_timestamp\":11111111,\n" +
                "    \"reg_date\":\"20190101\",\n" +
                "    \"next_page\":\"\",\n" +
                "    \"account_cnt\":2,\n" +
                "    \"account_list\":[\n" +
                "        {\n" +
                "            \"account_num\":\"11111101111111\",\n" +
                "            \"is_consent\":true,\n" +
                "            \"seqno\":\"\",\n" +
                "            \"is_foreign_deposit\":false,\n" +
                "            \"prod_name\":\"수신계좌1\",\n" +
                "            \"is_minus\":false,\n" +
                "            \"account_type\":\"1002\",\n" +
                "            \"account_status\":\"01\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"account_num\":\"1111110222222\",\n" +
                "            \"is_consent\":true,\n" +
                "            \"seqno\":\"\",\n" +
                "            \"is_foreign_deposit\":false,\n" +
                "            \"prod_name\":\"수신계좌2\",\n" +
                "            \"is_minus\":true,\n" +
                "            \"account_type\":\"1001\",\n" +
                "            \"account_status\":\"01\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
         */
        HashMap<String, Object> reqParamMap = reqInfo.getReqParamMap();
        Object resultData = null;

        // 수신 이력 기본 정보 생성
        RecvHistBaseForm recvHistBaseForm = new RecvHistBaseForm(reqInfo.getMemberId(), reqInfo.getOrgCd(), reqInfo.getRequestApiId(), reqInfo.getRecvSeq());
        recvHistBaseService.regRecvHistBase(recvHistBaseForm);

        // T resBaseDto = null;
        ResBaseListDto resBaseListDto;

        while(true) {
            try {
                resultData = new ObjectMapper().readValue(resInfo.getResultJson(), classTypeT.getClass());
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            // 넥스트테이지가 없으면 stop
            // ResBaseListDto resBaseListDto = (ResBaseListDto<T, D>)resultData;
//            resBaseDto = (T)resultData;
            resBaseListDto = (ResBaseListDto)(T)resultData;
            if(CommUtil.isNullEmpty((resBaseListDto.getNextPage()))){
                break;
            }

            // 다음 연속 조회를 위한 타임스탬프, 넥스트페이지 세팅
            reqParamMap.put("search_timestamp", resBaseListDto.getSearchTimestamp());
            reqParamMap.put("next_page", resBaseListDto.getNextPage());

            // resInfo.setData((T) resBaseListDto);

            List<D> list = resBaseListDto.getList();
            for(D detailInfo : list){
                resDetailList.add(detailInfo);
            }

            // 수신 베이스라인 설정
            RecvBaselineForm recvBaselineForm = new RecvBaselineForm(reqInfo.getMemberId(), reqInfo.getOrgCd(), reqInfo.getRequestApiId());
            recvBaselineForm.setApiTranDay(reqInfo.getApiTranDay());
            recvBaselineForm.setApiTranId(resInfo.getApiTranId());
            recvBaselineForm.setSearchTimeStamp(resInfo.getSearchTimeStamp());
            recvBaselineForm.setLastRecvDt(CommUtil.getCurrentDateTime14());
            recvBaselineService.regRecvBaseline(recvBaselineForm);

            // 수신한 내용을 먼저 RECV_HIST_DETAIL 인서트
            recvHistDetailService.regRecvHistDetail(
                    new RecvHistBaseForm(reqInfo.getMemberId(), reqInfo.getOrgCd(), reqInfo.getRequestApiId(), reqInfo.getRecvSeq()), resInfo.getResultJson());
        }

        // 수신 이력 기본 정보 업데이트(종료일시)
        recvHistBaseForm.setRecvEndDt(CommUtil.getCurrentDateTime14());
        recvHistBaseService.updRecvHistBase(recvHistBaseForm);

        ((ResBaseListDto<D>) resultData).setList(resDetailList);
        resInfo.setData((T)resultData);
        return resInfo;
    }



}
