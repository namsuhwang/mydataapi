package com.abcc.mydataapi.api.common.recv.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecvHistDetailEntity{
    private Long rowNum;
    private String recvSeq;    // 수신 ID
    private Long recvDetailSeq;    // 수신 상세 일련번호
    private String recvData;    // 수신데이터
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
