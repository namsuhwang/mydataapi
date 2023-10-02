package com.albee.mydataapi.api.common.api.models;

import com.albee.mydataapi.api.common.api.models.entity.ApiMstEntity;
import com.albee.mydataapi.api.common.api.models.form.ApiMstForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class ApiMstSearch extends SearchDto {
    private String apiType;    // API 유형
    private String apiId;    // API ID
    private String idstType;    // 업권 유형
    private String scope;    // scope

    public ApiMstSearch(String apiType, String apiId, String idstType) {
        this.apiType = apiType;
        this.apiId = apiId;
        this.idstType = idstType;
    }

    public ApiMstSearch(ApiMstEntity entity) {
        this.apiType = entity.getApiType();
        this.apiId = entity.getApiId();
        this.idstType = entity.getIdstType();
    }

    public ApiMstSearch(ApiMstForm form) {
        this.apiType = form.getApiType();
        this.apiId = form.getApiId();
        this.idstType = form.getIdstType();
    }

    public ApiMstSearch(String scope){
        this.scope = scope;
    }
}
