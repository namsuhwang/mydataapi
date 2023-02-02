package com.albee.mydataapi.api.common.org.models;

import com.albee.mydataapi.api.common.org.models.entity.OrgMstEntity;
import com.albee.mydataapi.api.common.org.models.form.OrgMstForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class OrgMstSearch extends SearchDto {
    private String orgCd;    // 기관코드
    private String orgType;    // 기관유형
    private String idstType;    // 업권 유형

    public OrgMstSearch(String orgCd, String orgType, String idstType) {
        this.orgCd = orgCd;
        this.orgType = orgType;
        this.idstType = idstType;
    }

    public OrgMstSearch(OrgMstEntity entity) {
        this.orgCd = entity.getOrgCd();
        this.orgType = entity.getOrgType();
        this.idstType = entity.getIdstType();
    }

    public OrgMstSearch(OrgMstForm form) {
        this.orgCd = form.getOrgCd();
        this.orgType = form.getOrgType();
        this.idstType = form.getIdstType();
    }
}
