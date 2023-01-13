package com.kpcnc.mydataapi.api.base.tele.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TelePayEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String mgmtId;    // 계약관리번호
    private String transDate;    // 이용일시
    private BigDecimal transAmt;    // 결제금액
    private String orgRegno;    // 가맹점 사업자번호
    private String merchantName;    // 가맹점명
    private String transTitle;    // 결제상품명
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
