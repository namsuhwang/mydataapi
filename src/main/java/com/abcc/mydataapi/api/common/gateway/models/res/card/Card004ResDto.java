package com.abcc.mydataapi.api.common.gateway.models.res.card;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Card004ResDto extends ResBaseDto {

    @JsonProperty("bill_cnt")
    private Integer listCnt;

    @JsonProperty("bill_list")
    private List<Card004ResDetailDto> list;

}
