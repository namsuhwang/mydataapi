package com.kpcnc.mydataapi.api.load.bank.models.form;

import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String isConsent;    // 전송요구 여부
    private String seqno;    // 회차번호
    private String isForeignDeposit;    // 외화계좌여부
    private String prodName;    // 상품명
    private String isMinus;    // 마이너스약정 여부
    private String accountType;    // 계좌구분 (코드)
    private String accountStatus;    // 계좌상태 (코드)
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public BankAccEntity getEntity(){
        BankAccEntity entity = new BankAccEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setAccountNum(accountNum);
        entity.setIsConsent(isConsent);
        entity.setSeqno(seqno);
        entity.setIsForeignDeposit(isForeignDeposit);
        entity.setProdName(prodName);
        entity.setIsMinus(isMinus);
        entity.setAccountType(accountType);
        entity.setAccountStatus(accountStatus);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
