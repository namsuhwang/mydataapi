package com.kpcnc.mydataapi.api.common.gateway.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallRequestInfoDto;
import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallResponseInfoDto;
import com.kpcnc.mydataapi.api.common.gateway.service.CallMyDataGatewayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class CallMyDataGatewayServiceImpl implements CallMyDataGatewayService {

    /*
        in : ApiCallRequestInfo
        out : ApiCallResponseInfo
     */
    @Override
    public ApiCallResponseInfoDto callMyDataApi(ApiCallRequestInfoDto dom) {
        log.info("callMyDataApi in_params:" + dom);
        ApiCallResponseInfoDto res = new ApiCallResponseInfoDto();

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

        Object resultData = null;
        try {
            resultData = new ObjectMapper().readValue(res.getResultJson(), Class.forName("com.kpcnc.mydataapi.api.common.gateway.models.in" + dom.getRequestApiId() + "InDto"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        res.setData(resultData);
        // res.setSearchTimeStamp(); resJson 에서 search_time_stamp 추출하여 설정해야 하나 임시로 현재시간으로 설정
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        res.setSearchTimeStamp(Long.valueOf(timestamp.toString()));

        // res.setNextPage(""); next_page도 설정해야 함

        return res;
    }
}
