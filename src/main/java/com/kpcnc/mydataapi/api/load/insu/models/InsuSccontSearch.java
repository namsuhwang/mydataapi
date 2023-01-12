package com.kpcnc.mydataapi.api.load.insu.models;

import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuSccontEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuSccontForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuSccontSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private String insuredNo;    // 피보험자 번호
    private String contractName;    // 특약명

    public InsuSccontSearch(String memberId, String orgCd, String insuNum, String insuredNo, String contractName) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.insuNum = insuNum;
        this.insuredNo = insuredNo;
        this.contractName = contractName;
    }

    public InsuSccontSearch(InsuSccontEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.insuNum = entity.getInsuNum();
        this.insuredNo = entity.getInsuredNo();
        this.contractName = entity.getContractName();
    }

    public InsuSccontSearch(InsuSccontForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.insuNum = form.getInsuNum();
        this.insuredNo = form.getInsuredNo();
        this.contractName = form.getContractName();
    }
}
