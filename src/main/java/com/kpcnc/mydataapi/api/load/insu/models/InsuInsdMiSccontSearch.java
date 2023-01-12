package com.kpcnc.mydataapi.api.load.insu.models;

import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdMiSccontEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdMiSccontForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuInsdMiSccontSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private String prizeNum;    // 피보험인/물 번호
    private String contractName;    // 특약명

    public InsuInsdMiSccontSearch(String memberId, String orgCd, String insuNum, String prizeNum, String contractName) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.insuNum = insuNum;
        this.prizeNum = prizeNum;
        this.contractName = contractName;
    }

    public InsuInsdMiSccontSearch(InsuInsdMiSccontEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.insuNum = entity.getInsuNum();
        this.prizeNum = entity.getPrizeNum();
        this.contractName = entity.getContractName();
    }

    public InsuInsdMiSccontSearch(InsuInsdMiSccontForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.insuNum = form.getInsuNum();
        this.prizeNum = form.getPrizeNum();
        this.contractName = form.getContractName();
    }
}
