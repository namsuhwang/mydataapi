package com.albee.mydataapi.api.common.gateway.models.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;

@Data
@ToString
@NoArgsConstructor
//@AllArgsConstructor
public class ApiCallParamsDto {
//    private String orgCode;
//    private Long searchTimeStamp;
//    private String nextPage;
//    private Integer limit;
    protected HashMap<String, Object> paramsMap = new HashMap<>();

    public ApiCallParamsDto(HashMap<String, Object> baseParamsMap){
//        this.orgCode = (String) baseParamsMap.get("org_code");
//        this.searchTimeStamp = (Long) baseParamsMap.get("search_time_stamp");
//        this.nextPage = (String) baseParamsMap.get("next_page");
//        this.limit = 500;
        this.paramsMap.put("org_code", baseParamsMap.get("org_code"));
    }

    public ApiCallParamsDto(String memberId, String orgCode) {
        this.paramsMap.put("member_id", memberId);
        this.paramsMap.put("org_code", orgCode);
    }

    public String getParamJson(){
        String paramJson;
        try {
            paramJson = new ObjectMapper().writeValueAsString(paramsMap);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return paramJson;
    }

}
