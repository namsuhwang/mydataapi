package com.kpcnc.mydataapi.api.load.irp.models.form;

import com.kpcnc.mydataapi.api.load.irp.models.entity.IrpAccHistEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IrpAccHistForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transType;    // 거래구분
    private String transNo;    // 거래번호
    private Long transAmt;    // 거래금액
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public IrpAccHistEntity getEntity(){
        IrpAccHistEntity entity = new IrpAccHistEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setAccountNum(accountNum);
        entity.setTransDtime(transDtime);
        entity.setTransType(transType);
        entity.setTransNo(transNo);
        entity.setTransType(transType);
        entity.setTransAmt(transAmt);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
