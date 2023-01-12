package com.kpcnc.mydataapi.api.load.dc.models.form;

import com.kpcnc.mydataapi.api.load.dc.models.entity.DcEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DcForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String dcNum;    // 상품관리번호
    private String dcName;    // 상품명
    private String isConsent;    // 전송요구 여부
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public DcEntity getEntity(){
        DcEntity entity = new DcEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setDcNum(dcNum);
        entity.setDcName(dcName);
        entity.setIsConsent(isConsent);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
