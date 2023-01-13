package com.kpcnc.mydataapi.api.base.insu.models.form;

import com.kpcnc.mydataapi.api.InsuMiBasePpEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuMiBasePpForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private String isPerson;    // 인/물 구분코드
    private String prizeNum;    // 피보험인/물 번호
    private String prizeName;    // 피보험인/물 명
    private String isPrimary;    // 주피보험자 여부
    private String prizeAddr;    // 소재지
    private String objectCode;    // 물건구분 (코드)
    private String prizeCode;    // 목적물(코드)
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public InsuMiBasePpEntity getEntity(){
        InsuMiBasePpEntity entity = new InsuMiBasePpEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setInsuNum(insuNum);
        entity.setIsPerson(isPerson);
        entity.setPrizeNum(prizeNum);
        entity.setPrizeName(prizeName);
        entity.setIsPrimary(isPrimary);
        entity.setPrizeAddr(prizeAddr);
        entity.setObjectCode(objectCode);
        entity.setPrizeCode(prizeCode);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
