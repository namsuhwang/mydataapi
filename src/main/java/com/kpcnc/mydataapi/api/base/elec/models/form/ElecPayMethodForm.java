package com.kpcnc.mydataapi.api.base.elec.models.form;

import com.kpcnc.mydataapi.api.base.elec.models.entity.ElecPayMethodEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecPayMethodForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String subKey;    // Sub key
    private String payOrgCode;    // 결제수단 기관 (코드)
    private String payType;    // 결제수단 식별코드
    private String payId;    // 결제수단 식별키
    private String isPrimary;    // Primary 여부
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public ElecPayMethodEntity getEntity(){
        ElecPayMethodEntity entity = new ElecPayMethodEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setSubKey(subKey);
        entity.setPayOrgCode(payOrgCode);
        entity.setPayType(payType);
        entity.setPayId(payId);
        entity.setIsPrimary(isPrimary);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
