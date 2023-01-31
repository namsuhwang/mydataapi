package com.kpcnc.mydataapi.api.base.insu.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuLoanHistIntEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String transNo;    // 거래번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String intStartDate;    // 이자적용시작 일
    private String intEndDate;    // 이자적용종료 일
    private Float intRate;    // 적용이율
    private String intType;    // 이자종류 (코드)
}
