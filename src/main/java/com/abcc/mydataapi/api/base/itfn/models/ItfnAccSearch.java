package com.abcc.mydataapi.api.base.itfn.models;

import com.abcc.mydataapi.api.base.itfn.models.entity.ItfnAccEntity;
import com.abcc.mydataapi.api.base.itfn.models.form.ItfnAccForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
