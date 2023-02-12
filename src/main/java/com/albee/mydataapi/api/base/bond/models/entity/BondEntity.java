package com.albee.mydataapi.api.base.bond.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BondEntity extends EntityBase {
    private String bondNum;    // 채권번호
    private String isConsent;    // 전송요구여부
    private String bondType;    // 기관분류 (코드)
    private String takeoverDate;    // 채권인수일/ 특수채권편입 일/최초대출 일
    private String initOrgCode;    // 최초 대출기관
}
