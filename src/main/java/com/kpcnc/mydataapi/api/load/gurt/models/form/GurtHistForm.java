package com.kpcnc.mydataapi.api.load.gurt.models.form;

import com.kpcnc.mydataapi.api.load.gurt.models.entity.GurtHistEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GurtHistForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private Integer paidInCnt;    // 납입회차
    private String transDate;    // 납입일자
    private Long paidAmt;    // 실납입 보험료
    private String payMethod;    // 수금방법 (코드)
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public GurtHistEntity getEntity(){
        GurtHistEntity entity = new GurtHistEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setInsuNum(insuNum);
        entity.setPaidInCnt(paidInCnt);
        entity.setTransDate(transDate);
        entity.setPaidAmt(paidAmt);
        entity.setPayMethod(payMethod);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
