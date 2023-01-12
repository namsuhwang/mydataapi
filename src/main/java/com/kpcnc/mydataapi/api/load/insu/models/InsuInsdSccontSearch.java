package com.kpcnc.mydataapi.api.load.insu.models;

import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdSccontEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdSccontForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuInsdSccontSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private String contractName;    // 특약명

    public InsuInsdSccontSearch(String memberId, String orgCd, String insuNum, String contractName) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.insuNum = insuNum;
        this.contractName = contractName;
    }

    public InsuInsdSccontSearch(InsuInsdSccontEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.insuNum = entity.getInsuNum();
        this.contractName = entity.getContractName();
    }

    public InsuInsdSccontSearch(InsuInsdSccontForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.insuNum = form.getInsuNum();
        this.contractName = form.getContractName();
    }
}
