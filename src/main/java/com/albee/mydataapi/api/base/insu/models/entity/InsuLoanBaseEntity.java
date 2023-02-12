package com.albee.mydataapi.api.base.insu.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuLoanBaseEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String loanStartDate;    // 대출일
    private String loanExpDate;    // 만기일
    private String repayMethod;    // 상환방식(코드)
    private String insuNum;    // 증권번호
    private String repayOrgCode;    // 납입기관(코 드)
    private String repayAccountNum;    // 납입 계좌번호 (자동이체)
    private String repayDate;    // 월상환일
}
