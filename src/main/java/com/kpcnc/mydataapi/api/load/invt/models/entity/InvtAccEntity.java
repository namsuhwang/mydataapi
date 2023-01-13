package com.kpcnc.mydataapi.api.load.invt.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvtAccEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String isConsent;    // 전송요구 여부
    private String accountName;    // 계좌명
    private String accountType;    // 계좌종류(코드)
    private String issueDate;    // 계좌개설일
    private String isTaxBenefits;    // 세제혜택 적용여부(계좌)
    private String isCma;    // CMA상품포함 여부
    private String isStockTrans;    // 주식거래가능 여부
    private String isAccountLink;    // 은행예수금 방식계좌여부
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
