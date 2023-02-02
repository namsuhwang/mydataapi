package com.albee.mydataapi.api.common.api.models.form;

import com.albee.mydataapi.api.common.api.models.entity.ApiMstEntity;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiMstForm extends FormBase {
    private String apiType;    // API 유형
    private String apiId;    // API ID
    private String idstType;    // 업권 유형
    private String scope;    // SCOPE
    private String requestType;    // 요청 유형
    private String idstBm;    // 업권명
    private String apiNm;    // API명
    private String apiContent;    // API 내용
    private String apiUrlResource;    // API URL 리소스

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
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
