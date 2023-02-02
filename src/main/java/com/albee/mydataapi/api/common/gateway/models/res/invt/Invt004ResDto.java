package com.albee.mydataapi.api.common.gateway.models.res.invt;

import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.invt.models.form.InvtAccProdBaseDateForm;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Invt004ResDto extends ResBaseDto {

    private String baseDate;

    @JsonProperty("prod_cnt")
    private Integer listCnt;

    @JsonProperty("prod_list")
    private List<Invt004ResDetailDto> list;

    public InvtAccProdBaseDateForm getForm(FormBase formBase, String accountNum){
        InvtAccProdBaseDateForm form = new InvtAccProdBaseDateForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setBaseDate(baseDate);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
