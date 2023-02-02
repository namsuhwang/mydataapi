package com.albee.mydataapi.api.base.card.models.entity;

import com.albee.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardLoanStEntity extends EntityBase {
    private String loanDtime;    // 이용일시
    private Long loanAmt;    // 이용금액(취급액)
    private Long balanceAmt;    // 단기대출 잔액
    private String payDueDate;    // 결제예정일
    private Float intRate;    // 이자율
    private String repayOrgCode;    // 상환기관 (코드)
    private String repayAccountNum;    // 상환계좌번호 
}
