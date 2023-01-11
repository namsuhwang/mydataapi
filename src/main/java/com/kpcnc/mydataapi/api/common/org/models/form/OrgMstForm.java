package com.kpcnc.mydataapi.api.common.org.models.form;

import com.kpcnc.mydataapi.api.common.org.models.entity.OrgMstEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrgMstForm{
    private String orgCd;    // 기관코드
    private String orgType;    // 기관유형
    private String idstType;    // 업권 유형
    private String orgNm;    // 기관명
    private String orgShortNm;    // 기관축약명
    private String orgStatus;    // 기관상태
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public OrgMstEntity getEntity(){
        OrgMstEntity entity = new OrgMstEntity();
        entity.setOrgCd(orgCd);
        entity.setOrgType(orgType);
        entity.setIdstType(idstType);
        entity.setOrgNm(orgNm);
        entity.setOrgShortNm(orgShortNm);
        entity.setOrgStatus(orgStatus);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
