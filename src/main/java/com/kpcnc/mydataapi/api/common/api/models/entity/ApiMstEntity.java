package com.kpcnc.mydataapi.api.common.api.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiMstEntity{
    private Long rowNum;
    private String apiType;    // API 유형
    private String apiId;    // API ID
    private String idstType;    // 업권 유형
    private String scope;    // SCOPE
    private String rquestType;    // 요청 유형
    private String idstBm;    // 업권명
    private String apiNm;    // API명
    private String apiContent;    // API 내용
    private String apiUrlResource;    // API URL 리소스
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
