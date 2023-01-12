package com.kpcnc.mydataapi.api.load.insu.models.form;

import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuSccontEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuSccontForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private String insuredNo;    // 피보험자 번호
    private String contractName;    // 특약명
    private String contractStatus;    // 특약의 상태 (코드)
    private String contractExpDate;    // 특약만기일자
    private BigDecimal contractFaceAmt;    // 특약가입금액
    private String currencyCode;    // 통화코드(특 약가입금액)
    private String isRequired;    // 특약의 유형 (여부)
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public InsuSccontEntity getEntity(){
        InsuSccontEntity entity = new InsuSccontEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setInsuNum(insuNum);
        entity.setInsuredNo(insuredNo);
        entity.setContractName(contractName);
        entity.setContractStatus(contractStatus);
        entity.setContractExpDate(contractExpDate);
        entity.setContractFaceAmt(contractFaceAmt);
        entity.setCurrencyCode(currencyCode);
        entity.setIsRequired(isRequired);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
