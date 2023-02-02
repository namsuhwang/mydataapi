package com.abcc.mydataapi.api.common.gateway.models.dto;

import com.abcc.mydataapi.api.common.member.models.member.entity.MemberTokenEntity;
import com.abcc.mydataapi.common.CommUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiCallReqDto {
    private String memberId;    // 회원ID
    private String accessToken;  // 접근토큰
    private String refreshToken;  // 리프레쉬 토큰
    private String orgCd;
    private String memberCi;
    private MemberTokenEntity memberToken;
    private String idstType;   // 업권유형 ( 예 : BANK)
    private String requestApiId;   // 호출 API ID (예 : BANK_001)
    private String requestUrl;   // 호출 API 의 resource url
    private String recvSeq;   // 수신 일련번호. recvStatus.recvSeq
    private String apiTranDay;
    private String apiTranId;
    private HashMap<String, Object> reqParamMap;
    private String reqParamJson;

    public ApiCallReqDto(MemberTokenEntity token) {
        this.memberId = token.getMemberId();
        this.idstType = CommUtil.getIdstTypeByScope(token.getScopeList().split(" ")[0]);
    }

    public ApiCallReqDto(HashMap<String, Object> baseParamsMap){

    }

    public void setReqParamJson(HashMap<String, Object> map){
        try {
            this.reqParamJson = new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
