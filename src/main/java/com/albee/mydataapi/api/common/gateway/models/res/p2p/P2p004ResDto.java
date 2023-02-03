package com.albee.mydataapi.api.common.gateway.models.res.p2p;

import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import com.albee.mydataapi.api.common.gateway.models.res.ppay.Ppay004ResDetailDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class P2p004ResDto extends ResBaseDto {

    @JsonProperty("trans_cnt")
    private Integer listCnt;

    @JsonProperty("trans_list")
    private List<P2p004ResDetailDto> list;

}
