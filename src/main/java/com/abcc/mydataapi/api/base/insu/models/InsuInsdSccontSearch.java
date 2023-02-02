package com.abcc.mydataapi.api.base.insu.models;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuInsdSccontEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuInsdSccontForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuInsdSccontSearch extends SearchDto {
    private String insuNum;    // 증권번호
    private String contractName;    // 특약명

    public InsuInsdSccontSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public InsuInsdSccontSearch(String memberId, String orgCd, String insuNum) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
    }

    public InsuInsdSccontSearch(String memberId, String orgCd, String insuNum, String contractName) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
        this.contractName = contractName;
    }

    public InsuInsdSccontSearch(InsuInsdSccontEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.insuNum = entity.getInsuNum();
        this.contractName = entity.getContractName();
    }

    public InsuInsdSccontSearch(InsuInsdSccontForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.insuNum = form.getInsuNum();
        this.contractName = form.getContractName();
    }
}
