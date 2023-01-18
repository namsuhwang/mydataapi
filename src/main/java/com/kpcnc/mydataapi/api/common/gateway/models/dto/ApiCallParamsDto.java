package com.kpcnc.mydataapi.api.common.gateway.models.dto;

import com.kpcnc.mydataapi.api.common.member.models.member.entity.MemberTokenEntity;
import com.kpcnc.mydataapi.common.CommUtil;
import lombok.AllArgsConstructor;
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

}
