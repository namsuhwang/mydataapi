package com.abcc.mydataapi.api.common.gateway.models.entity;

import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class EntityBase {
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String apiTranDay;
    private String apiTranId;
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public EntityBase(FormBase formBase) {
        this.setMemberId(formBase.getMemberId());
        this.setOrgCd(formBase.getOrgCd());
        this.setApiTranDay(formBase.getApiTranDay());
        this.setApiTranId(formBase.getApiTranId());
        this.setRegUserId(formBase.getRegUserId());
        this.setRegDt(formBase.getRegDt());
        this.setChgUserId(formBase.getChgUserId());
        this.setChgDt(formBase.getChgDt());
    }
}
