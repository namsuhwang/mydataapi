package com.kpcnc.mydataapi.api.load.insu.models.form;

import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuLoanEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuLoanForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String prodName;    // 상품명
    private String isConsent;    // 전송요구 여부
    private String accountType;    // 계좌번호 별 구분 코드
    private String accountStatus;    // 계좌번호 별 상태 코드
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public InsuLoanEntity getEntity(){
        InsuLoanEntity entity = new InsuLoanEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setAccountNum(accountNum);
        entity.setProdName(prodName);
        entity.setIsConsent(isConsent);
        entity.setAccountType(accountType);
        entity.setAccountStatus(accountStatus);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
