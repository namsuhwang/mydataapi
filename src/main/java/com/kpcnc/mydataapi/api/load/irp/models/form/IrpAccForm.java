package com.kpcnc.mydataapi.api.load.irp.models.form;

import com.kpcnc.mydataapi.api.load.irp.models.entity.IrpAccEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IrpAccForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String prodName;    // 상품명
    private String isConsent;    // 전송요구 여부
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public IrpAccEntity getEntity(){
        IrpAccEntity entity = new IrpAccEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setAccountNum(accountNum);
        entity.setProdName(prodName);
        entity.setIsConsent(isConsent);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
