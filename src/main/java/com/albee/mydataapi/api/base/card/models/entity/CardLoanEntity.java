package com.albee.mydataapi.api.base.card.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardLoanEntity extends EntityBase {
    private String isLoanShortTerm;    // 단기대출 (여부)
    private String isLoanLongTerm;    // 장기대출 (여부)
}
