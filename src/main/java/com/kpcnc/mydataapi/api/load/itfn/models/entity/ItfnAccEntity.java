package com.kpcnc.mydataapi.api.load.itfn.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItfnAccEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String isConsent;    // 전송요구 여부
    private String seqno;    // 회차번호
    private String prodName;    // 상품명
    private String accountType;    // 계좌구분 (코드)
    private String accountStatus;    // 계좌상태 (코드)
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
