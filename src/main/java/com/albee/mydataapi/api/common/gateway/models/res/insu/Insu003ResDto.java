package com.albee.mydataapi.api.common.gateway.models.res.insu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Insu003ResDto extends ResBaseDto {

    @JsonProperty("contract_cnt")
    private Integer listCnt;

    @JsonProperty("contract_list")
    private List<Insu003ResDetailDto> list;

}
