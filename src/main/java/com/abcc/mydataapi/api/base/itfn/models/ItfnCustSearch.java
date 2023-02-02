package com.abcc.mydataapi.api.base.itfn.models;

import com.abcc.mydataapi.common.models.dto.SearchDto;
import com.abcc.mydataapi.api.base.itfn.models.entity.ItfnCustEntity;
import com.abcc.mydataapi.api.base.itfn.models.form.ItfnCustForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class ItfnCustSearch extends SearchDto {
    private String regDate;    // 최초고객DB 생성일

    public ItfnCustSearch(String memberId, String orgCd, String regDate) {
        super(memberId, orgCd);
        this.regDate = regDate;
    }

    public ItfnCustSearch(ItfnCustEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.regDate = entity.getRegDate();
    }

    public ItfnCustSearch(ItfnCustForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.regDate = form.getRegDate();
    }
}
