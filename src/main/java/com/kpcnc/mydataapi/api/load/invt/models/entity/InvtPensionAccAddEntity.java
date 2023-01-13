package com.kpcnc.mydataapi.api.load.invt.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvtPensionAccAddEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String prodType;    // 연금가입일
    private BigDecimal prodTypeDetail;    // 납부총액
    private BigDecimal prodCode;    // 기출금액
    private String exCode;    // 최종납입일
    private BigDecimal prodName;    // 연금기수령액
    private String posType;    // 연금개시(예정)일
    private BigDecimal creditType;    // 금년납입금
    private String isTaxBenefits;    // 통화코드
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
