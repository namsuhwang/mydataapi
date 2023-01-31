package com.kpcnc.mydataapi.api.base.bank.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccFundEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String standardFundCode;    // 표준펀드코드
    private String paidInType;    // 납입유형 (코드)
    private String issueDate;    // 개설일
    private String expDate;    // 만기일
}
