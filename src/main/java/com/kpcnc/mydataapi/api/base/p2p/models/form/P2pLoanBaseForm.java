package com.kpcnc.mydataapi.api.base.p2p.models.form;

import com.kpcnc.mydataapi.api.base.p2p.models.entity.P2pLoanBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class P2pLoanBaseForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String lendingId;    // 대출계약번호
    private String expDate;    // 만기일
    private Float offeredRate;    // 대출금리
    private String repayMethod;    // 상환방식 (코드)
    private Float ltvRate;    // 부동산담보 LTV 비율
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public P2pLoanBaseEntity getEntity(){
        P2pLoanBaseEntity entity = new P2pLoanBaseEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setLendingId(lendingId);
        entity.setExpDate(expDate);
        entity.setOfferedRate(offeredRate);
        entity.setRepayMethod(repayMethod);
        entity.setLtvRate(ltvRate);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
