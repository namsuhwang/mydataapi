package com.kpcnc.mydataapi.api.common.api.models;

import com.kpcnc.mydataapi.api.common.api.models.entity.ApiMstEntity;
import com.kpcnc.mydataapi.api.common.api.models.form.ApiMstForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ApiMstSearch extends SearchDto {
    private String apiType;    // API 유형
    private String apiId;    // API ID
    private String idstType;    // 업권 유형

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
}
