package com.kpcnc.mydataapi.api.base.insu.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private String isConsent;    // 전송요구 여부
    private String prodName;    // 상품명
    private String insuType;    // 보험종류 구분 (코드)
    private String insuStatus;    // 계약상태 (코드)
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public InsuEntity getEntity(){
        InsuEntity entity = new InsuEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setInsuNum(insuNum);
        entity.setIsConsent(isConsent);
        entity.setProdName(prodName);
        entity.setInsuType(insuType);
        entity.setInsuStatus(insuStatus);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
