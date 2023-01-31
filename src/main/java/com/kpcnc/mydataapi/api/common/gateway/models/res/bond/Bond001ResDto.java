package com.kpcnc.mydataapi.api.common.gateway.models.res.bond;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ppay.Ppay001ResDetailDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Bond001ResDto extends ResBaseDto {

    @JsonProperty("bond_cnt")
    private Integer listCnt;

    @JsonProperty("bond_list")
    private List<Bond001ResDetailDto> list;

}
