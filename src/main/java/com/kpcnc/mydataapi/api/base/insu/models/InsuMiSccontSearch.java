package com.kpcnc.mydataapi.api.base.insu.models;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuMiSccontEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiSccontForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuMiSccontSearch extends SearchDto {
    private String insuNum;    // 증권번호
    private String insuredNo;    // 피보험인/물 번호
    private String contractName;    // 특약명

    public InsuMiSccontSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public InsuMiSccontSearch(String memberId, String orgCd, String insuNum, String insuredNo) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
        this.insuredNo = insuredNo;
    }

    public InsuMiSccontSearch(String memberId, String orgCd, String insuNum, String insuredNo, String contractName) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
        this.insuredNo = insuredNo;
        this.contractName = contractName;
    }

    public InsuMiSccontSearch(InsuMiSccontEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.insuNum = entity.getInsuNum();
        this.insuredNo = entity.getInsuredNo();
        this.contractName = entity.getContractName();
    }

    public InsuMiSccontSearch(InsuMiSccontForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.insuNum = form.getInsuNum();
        this.insuredNo = form.getInsuredNo();
        this.contractName = form.getContractName();
    }
}
