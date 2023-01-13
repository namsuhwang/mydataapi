package com.kpcnc.mydataapi.api.base.elec.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecPpayEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String fobId;    // 권면 ID
    private String fobName;    // 권면명
    private String isConsent;    // 전송요구 여부
    private String regDate;    // 가입일자
    private Integer limitAmt;    // 권면한도
    private String isCharge;    // 자동충전 등록 여부
    private String isWithdrawable;    // 출금 가능 여부
    private Integer currencyCode;    // 통화코드
    private Integer accountCnt;    // 계정수
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
