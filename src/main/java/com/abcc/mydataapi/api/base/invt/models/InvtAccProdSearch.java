package com.abcc.mydataapi.api.base.invt.models;

import com.abcc.mydataapi.api.base.invt.models.entity.InvtAccProdEntity;
import com.abcc.mydataapi.api.base.invt.models.form.InvtAccProdForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class InvtAccProdSearch extends SearchDto {
    private String accountNum;    // 계좌번호
    private String prodType;    // 상품종류 (코드)
    private String prodTypeDetail;    // 상품종류 상세
    private String prodCode;    // 종목코드 (상품코드)
    private String exCode;    // 거래소 코드

    public InvtAccProdSearch(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public InvtAccProdSearch(String memberId, String orgCd, String accountNum, String prodType, String prodTypeDetail, String prodCode, String exCode) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.prodType = prodType;
        this.prodTypeDetail = prodTypeDetail;
        this.prodCode = prodCode;
        this.exCode = exCode;
    }

    public InvtAccProdSearch(InvtAccProdEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
        this.prodType = entity.getProdType();
        this.prodTypeDetail = entity.getProdTypeDetail();
        this.prodCode = entity.getProdCode();
        this.exCode = entity.getExCode();
    }

    public InvtAccProdSearch(InvtAccProdForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
        this.prodType = form.getProdType();
        this.prodTypeDetail = form.getProdTypeDetail();
        this.prodCode = form.getProdCode();
        this.exCode = form.getExCode();
    }
}
