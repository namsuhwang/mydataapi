package com.kpcnc.mydataapi.api.common.gateway.models.res.ppay;

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
public class Ppay004ResDto extends ResBaseDto {

    @JsonProperty("approved_cnt")
    private Integer listCnt;

    @JsonProperty("approved_list")
    private List<Ppay004ResDetailDto> list;

}
