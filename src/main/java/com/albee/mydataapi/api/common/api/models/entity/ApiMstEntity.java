package com.albee.mydataapi.api.common.api.models.entity;

import com.albee.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiMstEntity extends EntityBase {
    private Long rowNum;
    private String apiType;    // API 유형
    private String apiId;    // API ID
    private String idstType;    // 업권 유형
    private String scope;    // SCOPE
    private String requestType;    // 요청 유형. L:자산목록, B:자산원장, A:자산원장 추가정보(필요시 사용), H:자산이력
    private String idstBm;    // 업권명
    private String apiNm;    // API명
    private String apiContent;    // API 내용
    private String apiUrlResource;    // API URL 리소스
}
