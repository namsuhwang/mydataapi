package com.kpcnc.mydataapi.api.base.elec.models.form;

import com.kpcnc.mydataapi.api.base.elec.models.entity.ElecPpayBalEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecPpayBalForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String fobId;    // 권면 ID
    private String accountId;    // 계정식별값
    private BigDecimal totalBalanceAmt;    // 총잔액
    private BigDecimal chargeBalanceAmt;    // 충전포인트 잔액
    private BigDecimal reserveBalanceAmt;    // 적립포인트 잔액
    private BigDecimal withdrawableAmt;    // 출금 가능액
    private BigDecimal reserveDueAmt;    // 적립예정
    private BigDecimal expDueAmt;    // 소멸예정
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public ElecPpayBalEntity getEntity(){
        ElecPpayBalEntity entity = new ElecPpayBalEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setFobId(fobId);
        entity.setAccountId(accountId);
        entity.setTotalBalanceAmt(totalBalanceAmt);
        entity.setChargeBalanceAmt(chargeBalanceAmt);
        entity.setReserveBalanceAmt(reserveBalanceAmt);
        entity.setWithdrawableAmt(withdrawableAmt);
        entity.setReserveDueAmt(reserveDueAmt);
        entity.setExpDueAmt(expDueAmt);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
