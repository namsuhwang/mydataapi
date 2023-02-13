package com.albee.mydataapi.api.base.insu.models;

import com.albee.mydataapi.api.base.insu.models.entity.InsuSccontEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuSccontForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class InsuSccontSearch extends SearchDto {
    private String insuNum;    // 증권번호
    private String insuredNo;    // 피보험자 번호
    private String contractName;    // 특약명

    public InsuSccontSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public InsuSccontSearch(String memberId, String orgCd, String insuNum, String insuredNo) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
        this.insuredNo = insuredNo;
    }

    public InsuSccontSearch(String memberId, String orgCd, String insuNum, String insuredNo, String contractName) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
        this.insuredNo = insuredNo;
        this.contractName = contractName;
    }

    public InsuSccontSearch(InsuSccontEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.insuNum = entity.getInsuNum();
        this.insuredNo = entity.getInsuredNo();
        this.contractName = entity.getContractName();
    }

    public InsuSccontSearch(InsuSccontForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.insuNum = form.getInsuNum();
        this.insuredNo = form.getInsuredNo();
        this.contractName = form.getContractName();
    }
}
