package com.abcc.mydataapi.api.base.itfn.models.entity;

import com.abcc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItfnLeaseEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String issueDate;    // 대출일
    private String expDate;    // 만기일
    private String repayDate;    // 월상환일
    private String repayMethod;    // 상환방식 (코드)
    private String repayOrgCode;    // 자동이체 기관 (코드)
    private String repayAccountNum;    // 상환계좌번호 (자동이체)
    private String nextRepayDate;    // 다음 납일 예정일
}
