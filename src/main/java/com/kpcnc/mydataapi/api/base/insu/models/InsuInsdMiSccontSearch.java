package com.kpcnc.mydataapi.api.base.insu.models;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdMiSccontEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuInsdMiSccontForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuInsdMiSccontSearch extends SearchDto {
    private String insuNum;    // 증권번호
    private String insuredNo;    // 피보험인/물 번호
    private String contractName;    // 특약명

    public InsuInsdMiSccontSearch(String memberId, String orgCd, String insuNum, String insuredNo) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
        this.insuredNo = insuredNo;
    }

    public InsuInsdMiSccontSearch(String memberId, String orgCd, String insuNum, String insuredNo, String contractName) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
        this.insuredNo = insuredNo;
        this.contractName = contractName;
    }

    public InsuInsdMiSccontSearch(InsuInsdMiSccontEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.insuNum = entity.getInsuNum();
        this.insuredNo = entity.getInsuredNo();
        this.contractName = entity.getContractName();
    }

    public InsuInsdMiSccontSearch(InsuInsdMiSccontForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.insuNum = form.getInsuNum();
        this.insuredNo = form.getInsuredNo();
        this.contractName = form.getContractName();
    }
}
