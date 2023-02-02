package com.albee.mydataapi.api.common.gateway.models.res.card;

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
public class Card008ResDto extends ResBaseDto {

    @JsonProperty("approved_cnt")
    private Integer listCnt;

    @JsonProperty("approved_list")
    private List<Card008ResDetailDto> list;

}
