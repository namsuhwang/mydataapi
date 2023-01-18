package com.kpcnc.mydataapi.api.common.recv.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecvBaselineEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String apiId;    // API ID
    private String apiTranDay;    // 거래일자
    private String apiTranId;    // 거래고유번호
    private String searchTimeStamp;    // 조회타임스탬프
    private String nextPage;    // 최종 수신 데이터
    private String lastRecvDt;    // 최종 수신 일시
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
