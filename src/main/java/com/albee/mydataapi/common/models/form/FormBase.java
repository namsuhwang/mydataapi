package com.albee.mydataapi.common.models.form;

import com.albee.mydataapi.common.CommUtil;
import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FormBase {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String apiTranDay;
    private String apiTranId;
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public FormBase(String memberId, String orgCd) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.apiTranDay = CommUtil.getCurrentDate8();
        this.regUserId = "user01";
        this.chgUserId = "user01";
    }

    public EntityBase getEntityBase(){
        EntityBase entity = new EntityBase();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setApiTranDay(apiTranDay);
        entity.setApiTranId(apiTranId);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
