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
@AllArgsConstructor
public class ApiCallRequestInfoDto {
    private String memberId;    // 회원ID

    private String accessToken;  // 접근토큰
    private String refreshToken;  // 리프레쉬 토큰
    private String orgCd;
    private String memberCi;
    private String idstType;   // 업권유형 ( 예 : BANK)
    private String requestApiId;   // 호출 API ID (예 : BANK_001)
    private String requestUrl;   // 호출 API 의 resource url

    private String requestParameterJson;

    public ApiCallRequestInfoDto(MemberTokenEntity token) {
        this.memberId = memberId;
        this.idstType = CommUtil.getIdstTypeByScope(token.getScopeList().split(" ")[0]);
    }

    public ApiCallRequestInfoDto(HashMap<String, Object> baseParamsMap){

    }

}
