package com.kpcnc.mydataapi.api.common.gateway.models.res.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Bank013ResDto extends ResBaseDto {

    @JsonProperty("isa_cnt")
    private Integer listCnt;

    @JsonProperty("isa_list")
    private List<Bank013ResDetailDto> list;

}
