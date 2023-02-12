package com.albee.mydataapi.api.base.gurt.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GurtHistEntity extends EntityBase {
    private String insuNum;    // 증권번호
    private Integer paidInCnt;    // 납입회차
    private String transDate;    // 납입일자
    private Long paidAmt;    // 실납입 보험료
    private String payMethod;    // 수금방법 (코드)
}
