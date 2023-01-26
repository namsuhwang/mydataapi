package com.kpcnc.mydataapi.api.common.gateway.models.res.ppay;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ResBaseDto;
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
public class Ppay003ResDto extends ResBaseDto {

    @JsonProperty("trans_cnt")
    private Integer listCnt;

    @JsonProperty("trans_list")
    private List<Ppay003ResDetailDto> list;

}
