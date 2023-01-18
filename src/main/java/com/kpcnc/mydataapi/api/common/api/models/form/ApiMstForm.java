package com.kpcnc.mydataapi.api.common.api.models.form;

import com.kpcnc.mydataapi.api.common.api.models.entity.ApiMstEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiMstForm{
    private String apiType;    // API 유형
    private String apiId;    // API ID
    private String idstType;    // 업권 유형
    private String scope;    // SCOPE
    private String requestType;    // 요청 유형
    private String idstBm;    // 업권명
    private String apiNm;    // API명
    private String apiContent;    // API 내용
    private String apiUrlResource;    // API URL 리소스
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public ApiMstEntity getEntity(){
        ApiMstEntity entity = new ApiMstEntity();
        entity.setApiType(apiType);
        entity.setApiId(apiId);
        entity.setIdstType(idstType);
        entity.setScope(scope);
        entity.setRequestType(requestType);
        entity.setIdstBm(idstBm);
        entity.setApiNm(apiNm);
        entity.setApiContent(apiContent);
        entity.setApiUrlResource(apiUrlResource);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
