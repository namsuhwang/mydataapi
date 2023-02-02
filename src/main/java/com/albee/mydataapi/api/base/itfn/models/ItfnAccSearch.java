package com.albee.mydataapi.api.base.itfn.models;

import com.albee.mydataapi.api.base.itfn.models.entity.ItfnAccEntity;
import com.albee.mydataapi.api.base.itfn.models.form.ItfnAccForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class ItfnAccSearch extends SearchDto {
    private String accountNum;    // 계좌번호

    public ItfnAccSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public ItfnAccSearch(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public ItfnAccSearch(ItfnAccEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
    }

    public ItfnAccSearch(ItfnAccForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
    }
}
