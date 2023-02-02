package com.albee.mydataapi.api.base.ppay.models.entity;

import com.albee.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PpayAprHistEntity extends EntityBase {
    private String ppId;    // 선불카드 식별자
    private String approvedNum;    // 승인번호
    private String approvedDtime;    // 승인일시
    private String status;    // 결제상태 (코드)
    private String transDtime;    // 정정 또는 승인취소일시
    private String merchantName;    // 가맹점명
    private String merchantRegno;    // 가맹점 사업자등록번 호
    private Long approvedAmt;    // 이용금액
    private Long modifiedAmt;    // 정정후 금액
    private Integer totalInstallCnt;    // 전체 할부회차
}
